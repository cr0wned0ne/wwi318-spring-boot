package com.wwi318.odroidmessageapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wwi318.odroidmessageapp.data.Message;
import com.wwi318.odroidmessageapp.data.MessageRepository;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	MessageRepository repo;
	
	@RequestMapping(method=RequestMethod.GET,path="/message")
	public void saveMessage(@RequestParam String message) {
		System.out.println("POST Received!!: " + message);
		Message messageEntity = new Message();
		messageEntity.setText(message);
		repo.save(messageEntity);
	}
	
	@RequestMapping(method=RequestMethod.GET,path="/messages")
	public Iterable<Message> getMessages() {
		return repo.findAll();
	}
	
	

}
