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
public class Recipes {

    @EmbeddedId
    private RecipeKey recipeKey;

    private int quantity;
    private String unit;
    private String description;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "menuId", referencedColumnName = "menuId")
    private Menu menu;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "storeId", referencedColumnName = "storeId")
    private Store store;

    public RecipeKey getRecipeKey() {
        return recipeKey;
    }

    public void setRecipeKey(RecipeKey recipeKey) {
        this.recipeKey = recipeKey;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

}

@Embeddable
class RecipeKey {

    private int menuId;
    private int storeId;
}
