package com.rc.subscriberList2021.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.rc.subscriberList2021.model.Subscriber;
import com.rc.subscriberList2021.repository.SubscriberRepository;

@Controller
public class SubscriberController {

	@Autowired
	private SubscriberRepository subscriberRepository;

	@GetMapping(value = "/")
	public String index(Subscriber subscriber) {
		// Where we want to go when our application is started
		return "subscriber/index";
	}

	@GetMapping(value = "/subscribers")
	public String getAllSubscribers(Model model) {
		List<Subscriber> subscribers = new ArrayList<Subscriber>();
		subscribers = subscriberRepository.findAll();
		model.addAttribute("mysubscribers", subscribers);
		// Where we want to go when our application is started
		return "subscriber/subscribers";
	}

	@PostMapping(value = "/")

	public String addNewSubscriber(Subscriber subscriber, Model model) {
		subscriberRepository
				.save(new Subscriber(subscriber.getFirstName(), subscriber.getLastName(), subscriber.getUserName()));
		model.addAttribute("firstName", subscriber.getFirstName());
		model.addAttribute("lastName", subscriber.getLastName());
		model.addAttribute("userName", subscriber.getUserName());
		return "subscriber/result";
	}
}
