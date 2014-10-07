/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.*;

/**
 *
 * @author Nick
 */
@Entity
public class OrderDetail {

    @EmbeddedId
    private OrderDetailKey orderDetailKey;
    private int quantity;
    private double price;
    private boolean isRevert;
    private String revertReason;
    private String description;
    private String status;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "orderId", referencedColumnName = "orderId")
    private CustOrder order;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "foodId", referencedColumnName = "foodId")
    private Food food;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIsRevert() {
        return isRevert;
    }

    public void setIsRevert(boolean isRevert) {
        this.isRevert = isRevert;
    }

    public String getRevertReason() {
        return revertReason;
    }

    public void setRevertReason(String revertReason) {
        this.revertReason = revertReason;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CustOrder getOrder() {
        return order;
    }

    public void setOrder(CustOrder order) {
        this.order = order;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public OrderDetailKey getOrderDetailKey() {
        return orderDetailKey;
    }

    public void setOrderDetailKey(OrderDetailKey orderDetailKey) {
        this.orderDetailKey = orderDetailKey;
    }

}

@Embeddable
class OrderDetailKey {

    private int orderId;
    private int foodId;
}
