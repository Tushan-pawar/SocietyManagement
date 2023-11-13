<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
package com.springboot.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.main.model.VisitorLog;
import com.springboot.main.service.GatekeeperService;
import com.springboot.main.service.ResidentService;
import com.springboot.main.service.VisitorLogService;

@Controller
@RequestMapping("/visitorlogs")
public class VisitorLogController {
	@Autowired
	private VisitorLogService visitorLogService; 
	@Autowired
	private GatekeeperService gatekeeperService;
	@Autowired
	private ResidentService residentService;
	@PostMapping("/add")
	public VisitorLog insertVisitorLog(@RequestBody VisitorLog visitorLog) {
		visitorLog= visitorLogService.insert(visitorLog);
	    return visitorLog;
	}
<<<<<<< HEAD
}
=======
}
=======
package com.springboot.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.main.model.VisitorLog;
import com.springboot.main.service.GateKeeperService;
import com.springboot.main.service.ResidentService;
import com.springboot.main.service.VisitorLogService;

@Controller
@RequestMapping("/visitorlogs")
public class VisitorLogController {
	@Autowired
	private VisitorLogService visitorLogService; 
	@Autowired
	private GateKeeperService gateKeeperService;
	@Autowired
	private ResidentService residentService;
	@PostMapping("/add")
	public VisitorLog insertVisitorLog(@RequestBody VisitorLog visitorLog) {
		visitorLog= visitorLogService.insert(visitorLog);
	    return visitorLog;
	}
}
>>>>>>> bc1f25922778682115cb590275a680864198a72b
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
