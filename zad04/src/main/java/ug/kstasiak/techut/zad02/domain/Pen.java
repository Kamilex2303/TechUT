package ug.kstasiak.techut.zad02.domain;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Pen {

	private long id;
	private boolean isBlack;
	private Date dataOfProduction;
	private double size;
	
	private Producer producer;
	private BarCode barCode;
	private List<User> users;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
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
	
	@ManyToOne
	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}
	
	@OneToOne
	public BarCode getBarCode() {
		return barCode;
	}
	
	@OneToMany
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public void setBarCode(BarCode barCode) {
		this.barCode = barCode;
	}

	@Override
	public String toString() {
		return "Pen [producer=" + producer + ", isBlack=" + isBlack + ", dataOfProduction="
				+ dataOfProduction + ", size=" + size + "]";
	}

	public Pen(Producer producer, double size, Date dateOfProduction, boolean isBlack , List<User> users , BarCode barCode) {
		super();
		this.producer = producer;
		this.isBlack = isBlack;
		this.dataOfProduction = dateOfProduction;
		this.size = size;
		this.barCode = barCode;
		this.users = users;
	}

	public Pen() {
	}
}
