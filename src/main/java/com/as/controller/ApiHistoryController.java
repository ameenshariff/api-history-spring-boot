package com.as.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.as.domain.ApiHistory;
import com.as.service.ApiHistoryService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ApiHistoryController {
	static final Logger log = 
	        LoggerFactory.getLogger(ApiHistoryController.class);
	
	@Autowired
	private ApiHistoryService service;
	
	@PostMapping(path = "/history",
			produces = "application/json")
	public ResponseEntity<?> saveApiHistory(@RequestBody ApiHistory data) {
		log.debug("controller", data);
		service.saveApiHistory(data);
		HttpHeaders headers = new HttpHeaders();
	    headers.add("Access-Control-Allow-Origin", "*");
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/query-history")
	public ResponseEntity<List<ApiHistory>> getApiHistory() {
		List<ApiHistory> history = service.getApiHistory();
		HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "UserController");
		return ResponseEntity.accepted().headers(headers).body(history);
	}

}
