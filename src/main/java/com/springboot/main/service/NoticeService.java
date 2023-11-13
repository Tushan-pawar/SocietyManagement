<<<<<<< HEAD
package com.springboot.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.model.Notice;
import com.springboot.main.repository.NoticeRepository;

@Service
public class NoticeService {
@Autowired
private NoticeRepository noticeRepository;
	public Notice insert(Notice notice) {
		// TODO Auto-generated method stub
		return noticeRepository.save(notice);
	}

<<<<<<< HEAD
<<<<<<< HEAD
}
=======
}
=======
=======
}
=======
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
package com.springboot.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.model.Notice;
import com.springboot.main.repository.NoticeRepository;
@Service
public class NoticeService {
@Autowired
private NoticeRepository noticeRepository;
	public Notice insert(Notice notice) {
		// TODO Auto-generated method stub
		return noticeRepository.save(notice);
	}

}
>>>>>>> bc1f25922778682115cb590275a680864198a72b
<<<<<<< HEAD
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
=======
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
