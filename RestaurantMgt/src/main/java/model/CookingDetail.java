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
public class CookingDetail {

    @EmbeddedId
    private CookingDetailKey cookingDetailKey;
    private Date approvalTime;
    private String status;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "menuId", referencedColumnName = "menuId")
    private Menu menu;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "chefId", referencedColumnName = "chefId")
    private Chef chef;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "employeeId", referencedColumnName = "employeeId")
    private Employee employee;

    public CookingDetailKey getCookingDetailKey() {
        return cookingDetailKey;
    }

    public void setCookingDetailKey(CookingDetailKey cookingDetailKey) {
        this.cookingDetailKey = cookingDetailKey;
    }

    public Date getApprovalTime() {
        return approvalTime;
    }

    public void setApprovalTime(Date approvalTime) {
        this.approvalTime = approvalTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Chef getChef() {
        return chef;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    

}

@Embeddable
class CookingDetailKey {

    private int menuId;
    private int chefId;
    private int employeeId;
}
