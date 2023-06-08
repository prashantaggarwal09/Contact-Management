package com.contactmanager.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contactmanager.common.Message;
import com.contactmanager.dao.UserStorageService;
import com.contactmanager.entity.User;
import com.google.gson.Gson;

@RequestMapping("api/user")
@RestController
public class RegistrationController {

	@Autowired
	private UserStorageService userStorageService;

	@PostMapping("/register")
	public String saveNewUser(@RequestBody User user) throws IOException {
		System.out.println("save new user");
		System.out.println("----------> New User:" + user);
		Message message = new Message();
		try {
			if (!userStorageService.findByEmail(user.getEmail()).isPresent()) {
				User responseUser = userStorageService.saveUser(user);
				message.setData(responseUser);
				message.setMsg("done");
			}
		} catch (Exception e) {

			e.printStackTrace();
			message.setMsg("fail");
		}
		return new Gson().toJson(message);
	}

}
