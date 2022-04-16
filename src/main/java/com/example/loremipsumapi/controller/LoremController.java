package com.example.loremipsumapi.controller;

import com.example.loremipsumapi.service.LoremService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoremController {

    private final LoremService loremService;

    @Autowired
    public LoremController(LoremService loremService) {
        this.loremService = loremService;
    }

    @GetMapping("/lorem")
    public String getLoremHTML(){
        return "lorem";
    }

    @GetMapping("/lorem/short")
    public ResponseEntity<String> getShortLorem(){
        return ResponseEntity.ok().body(loremService.getLoremShort());
    }

    @GetMapping("/lorem/long")
    public ResponseEntity<String> getLongLorem() {
        return ResponseEntity.ok().body(loremService.getLoremLong());
    }
}
