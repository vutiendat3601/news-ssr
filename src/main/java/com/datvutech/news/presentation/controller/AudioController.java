package com.datvutech.news.presentation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/audio")
public class AudioController {
    @GetMapping("/test")
    public String getAudio() {
        return "audio";
    }
}
