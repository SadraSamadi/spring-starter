package com.sadrasamadi.springstarter.app;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class AppController {

  @GetMapping("/greet")
  public ResponseEntity<Map<String, Object>> greet(@RequestParam(defaultValue = "World") String name) {
    HashMap<String, Object> map = new HashMap<>();
    String msg = String.format("Hello, %s!", name);
    map.put("message", msg);
    return ResponseEntity.ok(map);
  }

}
