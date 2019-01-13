package kstasiak.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "bicycles.all", query = "Select b from Bicycle b"),
})
public class Pen {
    private long id;
    private double price;
    private Date productionDate;
    private boolean isBlack;
    private Barcode barcode;
    private Producer producer;
    private List<User> users = new ArrayList<User>();

    public Pen(double price, Date productionDate, boolean isBlack, Barcode barcode, Producer producer, List<User> users) {
        this.price = price;
        this.productionDate = productionDate;
        this.isBlack = isBlack;
        this.barcode = barcode;
        this.producer = producer;
        this.users = users;
    }

    public Pen(double price , Date productionDate , boolean isBlack){
        this.price = price;
        this.productionDate = productionDate;
        this.isBlack = isBlack;
    }

    @Override
    public String toString() {
        return "Pen{" +
                "id=" + id +
                ", price=" + price +
                ", productionDate=" + productionDate +
                ", isBlack=" + isBlack +
                ", barcode=" + barcode +
                ", producer=" + producer +
                ", users=" + users +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public boolean isBlack() {
        return isBlack;
    }

    public void setBlack(boolean black) {
        isBlack = black;
    }

    //Każdy długopis ma jeden kod kreskowy a każdy kod kreskowy jest przypisany do jednego długopisu
    @OneToOne
    public Barcode getBarcode() {
        return barcode;
    }

    public void setBarcode(Barcode barcode) {
        this.barcode = barcode;
    }

    //Producent ma wiele długopisów a długopis jednego producenta
    @ManyToOne
    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    //Wiele użytkowników może mieć wiele długopisów
    @ManyToMany
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
