<<<<<<< HEAD
=======
<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
=======
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
>>>>>>> 1d7f627400cf2ed935338c192d15398243bbc147
package com.springboot.main.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.main.model.HelpDesk;
import com.springboot.main.service.HelpDeskService;
import com.springboot.main.service.ResidentService;

@Controller
@RequestMapping("/Helpdesk")
public class HelpDeskController {
@Autowired
private ResidentService residentService;
@Autowired 
private HelpDeskService helpDeskService;

@PostMapping("/add")
public HelpDesk insertHelpDesk(@RequestBody HelpDesk helpDesk) {
	helpDesk=helpDeskService.insert(helpDesk);
	return helpDesk;
}
<<<<<<< HEAD
}
=======
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

import com.springboot.main.model.HelpDesk;
import com.springboot.main.model.Notice;
import com.springboot.main.service.HelpDeskService;
import com.springboot.main.service.ResidentService;

@Controller
@RequestMapping("/Helpdesk")
public class HelpDeskController {
@Autowired
private ResidentService residentService;
@Autowired 
private HelpDeskService helpDeskService;

@PostMapping("/add")
public HelpDesk insertHelpDesk(@RequestBody HelpDesk helpDesk) {
	helpDesk=helpDeskService.insert(helpDesk);
	return helpDesk;
}
}
>>>>>>> bc1f25922778682115cb590275a680864198a72b
<<<<<<< HEAD
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
=======
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
>>>>>>> 1d7f627400cf2ed935338c192d15398243bbc147