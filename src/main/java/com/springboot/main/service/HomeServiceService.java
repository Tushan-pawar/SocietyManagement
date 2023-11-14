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

import com.springboot.main.model.HomeService;
import com.springboot.main.repository.HomeServiceRepository;

@Service
public class HomeServiceService {
@Autowired
private HomeServiceRepository homeServiceRepository  ;

public HomeService insert(HomeService homeService) {
	// TODO Auto-generated method stub
	return homeServiceRepository.save(homeService);
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

import com.springboot.main.model.HomeService;
import com.springboot.main.repository.HomeServiceRepository;

@Service
public class HomeServiceService {
@Autowired
private HomeServiceRepository homeServiceRepository  ;

public HomeService insert(HomeService homeService) {
	// TODO Auto-generated method stub
	return homeServiceRepository.save(homeService);
}
}
>>>>>>> bc1f25922778682115cb590275a680864198a72b
<<<<<<< HEAD
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
=======
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
>>>>>>> 1d7f627400cf2ed935338c192d15398243bbc147
