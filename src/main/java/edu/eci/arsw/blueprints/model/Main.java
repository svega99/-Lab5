/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.model;

import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author 2133832
 */
public class Main {

    public static void main(String a[]) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BlueprintsServices bs = ac.getBean(BlueprintsServices.class);
        Point[] pts0=new Point[]{new Point(40, 40),new Point(15, 15)};
        Blueprint bp0=new Blueprint("mack", "mypaint",pts0);
        
        
        try {
            bs.addNewBlueprint(bp0);
        } catch (BlueprintPersistenceException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Point[] pts=new Point[]{new Point(0, 0),new Point(10, 10)};
        Blueprint bp=new Blueprint("john", "thepaint",pts);
        
         try {
            bs.addNewBlueprint(bp);
        } catch (BlueprintPersistenceException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
        Point[] pts1=new Point[]{new Point(0, 0),new Point(10, 10)};
        Blueprint bp1=new Blueprint("john", "otherpaint",pts1);
        try {
            bs.addNewBlueprint(bp1);
        } catch (BlueprintPersistenceException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("getBlueprint:");
        try {
            System.out.println(bs.getBlueprint("john", "thepaint").toString());
        }
        catch (BlueprintNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
         System.out.println("getBlueprintsByAuthor:");
        try {
            Set<Blueprint> blues = bs.getBlueprintsByAuthor("john");
            for (Blueprint b: blues){
                System.out.println(b.toString());
            }
        }
        catch (BlueprintNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
 
    }

}
