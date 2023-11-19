
package com.springboot.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.model.HelpDesk;
import com.springboot.main.repository.HelpDeskReposiroty;

@Service
public class HelpDeskService {
	@Autowired
	private HelpDeskReposiroty helpDeskRepository;

	public HelpDesk insert(HelpDesk helpDesk) {
		return helpDeskRepository.save(helpDesk);
	}

	public HelpDesk postHelpDesk(HelpDesk helpDesk) {
		return helpDeskRepository.save(helpDesk);
	}

	public List<HelpDesk> getAllTickets() {
		return helpDeskRepository.findAll();
	}
	}

