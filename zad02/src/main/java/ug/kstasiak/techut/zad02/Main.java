package ug.kstasiak.techut.zad02;

import java.sql.*;
import java.text.ParseException;

import ug.kstasiak.techut.zad02.domain.Pen;
import ug.kstasiak.techut.zad02.service.PenService;

public class Main {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws SQLException, ParseException {
		PenService bs = new PenService();
		bs.addPen(new Pen("Kamil" , 0.1 , new Date(118 , 01, 11) , true));
		Pen superPen = bs.getPenById(0);
		System.out.print(superPen.getProducer());
	    
	}

}
