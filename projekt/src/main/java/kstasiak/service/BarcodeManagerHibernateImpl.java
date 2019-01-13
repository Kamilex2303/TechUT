package kstasiak.service;

import kstasiak.domain.Barcode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class BarcodeManagerHibernateImpl implements BarcodeManager {

	@Autowired
	SessionFactory hsf;
	
	
	@Override
	public void addBarcode(Barcode barcode) {
		hsf.getCurrentSession().save(barcode);
	}

}
