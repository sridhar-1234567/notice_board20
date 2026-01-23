package com.example.demo.Service;

import com.example.demo.Entity.Notice;
import com.example.demo.Repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {
    @Autowired
    private NoticeRepository repo;

    public List<Notice> getAll() {
        return repo.findAll();
    }

    public Notice save(Notice notice) {
        return repo.save(notice);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}


