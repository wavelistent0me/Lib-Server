package com.example.libserver.service;

import com.example.libserver.entity.Note;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.libserver.entity.NoteInfoVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author DXQ
 * @since 2023-12-04
 */
public interface INoteService extends IService<Note> {

    List<NoteInfoVo> getNoteList(Map map);
}
