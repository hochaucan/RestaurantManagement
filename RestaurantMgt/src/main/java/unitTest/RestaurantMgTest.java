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
import model.*;

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
//        User user1 = new User();
//        user1.setUserName("Nick HO");
//        user1.setEmail("hochaucan@gmal.com");
//        user1.setCellPhone("0973730111");
//        User user2 = new User();
//        user2.setUserName("Oanh Nguyen");
//        user2.setCellPhone("0975114685");
//
//        UserRole userRole = new UserRole();
//        userRole.setName("Admin");
//        userRole.getUsers().add(user1);
//        userRole.getUsers().add(user2);

        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try {
//            em.getTransaction().begin();
//            em.persist(user1);
//            em.persist(user2);
//            em.persist(userRole);

            em.getTransaction().commit();

        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            ex.printStackTrace();
        }

    }

}
