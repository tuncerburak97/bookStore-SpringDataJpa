package com.btuncer.entities;

import javax.persistence.*;
import java.util.List;

@Entity

public class User {

    @Id
    @GeneratedValue
    private int id;

    private String name;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private  Address address;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Orders> orders;




    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public int getId() {
        return id;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }

}
