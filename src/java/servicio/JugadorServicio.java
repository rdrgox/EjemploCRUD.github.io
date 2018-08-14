/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import dao.JugadorDAO;
import dominio.Equipo;
import dominio.Jugador;
import dto.JugadorDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Rodrigo
 */
@Stateless
public class JugadorServicio {
    @EJB
    private JugadorDAO dao;
    
    public void createJugador(JugadorDTO jDTO){
        Jugador j = new Jugador();
        j.setId_jugador(jDTO.getId_jugador());
        j.setNombre_jugador(jDTO.getNombre_jugador());
        j.setNumero_camiseta(jDTO.getNumero_camiseta());
        Equipo e = new Equipo();
        e.setId_equipo(jDTO.getId_equipo());
        j.setId_equipo(e);
        dao.createJugador(j);
    }
    
    public JugadorDTO readJugador(int id){
        Jugador j = dao.readJugador(id);
        JugadorDTO jDTO = new JugadorDTO();
        jDTO.setId_jugador(j.getId_jugador());
        jDTO.setNombre_jugador(j.getNombre_jugador());
        jDTO.setNumero_camiseta(j.getNumero_camiseta());
        jDTO.setId_equipo(j.getId_equipo().getId_equipo());
        return jDTO;
    }
    
    public void updateJugador(JugadorDTO jDTO){
        Jugador j = new Jugador();
        j.setId_jugador(jDTO.getId_jugador());
        j.setNombre_jugador(jDTO.getNombre_jugador());
        j.setNumero_camiseta(jDTO.getNumero_camiseta());
        Equipo e = new Equipo();
        e.setId_equipo(jDTO.getId_equipo());
        j.setId_equipo(e);
        dao.updateJugador(j);
    }
    
    public void deleteJugador(int id){
        dao.deleteJugador(id);
    }
    
    public ArrayList<JugadorDTO> allJugadoresEquipo(int id_equipo){
        List<Jugador> jugadores = dao.allJugadoresEquipo(id_equipo);
        ArrayList<JugadorDTO> retorno = new ArrayList<>();
        for(Jugador j: jugadores){
            JugadorDTO jDTO = new JugadorDTO();
            jDTO.setId_jugador(j.getId_jugador());
            jDTO.setNombre_jugador(j.getNombre_jugador());
            jDTO.setNumero_camiseta(j.getNumero_camiseta());
            jDTO.setId_equipo(j.getId_equipo().getId_equipo());
            retorno.add(jDTO);
        }
        return retorno;
    }
    
}
