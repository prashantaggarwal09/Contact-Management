package com.contactmanager.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.contactmanager.entity.ContactDetails;

@Repository
public interface ContactRepository extends JpaRepository<ContactDetails, Integer> {
	
	@Query(value = "select * from contactdetails where lower(name) LIKE %?1%  and userid = ?2 order by name", nativeQuery = true)
	public Page<ContactDetails> search(String search, int userId, Pageable pageable);

	@Query(value = "select * from contactdetails where userid = ?1 order by name", nativeQuery = true)
	public Page<ContactDetails> findByUserid(int userId, Pageable pageable);

}
