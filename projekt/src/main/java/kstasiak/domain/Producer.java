package kstasiak.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
    @NamedQuery(name = "producer.all", query = "Select p from Producer p"),
})
public class Producer {

    private long id;
    private String name;
    private String surname;
    private List<Pen> pens = new ArrayList<Pen>();
	private List<Address> addresses = new ArrayList<Address>();

    public Producer(String name) {
        this.name = name;
    }

    public Producer() {
    	
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

    //Jeden procudent wiele długopisów
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Pen> getPens() {
        return pens;
    }

    public void setPens(List<Pen> pens) {
        this.pens = pens;
    }

    //Jeden producent wiele adresów
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
}
}