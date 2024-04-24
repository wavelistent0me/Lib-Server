package com.example.libserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class PurchaseHistoryVo {
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    private String chapterName;

    private String bookName;

    private Date createTime;

    private int price;
}
