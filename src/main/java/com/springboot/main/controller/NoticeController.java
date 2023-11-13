<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
=======
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
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

<<<<<<< HEAD
<<<<<<< HEAD
}
=======
=======
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
}
=======
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

}
>>>>>>> bc1f25922778682115cb590275a680864198a72b
<<<<<<< HEAD
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
=======
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
