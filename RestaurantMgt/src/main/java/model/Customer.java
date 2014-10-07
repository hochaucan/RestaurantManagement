/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Nick
 */
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    @Column(length = 100)
    private String name;
    @Column(length = 20)
    private String phone;
    @Column(length = 100)
    private String email;
    private String address;

    @OneToMany(mappedBy = "customer")
    private List<CustOrder> orders = new ArrayList<CustOrder>();

    public int getCustomerId() {
        return customerId;
    }

    public List<CustOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<CustOrder> orders) {
        this.orders = orders;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
