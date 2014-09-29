/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.*;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author Nick
 */
@Entity
public class OrderDetail {

    @Id
    private int orderId;
    @Id
    private int menuId;
    @Id
    private int tableId;

    private DateTime starttime;
    private DateTime endTime;
    private int quantity;
    private double price;
    private String status;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "menuId")
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "tableId")
    private model.Table table;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public DateTime getStarttime() {
        return starttime;
    }

    public void setStarttime(DateTime starttime) {
        this.starttime = starttime;
    }

    public DateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(DateTime endTime) {
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

}
