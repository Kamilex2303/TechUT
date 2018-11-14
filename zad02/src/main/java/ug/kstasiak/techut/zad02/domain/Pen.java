package ug.kstasiak.techut.zad02.domain;


import java.sql.Date;

public class Pen {

	private String producer;
	private boolean isBlack;
	private Date dataOfProduction;
	private double size;

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public boolean isBlack() {
		return isBlack;
	}

	public void setBlack(boolean isBlack) {
		this.isBlack = isBlack;
	}

	public Date getDataOfProduction() {
		return dataOfProduction;
	}

	public void setDataOfProduction(Date dataOfProduction) {
		this.dataOfProduction = dataOfProduction;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Pen [producer=" + producer + ", isBlack=" + isBlack + ", dataOfProduction="
				+ dataOfProduction + ", size=" + size + "]";
	}

	public Pen(String producer, double size, Date dateOfProduction, boolean isBlack) {
		super();
		this.producer = producer;
		this.isBlack = isBlack;
		this.dataOfProduction = dateOfProduction;
		this.size = size;
	}

	public Pen() {
	}
}
