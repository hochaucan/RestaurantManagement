/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;


/**
 *
 * @author Nick
 */
@Entity
public class Order {
    @Id @GeneratedValue
    private int orderId;
    private int totalQuantity;
    private DateTime date;
    
    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
    
}
