/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entity.Users;
import entity.Items;
import entity.Purchases;
import entity.Types;
import java.util.List;

/**
 *
 * @author cmpmchad
 */
@Named(value = "websiteBean")
@SessionScoped
public class WebsiteBean implements Serializable {

    @PersistenceContext(unitName = "FinalYearProjectPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    List<Items> items;

    /**
     * Creates a new instance of WebsiteBean
     */
    public WebsiteBean() {
    }

    public List<Items>getLessons() {
        return items;
    }
    
    public void persist(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
  
	//Data from SQL database 
    public List<Users>getUsers(){
        return em.createNamedQuery("Users.findAll").getResultList();
    }
    
    public List<Types>getTypes(){
        return em.createNamedQuery("Types.findAll").getResultList();
    }
    
    public List<Items>getItems(){
        return em.createNamedQuery("Items.findAll").getResultList();
    }
    
    public List<Purchases>getPurchases(){
        return em.createNamedQuery("Purchases.findAll").getResultList();
    }
    
	// Filter products based on user selection
    public String listTypes(Types itemType) {
       items = em.createNamedQuery("Items.findByTypeNo").setParameter("typeNo", itemType).getResultList();
       return "product.xhtml";
    }
}
