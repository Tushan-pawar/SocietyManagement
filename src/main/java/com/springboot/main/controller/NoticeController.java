package com.springboot.main.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.main.model.Notice;
import com.springboot.main.service.NoticeService;


@Controller
@RequestMapping("/notices")
public class NoticeController {
@Autowired
private NoticeService noticeService;
@PostMapping("/add")
public Notice insertNotice(@RequestBody Notice notice) {
	notice=noticeService.insert(notice);
	return notice;
}

es")
public class NoticeController {
@Autowired
private NoticeService noticeService;
@PostMapping("/add")
public Notice insertNotice(@RequestBody Notice notice) {
	notice=noticeService.insert(notice);
	return notice;
}

}
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
=======
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
>>>>>>> 1d7f627400cf2ed935338c192d15398243bbc147
