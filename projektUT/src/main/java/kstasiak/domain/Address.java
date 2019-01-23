package kstasiak.domain;

import javax.persistence.*;

@Entity
public class Address {

	private long id;
	private String street;
	private String houseNumber;
	private String postCode;
	private String city;
	private Producer producer;
	
	public Address(String street, String buildingNumber, String postCode, String city) {
		this.street = street;
		this.houseNumber = buildingNumber;
		this.postCode = postCode;
		this.city = city;
	}

	public Address() {
		
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	// Producent moze miec pare adresów
    @ManyToOne
    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }
	
}
