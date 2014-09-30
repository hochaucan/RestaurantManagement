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
public class OrderDetail {

    @EmbeddedId
    private OrderDetailKey orderDetailKey;
    private Date starttime;
    private Date endTime;
    private int quantity;
    private double price;
    private String status;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "orderId", referencedColumnName = "orderId")
    private Order order;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "menuId", referencedColumnName = "menuId")
    private Menu menu;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "tableId", referencedColumnName = "tableId")
    private model.Table table;

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

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

    public void setStatus(String status) {
        this.status = status;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public model.Table getTable() {
        return table;
    }

    public void setTable(model.Table table) {
        this.table = table;
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
    private int menuId;
    private int tableId;
}
