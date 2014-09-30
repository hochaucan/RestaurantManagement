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
public class Chef {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chefId;
    private String name;
    private String regular;

    @OneToMany(mappedBy = "chef")
    private List<CookingDetail> cookingDetails = new ArrayList<CookingDetail>();

    public int getChefId() {
        return chefId;
    }

    public void setChefId(int chefId) {
        this.chefId = chefId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegular() {
        return regular;
    }

    public void setRegular(String regular) {
        this.regular = regular;
    }

    public List<CookingDetail> getCookingDetails() {
        return cookingDetails;
    }

    public void setCookingDetails(List<CookingDetail> cookingDetails) {
        this.cookingDetails = cookingDetails;
    }
}
