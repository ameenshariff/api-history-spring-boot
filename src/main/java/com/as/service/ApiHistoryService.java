package com.as.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.as.domain.ApiHistory;
import com.as.repository.ApiHistoryRepo;

@Service
public class ApiHistoryService {
	
	static final Logger log = 
	        LoggerFactory.getLogger(ApiHistoryService.class);

	@Autowired
	private ApiHistoryRepo repo;
	
	public ApiHistory saveApiHistory(ApiHistory data) {
		log.debug("service", data);
		return repo.save(data);
	}

	public List<ApiHistory> getApiHistory() {
		return repo.findAll();
	}

}
