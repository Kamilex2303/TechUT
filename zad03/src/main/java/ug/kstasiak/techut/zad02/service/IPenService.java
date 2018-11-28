package ug.kstasiak.techut.zad02.service;

import java.util.List;

import ug.kstasiak.techut.zad02.domain.Pen;

public interface IPenService {

	void addPen(Pen pen);
	List<Pen> getAllPens();
	Pen getPenById(int id);
	void deleteAllPens();
	void deletePenById(int id);
}
