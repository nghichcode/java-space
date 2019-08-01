package stackjava.com.springmvcjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import stackjava.com.springmvcjpa.dao.ContactDAO;
import stackjava.com.springmvcjpa.entities.Contact;

@Service
@Transactional
public class ContactService {

	@Autowired
	private ContactDAO contactDAO;

	public List<Contact> findAll() {
		return contactDAO.findAll();
	}

	public Contact findById(final int id) {
		System.out.println("CS "+id);
		return contactDAO.findById(id);
	}

	public void save(final Contact Contact) {
		// check if Contact exist -> throw exception
		contactDAO.persist(Contact);
	}

	public void update(final Contact Contact) {
		// if ContactDB = null -> throw Exception
		Contact ContactDB = contactDAO.findById(Contact.getId());
		ContactDB.setName(Contact.getName());
		ContactDB.setEmail(Contact.getEmail());
		contactDAO.persist(ContactDB);
	}

	public void delete(final int id) {
		Contact Contact = contactDAO.findById(id);
		if (Contact != null) {
			contactDAO.delete(Contact);
		}
	}
}
