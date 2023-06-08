package com.contactmanager.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.contactmanager.common.Message;
import com.contactmanager.dao.ContactStorageService;
import com.contactmanager.dao.UserStorageService;
import com.contactmanager.entity.ContactDetails;
import com.contactmanager.entity.User;
import com.google.gson.Gson;

@RequestMapping("api/home")
@RestController
public class HomeController {

	@Autowired
	private UserStorageService userStorageService;

	@Autowired
	private ContactStorageService contactStorageService;

	@PostMapping("/updateProfile")
	public String updateProfile(@RequestBody User user) throws IOException {

		System.out.println("User from view: " + user);
		Message message = new Message();
		try {
			if (userStorageService.findById(user.getId()).isPresent()) {

				User retrievedUser = userStorageService.saveUser(user);
				System.out.println("\n\nRetrieved User: " + retrievedUser);
				message.setData(retrievedUser);
				message.setMsg("done");
			} else {
				message.setMsg("please register user..");
			}
		} catch (Exception e) {

			e.printStackTrace();
			message.setMsg("fail");
		}
		return new Gson().toJson(message);

	}

	@DeleteMapping("/deleteProfile")
	public String deleteProfile(@RequestParam(name = "id") Integer id) {
		Message message = new Message();
		try {
			userStorageService.deleteById(id);
			message.setMsg("done");

		} catch (Exception e) {

			e.printStackTrace();
			message.setMsg("fail");
		}
		return new Gson().toJson(message);
	}

	@DeleteMapping("/deleteContact")
	public String deleteContact(@RequestParam(name = "param") String param) {
		Message message = new Message();
		try {
			contactStorageService.deleteById(Integer.parseInt(param));
			message.setMsg("done");

		} catch (Exception e) {

			e.printStackTrace();
			message.setMsg("fail");
		}
		return new Gson().toJson(message);
	}

	@PostMapping("/contact")
	public String updateContact(@RequestBody ContactDetails contact) {
		Message message = new Message();

		try {
			ContactDetails responseContact = contactStorageService.save(contact);
			message.setData(responseContact);
			message.setMsg("done");

		} catch (Exception e) {

			e.printStackTrace();
			message.setMsg("fail");
		}
		return new Gson().toJson(message);

	}

	@GetMapping("/getAllContact")
	public String addContact() throws IOException {
		Message message = new Message();

		try {

			List<ContactDetails> list = contactStorageService.findAllContact();
			message.setData(list);
			message.setMsg("done");

		} catch (Exception e) {

			e.printStackTrace();
			message.setMsg("fail");
		}
		return new Gson().toJson(message);

	}

}
