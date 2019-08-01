package com.nc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nc.domain.Contact;
import java.lang.String;

public interface ContactRepository extends CrudRepository<Contact, Integer> {
	List<Contact> findByNameContaining(String q);
	List<Contact> findByEmailContaining(String q);
}
