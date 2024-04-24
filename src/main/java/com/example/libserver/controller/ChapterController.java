package com.example.libserver.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.libserver.common.AjaxResult;
import com.example.libserver.entity.Book;
import com.example.libserver.entity.Chapter;
import com.example.libserver.entity.PurchaseHistory;
import com.example.libserver.service.IBookService;
import com.example.libserver.service.IChapterService;
import com.example.libserver.service.IPurchaseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author DXQ
 * @since 2023-12-01
 */
@RestController
@RequestMapping("/libserver/chapter")
public class ChapterController {
    @Autowired
    private IChapterService chapterService;
    @Autowired
    private IPurchaseHistoryService purchaseHistoryService;

    @PostMapping("addChapter")
    public AjaxResult addChapter(@RequestBody Chapter chapter) {
        chapterService.save(chapter);

        return AjaxResult.Success();
    }

    @PostMapping("getChapterList")
    public AjaxResult getChapterList(@RequestBody Chapter chapter, @RequestParam(required=false) String userId) {
        QueryWrapper<Chapter> wrapper = new QueryWrapper<>();
        wrapper.eq("book_id", chapter.getBookId());

        List<Chapter> list = chapterService.list(wrapper);

        for (int i = 0; i < list.size(); i++) {
            QueryWrapper<PurchaseHistory> phWrapper = new QueryWrapper<>();
            phWrapper.eq("user_id", userId);
            phWrapper.eq("chapter_id", list.get(i).getId());
            if (purchaseHistoryService.getOne(phWrapper) != null) {
                list.get(i).setIsPurchase(1);
            }
            else {
                list.get(i).setIsPurchase(0);
            }
        }

        HashMap<String, Object> map = new HashMap<>();
        map.put("list", list);

        return AjaxResult.Success(map);
    }

    @PostMapping("deleteChapter")
    public AjaxResult deleteBook(@RequestBody Chapter chapter) {
        chapterService.removeById(chapter.getId());

        return AjaxResult.Success();
    }

    @PostMapping("getChapterInfo")
    public AjaxResult getChapterInfo(@RequestBody Chapter chapter) {
        QueryWrapper<Chapter> wrapper = new QueryWrapper<>();
        wrapper.eq("id", chapter.getId());
        Chapter one = chapterService.getOne(wrapper);

        HashMap<String, Object> map = new HashMap<>();
        map.put("info", one);

        return AjaxResult.Success(map);
    }

    @PostMapping("editChapter")
    public AjaxResult editChapter(@RequestBody Chapter chapter) {
        chapterService.updateById(chapter);

        return AjaxResult.Success();
    }
}

