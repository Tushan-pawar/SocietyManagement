package com.springboot.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.model.Notice;
import com.springboot.main.service.NoticeService;

@RestController
@RequestMapping("/notices")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;

	@PostMapping("/add")
	public Notice insertNotice(@RequestBody Notice notice) {
		return noticeService.insert(notice);
	}


    @GetMapping("/getallnotices")
    public List<Notice> getAllNotices() {
        return noticeService.getAllNotices();
    }

}