/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package h1;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import ma.projet.entity.Produit;
import ma.projet.service.ProduitService;
import ma.projet.util.HibernateUtil;
import org.hibernate.SessionFactory;
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    /* HibernateUtil.getSessionFactory(); 
        
        p.create(new Produit("Essence","300",new Date(),45,"Anticerne"));
        p.create(new Produit("Flormar","302",new Date(),189,"FondDeTeint"));
        p.create(new Produit("Dior","304",new Date(),500,"FondDeTeint"));
        p.create(new Produit("Catrice","304",new Date(),30,"RougeàLevres"));
        p.create(new Produit("ELF","304",new Date(),200,"Palette"));*/
        ProduitService p =new ProduitService();
  for(Produit pr :p.findAll()){
        System.out.println(pr.toString());
        }
        System.out.println((p.findById(2)).toString());
        p.delete(p.findById(3));
        Produit produit1 = p.findById(1);
        produit1.setPrix(230);
        p.update(produit1);
        for(Produit pr :p.findAll()){
        if(pr.getPrix()>100){
        System.out.println(pr.toString());
        }
    }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez la date de depart sous forme(yyyy-MM-dd):");
        String startDateStr = scanner.nextLine();
        System.out.println("Entrez la date de fin(yyyy-MM-dd):");
        String endDateStr = scanner.nextLine();
       
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
             try {
            Date startDate = sdf.parse(startDateStr);
            Date endDate = sdf.parse(endDateStr);
             // Affichage des produits
        for (Produit produit : p.findProductsBetweenDates(startDate, endDate)) {
            System.out.println(produit); 
        }
             }catch(Exception e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");     
    }
          
       
    }
}
