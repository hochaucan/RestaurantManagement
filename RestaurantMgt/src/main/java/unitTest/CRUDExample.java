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
import javax.persistence.TypedQuery;
import model.Employee;

/**
 *
 * @author Nick
 */
public class CRUDExample {

    /**
     * @param args the command line arguments
     */
    private static final String PERSISTENCE_UNIT_NAME = "RestaurantMgt_jar_1.0-SNAPSHOTPU";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        // TODO code application logic here
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try {

            em.getTransaction().begin();

//            //***INSERT***
//            Employee empl = new Employee(); //Create new employee with below attribute/column
//            empl.setUserName("Lan Huynh");
//            empl.setPassword("oanh111!!!");
//            empl.setCellPhone("0973730111");
//            em.persist(empl); // then saving new employee to Database
//
//            //***UPDATE***
//            Employee empl2 = em.find(Employee.class, 1); //Get exist Employee with Id = 1
//            empl2.setUserName("Nick HO2"); //Change Employee name 
//            em.persist(empl2); // and then update to Database
//
            
//            //***REMOVE***
//            Employee empl3 = em.find(Employee.class, 5); //Get exist Employee with Id = 5
//            em.remove(empl3); // and then remove this employee from Database
            
            
            //***GET LIST USING QUERY***
//            Query query = em.createQuery("select c from Employee c");
//            List<Employee> result = query.getResultList();
//            System.out.println("" + result);
            
            
            //***QUERY WITH PARAMETER***
//            Query query = em.createQuery("select c from Employee c where c.userName = ?1 ");
//            List<Employee> result = query.setParameter(1, "Nick HO2").getResultList(); //I specify parrameter 1 by 'Nick HO2'. You can change it by getting text field from JFrame
            
            
            em.getTransaction().commit();

        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            ex.printStackTrace();
        }
    }

}
