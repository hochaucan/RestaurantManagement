/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import javax.persistence.*;

/**
 *
 * @author Nick
 */
@Entity
public class FoodRevert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int foodRevertId;
    private int menuId;
    private int customerId;
    private String reason;
    private boolean isResuse;
    private Date date;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "menuId", referencedColumnName = "menuId")
    private Menu menu;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "customerId", referencedColumnName = "customerId")
    private Customer customer;

    public int getFoodRevertId() {
        return foodRevertId;
    }

    public void setFoodRevertId(int foodRevertId) {
        this.foodRevertId = foodRevertId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public boolean isIsResuse() {
        return isResuse;
    }

    public void setIsResuse(boolean isResuse) {
        this.isResuse = isResuse;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
