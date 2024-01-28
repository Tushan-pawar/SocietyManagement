package com.springboot.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.main.model.Notice;
import com.springboot.main.repository.NoticeRepository;

@Service
public class NoticeService {

    @Autowired
    private NoticeRepository noticeRepository;

    public Notice insert(Notice notice) {
        return noticeRepository.save(notice);
    }

    public Optional<Notice> findById(int id) {
        return noticeRepository.findById(id);
    }

    public Page<Notice> getAllNotices(Pageable pageable) {
        return noticeRepository.findAll(pageable);
    }
}
