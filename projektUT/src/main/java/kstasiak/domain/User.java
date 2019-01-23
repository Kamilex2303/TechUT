package kstasiak.domain;

import javax.persistence.*;

@Entity
public class User {
    private long id;
    private String name;
    private String surname;
    private Address address;



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address'" + address.getId() + '\'' +
                '}';
    }

    public User(String name, String surname , Address address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public User(String name , String surname){
        this.name = name;
        this.surname = surname;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @OneToOne
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address= address;
    }
}
