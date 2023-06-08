package com.contactmanager.dao;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.contactmanager.entity.ContactDetails;

@Service
public class ContactStorageService {

	@Autowired
	private ContactRepository contactRepository;

	public void deleteById(Integer id) {
		contactRepository.deleteById(id);
	}

	public List<ContactDetails> findAllContact() {
		return contactRepository.findAll();
	}

	public ContactDetails save(ContactDetails newContact) throws IOException {
		return contactRepository.save(newContact);
	}

}
