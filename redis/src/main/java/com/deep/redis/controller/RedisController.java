package com.deep.redis.controller;

import com.deep.redis.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/redis")
public class RedisController {
    private final RedisService redisService;

    @PostMapping("/save")
    public String save(@RequestParam String key, @RequestParam String value) {
        redisService.saveData(key, value);
        return "Data saved";
    }

    @GetMapping("/get")
    public String get(@RequestParam String key) {
        return redisService.getData(key);
    }
}