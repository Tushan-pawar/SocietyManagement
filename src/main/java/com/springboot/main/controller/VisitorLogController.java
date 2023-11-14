<<<<<<< HEAD
package com.springboot.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
=======
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
>>>>>>> 1d7f627400cf2ed935338c192d15398243bbc147
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

<<<<<<< HEAD
import com.springboot.main.exception.InvalidIdException;
import com.springboot.main.model.Gatekeeper;
import com.springboot.main.model.Resident;
=======
>>>>>>> 1d7f627400cf2ed935338c192d15398243bbc147
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
<<<<<<< HEAD
	@PostMapping("/add/{gatekeeperId}/{residentId}")
	public ResponseEntity<?> addVisitorLog(@RequestBody VisitorLog visitorLog,
            @PathVariable("gatekeeperId") int gatekeeperId,
            @PathVariable("residentId") int residentId)  {
		try{
			 // Fetch gatekeeper and resident objects from the database using IDs
            Gatekeeper gatekeeper = gatekeeperService.getOne(gatekeeperId);
            visitorLog.setGateKeeper(gatekeeper);
            Resident resident = residentService.getOne(residentId);
            visitorLog.setResident(resident);
			visitorLog= visitorLogService.insert(visitorLog);
	    return ResponseEntity.ok().body(visitorLog);
	}catch(InvalidIdException e) {
       
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
}
=======
	@PostMapping("/add")
	public VisitorLog insertVisitorLog(@RequestBody VisitorLog visitorLog) {
		visitorLog= visitorLogService.insert(visitorLog);
	    return visitorLog;
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
<<<<<<< HEAD
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
=======
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
>>>>>>> 1d7f627400cf2ed935338c192d15398243bbc147
