/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dominio.*;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Rodrigo
 */

@Stateless
public class EquipoDAO {
    @PersistenceContext
    private EntityManager em;
    
    public void createEquipo (Equipo e){
        em.persist(e);
    }
    
    public Equipo readEquipo(int id){
        return em.find(Equipo.class, id);
    }
    
    public void updateEquipo (Equipo e){
        em.merge(e);
    }
    
    public void deleteEquipo(int id){
        em.remove(readEquipo(id));
    }
    
    public List<Equipo> allEquipos(){
        return em.createQuery("SELECT e FROM Equipo e").getResultList();
    }
}
