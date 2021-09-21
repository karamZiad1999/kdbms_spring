package com.atypon.kdbms_spring.controller;

import com.atypon.kdbms_spring.domain.Payload;
import com.atypon.kdbms_spring.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

@Controller
public class TableController {
    @Autowired
    private RecordService recordService;

    @GetMapping("/{schema}/{table}/view")
    public String getTable(@PathVariable String schema, @PathVariable String table, Model model){
        Payload payload = recordService.getAllRecords(schema,table);
        model.addAttribute("payload", payload);
        model.addAttribute("schema", schema);
        model.addAttribute("table", table);
        return "main";
    }

    @GetMapping("/{schema}/{table}/insert")
    public String getInsert(@PathVariable String schema, @PathVariable String table, Model model){
        model.addAttribute("schema", schema);
        model.addAttribute("table", table);
        return "insert";
    }

    @PostMapping("/{schema}/{table}/insert")
    public String saveRecord(@ModelAttribute("values") String values, @PathVariable String schema, @PathVariable String table){
        recordService.InsertRecord(schema, table, values);
        String redirect = "redirect:/"+schema+"/"+table+"/view";
        return redirect;
    }

    @GetMapping("/{schema}/{table}/create")
    public String getCreate(@PathVariable String schema, @PathVariable String table, Model model){
        model.addAttribute("schema", schema);
        model.addAttribute("table", table);
        return "insert";
    }

    @PostMapping("/{schema}/{table}/create")
    public String create(@ModelAttribute("metaData") String metaData, @PathVariable String schema, @PathVariable String table){
        recordService.createTable(schema, table, metaData);
        String redirect = "redirect:/"+schema+"/"+table+"/view";
        return redirect;
    }

    @GetMapping("/{schema}/{table}/query")
    public String getQueryForm(@PathVariable String schema, @PathVariable String table, Model model){
        model.addAttribute("schema", schema);
        model.addAttribute("table", table);
        return "query";
    }

    @PostMapping("/{schema}/{table}/query")
    public String sendQuery(@ModelAttribute("metaData") String query, @PathVariable String schema, @PathVariable String table){
        recordService.sendQuery(schema, table, query);
        String redirect = "redirect:/"+schema+"/"+table+"/view";
        return redirect;
    }
}
