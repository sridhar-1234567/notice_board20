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

    public Notice update(Long id, Notice newNotice) {
        return repo.findById(id).map(existing -> {
            existing.setTitle(newNotice.getTitle());
            existing.setCategory(newNotice.getCategory());
            existing.setDescription(newNotice.getDescription());
            return repo.save(existing);
        }).orElseThrow(() -> new RuntimeException("Notice not found with id " + id));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
