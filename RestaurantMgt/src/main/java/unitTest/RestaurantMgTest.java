/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Menu;

/**
 *
 * @author Nick
 */
public class RestaurantMgTest {

    /**
     * @param args the command line arguments
     */
    private static final String PERSISTENCE_UNIT_NAME = "RestaurantMgt_jar_1.0-SNAPSHOTPU";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        Menu mn = new Menu();
        mn.setFoodName("Beef Steak");
        mn.setPrice(10);
       // mn.setDescription("Allow vouncher");

        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(mn);

            em.getTransaction().commit();

        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            ex.printStackTrace();
        }

    }

}
