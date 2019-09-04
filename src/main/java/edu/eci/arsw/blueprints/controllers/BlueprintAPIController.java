/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.controllers;

import edu.eci.arsw.blueprints.filter.Filtering;
import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hcadavid
 */
@RestController
@RequestMapping(value = "/blueprints/{author}/{bpname}")
public class BlueprintAPIController {
    
    @Autowired
    @Qualifier("blueprintsServices")
    BlueprintsServices bps;
    
    /*
    @RequestMapping(value = "/blueprints",method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGetRecursoBlueprint(){
        try {
            return new ResponseEntity<>(bps.getAllBlueprints(),HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(BlueprintAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
    } 
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGetRecursoBlueprintAuthor(@PathVariable("author") String author, @PathVariable("bpname") String bpname){
        try {
            return new ResponseEntity<>(bps.getBlueprint(author,bpname),HttpStatus.ACCEPTED);
        } catch (BlueprintNotFoundException ex) {
            Logger.getLogger(BlueprintAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error: No encontrado",HttpStatus.NOT_FOUND);
    } 
    
   }
    
    
    
    
    
}

