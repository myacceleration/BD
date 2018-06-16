package com.acc.race.demo;

import com.acc.race.demo.model.User;
import com.acc.race.demo.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	UserRepository ur;

	@Test
	public void testCreate() {
		User u = new User();
		u.setName("Mariusz Paszczak");
		ur.saveUser(u);
	}

	@Test
	public void deleteAll() {
		List<User> users = ur.findAll();
		for(User u : users) {
			ur.deleteUser(u.getId());
		}
	}


	@Test
	public void delete() {
		List<User> users = ur.findAll();
		for(User u : users) {
			ur.deleteUser(u.getId());
		}
	}
}
