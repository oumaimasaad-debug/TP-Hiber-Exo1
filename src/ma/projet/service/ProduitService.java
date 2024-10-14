
package ma.projet.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import ma.projet.dao.IDao;
import ma.projet.entity.Produit;

import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author DELL
 */
public class ProduitService implements IDao<Produit> {

    @Override
    public boolean create(Produit p) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(p);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return false;
    }

    @Override
    public boolean delete(Produit p) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(p);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return false;
    }

    @Override
    public boolean update(Produit p) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(p);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return false;
    }

    @Override
    public Produit findById(int id) {
        Session session = null;
        Produit p = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            p = (Produit) session.get(Produit.class, id);
            session.getTransaction().commit();
            return p;
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return p;
    }

    
   @Override
public List<Produit> findAll() {
    Session session = null;
    List<Produit> produits = new ArrayList<>();
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        produits = session.createQuery("from Produit").list(); 
        
        session.getTransaction().commit();
    } catch (HibernateException e) {
        if (session != null && session.getTransaction() != null) {
            session.getTransaction().rollback();
        }
    } finally {
        if (session != null) {
            session.close();
        }
    }
    return produits;
}
public List<Produit> findProductsBetweenDates(Date startDate, Date endDate) {
    Session session = null;
    List<Produit> produits = new ArrayList<>();

    try {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        produits = session.createQuery("from Produit where dateAchat between :startDate and :endDate").setParameter("startDate", startDate).setParameter("endDate", endDate).list();
        session.getTransaction().commit();
    } catch (HibernateException e) {
        if (session.getTransaction() != null) {
            session.getTransaction().rollback();
        }
        System.out.println("Une erreur s'est produite lors de la récupération des produits : " + e.getMessage());
    } finally {
        if (session != null) {
            session.close();
        }
    }
    // Si aucun produit n'est trouvé
    if (produits.isEmpty()) {
        System.out.println("Aucun produit trouvé entre les dates spécifiées.");
    }

    return produits;
}

}
