package com.example.demo.Controller;

import com.example.demo.Entity.Notice;
import com.example.demo.Service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notices")
@CrossOrigin(origins = "http://localhost:3000") // allow React frontend
public class NoticeController {
    @Autowired

    private NoticeService service;

    @GetMapping
    public List<Notice> getAll() { return service.getAll(); }

    @PostMapping
    public Notice create(@RequestBody Notice notice) { return service.save(notice); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}

