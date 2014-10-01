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
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int menuId;
    @Column(length = 200)
    private String foodName;
    private double price;
    private String description;

    @OneToMany(mappedBy = "menu")
    private List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();

    @OneToMany(mappedBy = "menu")
    private List<FoodRevert> foodReverts = new ArrayList<FoodRevert>();

    @ManyToMany(mappedBy = "menus")
    private List<Reservation> reserves = new ArrayList<Reservation>();

    @OneToMany(mappedBy = "menu")
    private List<Recipes> recipes = new ArrayList<Recipes>();

    @OneToMany(mappedBy = "menu")
    private List<CookingDetail> cookingDetails = new ArrayList<CookingDetail>();

    @ManyToMany(mappedBy = "menus")
    private List<Voucher> vouchers = new ArrayList<Voucher>();

    public int getMenuId() {
        return menuId;
    }

    public List<Voucher> getVouchers() {
        return vouchers;
    }

    public void setVouchers(List<Voucher> vouchers) {
        this.vouchers = vouchers;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public List<FoodRevert> getFoodReverts() {
        return foodReverts;
    }

    public void setFoodReverts(List<FoodRevert> foodReverts) {
        this.foodReverts = foodReverts;
    }

    public List<Reservation> getReserves() {
        return reserves;
    }

    public void setReserves(List<Reservation> reserves) {
        this.reserves = reserves;
    }

    public List<Recipes> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipes> recipes) {
        this.recipes = recipes;
    }

    public List<CookingDetail> getCookingDetails() {
        return cookingDetails;
    }

    public void setCookingDetails(List<CookingDetail> cookingDetails) {
        this.cookingDetails = cookingDetails;
    }

}
