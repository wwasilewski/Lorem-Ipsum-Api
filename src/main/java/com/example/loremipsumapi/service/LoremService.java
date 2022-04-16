package com.example.loremipsumapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoremService {

    private final LoremReader loremReader;

    @Autowired
    public LoremService(LoremReader loremReader) {
        this.loremReader = loremReader;
    }

    public String getLoremShort() {
        return loremReader.getShortLoremFromApi();
    }

    public String getLoremLong() {
        return loremReader.getLongLoremFromApi();
    }
}
