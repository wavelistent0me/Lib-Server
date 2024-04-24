package com.example.libserver.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.libserver.common.AjaxResult;
import com.example.libserver.entity.Chapter;
import com.example.libserver.entity.PurchaseHistory;
import com.example.libserver.entity.PurchaseHistoryVo;
import com.example.libserver.service.IBookService;
import com.example.libserver.service.IChapterService;
import com.example.libserver.service.IPurchaseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author DXQ
 * @since 2024-01-22
 */
@RestController
@RequestMapping("/libserver/purchaseHistory")
public class PurchaseHistoryController {

    @Autowired
    private IPurchaseHistoryService purchaseHistoryService;
    @Autowired
    private IChapterService chapterService;
    @Autowired
    private IBookService bookService;

    @PostMapping("purchase")
    public AjaxResult purchase(@RequestBody PurchaseHistory purchaseHistory) {

        purchaseHistory.setCreateTime(new Date());

        purchaseHistoryService.save(purchaseHistory);

        return AjaxResult.Success();
    }

    @PostMapping("getPurchaseList")
    public AjaxResult getPurchaseList(@RequestBody PurchaseHistory purchaseHistory) {

        QueryWrapper<PurchaseHistory> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", purchaseHistory.getUserId());
        List<PurchaseHistory> purchaseHistoryList = purchaseHistoryService.list(wrapper);
        List<PurchaseHistoryVo> list = new ArrayList<>();
        for (int i = 0; i < purchaseHistoryList.size(); i++) {
            PurchaseHistoryVo purchaseHistoryVo = new PurchaseHistoryVo();
            Chapter chapter = chapterService.getById(purchaseHistoryList.get(i).getChapterId());
            purchaseHistoryVo.setChapterName(chapter.getTitle());
            purchaseHistoryVo.setBookName(bookService.getById(chapter.getBookId()).getName());
            purchaseHistoryVo.setCreateTime(purchaseHistoryList.get(i).getCreateTime());
            purchaseHistoryVo.setPrice(chapter.getPrice());
            list.add(purchaseHistoryVo);
        }

        HashMap<String, Object> map = new HashMap<>();
        map.put("list", list);

        return AjaxResult.Success(map);
    }

    @GetMapping("getAllCost")
    public AjaxResult getAllCost() {

        List<PurchaseHistory> list = purchaseHistoryService.list(null);
        HashMap<String, Object> map = new HashMap<>();
        map.put("list", list);

        return AjaxResult.Success(map);
    }
}

