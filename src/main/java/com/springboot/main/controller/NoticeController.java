package com.springboot.main.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.model.Notice;
import com.springboot.main.service.NoticeService;

@RestController
@RequestMapping("/notices")
@CrossOrigin(origins = { "http://localhost:3000" })
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	/* Add notice */
	@PostMapping("/addNotices")
	public Notice insertNotice(@RequestBody Notice notice) {
		return noticeService.insert(notice);
	}

	/* Get all notices */
	@GetMapping("/getallNotices")
	public Page<Notice> getAllNotices(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
			@RequestParam(value = "size", required = false, defaultValue = "3") Integer size) {
		Pageable pageable = PageRequest.of(page, size);
		return noticeService.getAllNotices(pageable);
	}

	/* Update Notices by id */
	@PutMapping("/updateNotices/{id}")
	public ResponseEntity<?> updateNotice(@PathVariable int id, @RequestBody Notice updatedNotice) {
		try {
			Optional<Notice> optionalNotice = noticeService.findById(id);
			if (optionalNotice.isPresent()) {
				Notice existingNotice = optionalNotice.get();
				if (updatedNotice.getContent() != null) {
				existingNotice.setContent(updatedNotice.getContent());}
				Notice updatedNoticeEntity = noticeService.insert(existingNotice);
				return ResponseEntity.ok().body(updatedNoticeEntity);} else {
				return ResponseEntity.notFound().build();}
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}