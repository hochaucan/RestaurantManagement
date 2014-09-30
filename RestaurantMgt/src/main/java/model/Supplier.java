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
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int supplierId;
    private String name;
    private String phone;
    private String email;
    private String address;

    @ManyToMany
    @JoinTable(name = "Supplier2Store",
            joinColumns = @JoinColumn(name = "supplierId"),
            inverseJoinColumns = @JoinColumn(name = "storeId"))
    private List<Store> stores = new ArrayList<Store>();
}
