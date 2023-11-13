<<<<<<< HEAD
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
