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
public class JugadorDAO {
    @PersistenceContext
    private EntityManager em;
    
    public void createJugador(Jugador j){
        em.persist(j);
    }
    
    public Jugador readJugador(int id){
        return em.find(Jugador.class, id);
    }
    
    public void updateJugador(Jugador j){
        em.merge(j);
    }
    
    public void deleteJugador(int id){
        em.remove(readJugador(id));
    }
    
    public List<Jugador> allJugadoresEquipo(int id_equipo){
        return em.createQuery("SELECT j FROM Jugador j WHERE j.id_equipo.id_equipo= :id_equipo")
                .setParameter("id_equipo", id_equipo)
                .getResultList();
    }
}
