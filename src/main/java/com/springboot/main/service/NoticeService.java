package com.springboot.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	public List<Notice> getAllNotices() {
		return noticeRepository.findAll();
	}

}