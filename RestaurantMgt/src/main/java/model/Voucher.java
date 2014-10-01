/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Nick
 */
@Entity
public class Voucher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int voucherId;
    private String name;
    private String type;
    private Date startDate;
    private Date endDate;

    @ManyToMany
    @JoinTable(name = "Voucher2Menu", joinColumns = @JoinColumn(name = "voucherId"),
            inverseJoinColumns = @JoinColumn(name = "menuId"))
    private List<Menu> menus = new ArrayList<Menu>();

    public int getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(int voucherId) {
        this.voucherId = voucherId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
    
    
}
