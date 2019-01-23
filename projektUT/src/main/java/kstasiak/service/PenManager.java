package kstasiak.service;
import kstasiak.domain.Pen;
import kstasiak.domain.User;

import java.util.List;

public interface PenManager {

	// Pen
	void addPen(Pen pen);
	List<Pen> getAllPens();
	Pen findById(long id);
	void updatePen(Pen pen);
	void deletePen(Pen bicycle);
	
	// Relacje
	List<User> getUsers(Pen pen);
	void relatePenAndUser(long penId, long userId);
	void giveBarcode(long penId, long barcodeId);
}
