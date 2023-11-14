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
package com.springboot.main.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.model.HelpDesk;
import com.springboot.main.repository.HelpDeskRepository;

@Service
public class HelpDeskService {
@Autowired
private  HelpDeskRepository helpDeskRepository;

public  HelpDesk insert(HelpDesk helpDesk) {
	// TODO Auto-generated method stub
	return helpDeskRepository.save(helpDesk);
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
package com.springboot.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.model.HelpDesk;
import com.springboot.main.repository.HelpDeskReposiroty;

@Service
public class HelpDeskService {
@Autowired
private  HelpDeskReposiroty helpDeskRepository;

public  HelpDesk insert(HelpDesk helpDesk) {
	// TODO Auto-generated method stub
	return helpDeskRepository.save(helpDesk);
}
}
>>>>>>> bc1f25922778682115cb590275a680864198a72b
<<<<<<< HEAD
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
=======
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
>>>>>>> 1d7f627400cf2ed935338c192d15398243bbc147
