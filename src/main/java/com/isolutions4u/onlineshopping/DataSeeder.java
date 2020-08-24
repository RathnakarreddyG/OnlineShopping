package com.isolutions4u.onlineshopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.isolutions4u.onlineshopping.model.User;
import com.isolutions4u.onlineshopping.repository.UserRepository;

@Component
public class DataSeeder {

	@Autowired
	private UserRepository userRep;

	@EventListener
	public void createUser(ApplicationReadyEvent event) {

		User user = userRep.findUserByEmail("akhila@gmail.com");
		if (user == null) {
			userRep.save(new User("akhila", "akhila", "akhila@gmail.com", "9866221205", "ADMIN",
					"$2a$10$6UVHQoHhpoYZxBB.k9r.deSLTT0RD1Yk8GdggRywGw0Snr8syRDtG", true));
			//password is 123456
		}

	}
}
