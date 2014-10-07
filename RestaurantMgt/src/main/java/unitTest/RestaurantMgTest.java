/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitTest;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.*;
import model.Food;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

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
   // static final Logger logger = Logger.getLogger(RestaurantMgTest.class);
    //static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(RestaurantMgTest.class);

    public static void main(String[] args) {
        
//TEST LOG4J
       // PropertyConfigurator.configure("log4j.properties");
       // logger.warn("Test Warn!");
        //logger.error("Test Error!");
        
        
       
        
        
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
 //String sql ="select * from Employee";
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try {
            em.getTransaction().begin();
//            Query query = em.createQuery(sql);
//            List<Employee> rs = query.getResultList();
          

            em.getTransaction().commit();

        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            ex.printStackTrace();
        }

    }

}
