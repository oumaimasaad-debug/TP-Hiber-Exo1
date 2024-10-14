/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.entity;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name = "produit")
public class Produit{ 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String marque;
    @Column(name = "reference")
     private String ref;
    @Temporal(TemporalType.DATE)
    private Date dateAchat;
    private double prix;
    @Column(name = "designation")
    private String des;

    public Produit() {
    }

    public Produit(String marque, String ref, Date dateAchat, double prix, String des) {
        this.marque = marque;
        this.ref = ref;
        this.dateAchat = dateAchat;
        this.prix = prix;
        this.des = des;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + this.getId() + ", marque=" + this.getMarque() + ", ref=" + this.getRef() + ", dateAchat=" + this.getDateAchat() + ", prix=" + this.getPrix() + ", des=" + this.des + '}';
    }
    
    
}    
