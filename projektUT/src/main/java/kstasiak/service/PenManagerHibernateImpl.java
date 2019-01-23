package kstasiak.service;

import kstasiak.domain.Barcode;
import kstasiak.domain.Pen;
import kstasiak.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class PenManagerHibernateImpl implements PenManager {

	@Autowired
	SessionFactory hsf;
	
	@Override
	public void addPen(Pen pen) {
		hsf.getCurrentSession().save(pen);
	}

	@Override
	public List<Pen> getAllPens() {
		return hsf.getCurrentSession().getNamedQuery("pen.all").list();
	}

	@Override
	public Pen findById(long id) {
		return (Pen) hsf.getCurrentSession().get(Pen.class, id);
	}

	@Override
	public void updatePen(Pen pen) {
		hsf.getCurrentSession().update(pen);
	}

	@Override
	public void deletePen(Pen pen) {
		 hsf.getCurrentSession().delete(pen);
	}

	@Override
	public List<User> getUsers(Pen pen) {
        pen = (Pen) hsf.getCurrentSession().get(Pen.class, pen.getId());
        List<User> users = new ArrayList<User>(pen.getUsers());
        return users;
	}

	@Override
	public void relatePenAndUser(long penId, long userId) {
        Pen pen = findById(penId);
        User user = (User) hsf.getCurrentSession().get(User.class, userId);
        pen.getUsers().add(user);
		
	}

	@Override
	public void giveBarcode(long penId, long barcodeId) {
		Pen pen = (Pen) hsf.getCurrentSession().get(Pen.class, penId);
		Barcode barcode = (Barcode) hsf.getCurrentSession().get(Barcode.class, barcodeId);
        pen.setBarcode(barcode);
	}
}
