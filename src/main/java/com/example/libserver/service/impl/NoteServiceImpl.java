package com.example.libserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.libserver.entity.Book;
import com.example.libserver.entity.Chapter;
import com.example.libserver.entity.Note;
import com.example.libserver.entity.NoteInfoVo;
import com.example.libserver.mapper.NoteMapper;
import com.example.libserver.service.IBookService;
import com.example.libserver.service.IChapterService;
import com.example.libserver.service.INoteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author DXQ
 * @since 2023-12-04
 */
@Service
public class NoteServiceImpl extends ServiceImpl<NoteMapper, Note> implements INoteService {

    @Autowired
    private IChapterService chapterService;

    @Autowired
    private IBookService bookService;

    @Override
    public List<NoteInfoVo> getNoteList(Map map) {
        QueryWrapper<Note> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", map.get("userId"));

        List<Note> list = this.list(wrapper);

        List<NoteInfoVo> noteInfoVos = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            NoteInfoVo noteInfoVo = new NoteInfoVo();
            BeanUtils.copyProperties(list.get(i),noteInfoVo);
            QueryWrapper<Chapter> chapterQueryWrapper = new QueryWrapper<>();
            chapterQueryWrapper.eq("id", noteInfoVo.getChapterId());
            Chapter chapter = chapterService.getOne(chapterQueryWrapper);
            if (chapter != null) {
                noteInfoVo.setChapterName(chapter.getTitle());
                QueryWrapper<Book> bookQueryWrapper = new QueryWrapper<>();
                bookQueryWrapper.eq("id", chapter.getBookId());
                if (bookService.getOne(bookQueryWrapper) != null) {
                    noteInfoVo.setBookName(bookService.getOne(bookQueryWrapper).getName());
                    noteInfoVos.add(noteInfoVo);
                }
            }
        }

        return noteInfoVos;
    }
}
