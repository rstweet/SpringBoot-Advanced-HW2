package com.rc.subscriberList2021.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rc.subscriberList2021.model.Subscriber;

public interface SubscriberRepository extends CrudRepository<Subscriber, Long> {
	List<Subscriber> findAll();

}
