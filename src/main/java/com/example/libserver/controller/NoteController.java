package com.example.libserver.controller;
import com.example.libserver.common.AjaxResult;
import com.example.libserver.entity.Note;
import com.example.libserver.entity.NoteInfoVo;
import com.example.libserver.service.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author DXQ
 * @since 2023-12-04
 */
@RestController
@RequestMapping("/libserver/note")
public class NoteController {

    @Autowired
    private INoteService noteService;

    @PostMapping("addNote")
    public AjaxResult addNote(@RequestBody Note note) {
        noteService.save(note);

        return AjaxResult.Success();
    }

    @PostMapping("getNoteList")
    public AjaxResult getNoteList(@RequestBody Map map) {
        List<NoteInfoVo> list = noteService.getNoteList(map);
        HashMap<String, Object> r = new HashMap<>();
        r.put("list", list);

        return AjaxResult.Success(r);
    }

    @PostMapping("deleteNote")
    public AjaxResult deleteNote(@RequestBody Note note) {
        noteService.removeById(note.getId());

        return AjaxResult.Success();
    }
}

