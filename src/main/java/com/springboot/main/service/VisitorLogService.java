<<<<<<< HEAD
package com.springboot.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.model.VisitorLog;
import com.springboot.main.repository.VisitorLogRepository;

@Service
public class VisitorLogService {
@Autowired 
private VisitorLogRepository visitorLogRepository;

public VisitorLog insert(VisitorLog visitorLog) {
	// TODO Auto-generated method stub
	return visitorLogRepository.save(visitorLog);
}
}
=======
package com.springboot.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.model.VisitorLog;
import com.springboot.main.repository.VisitorLogRepository;

@Service
public class VisitorLogService {
@Autowired 
private VisitorLogRepository visitorLogRepository;

public VisitorLog insert(VisitorLog visitorLog) {
	// TODO Auto-generated method stub
	return visitorLogRepository.save(visitorLog);
}
}
>>>>>>> bc1f25922778682115cb590275a680864198a72b
