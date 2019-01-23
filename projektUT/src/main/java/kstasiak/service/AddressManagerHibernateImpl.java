package kstasiak.service;

import kstasiak.domain.Address;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class AddressManagerHibernateImpl implements AddressManager {

	@Autowired
	SessionFactory hsf;
	
	@Override
	public void addAddress(Address address) {
		hsf.getCurrentSession().save(address);
	}

}
