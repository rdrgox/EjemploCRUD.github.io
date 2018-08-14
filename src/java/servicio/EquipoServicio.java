/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import dao.EquipoDAO;
import dominio.Equipo;
import dto.EquipoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Rodrigo
 */
@Stateless
public class EquipoServicio {
    @EJB
    private EquipoDAO dao;
    
    public void createEquipo(EquipoDTO eDTO){
        Equipo e = new Equipo();
        e.setNombre_equipo(eDTO.getNombre_equipo());
        dao.createEquipo(e);
    }
    
    public EquipoDTO readEquipo(int id){
        Equipo e = dao.readEquipo(id);
        EquipoDTO eDTO = new EquipoDTO();
        eDTO.setId_equipo(e.getId_equipo());
        eDTO.setNombre_equipo(e.getNombre_equipo());
        return eDTO;
    }
    
    public void updateEquipo(EquipoDTO eDTO){
        Equipo e = new Equipo();
        e.setId_equipo(eDTO.getId_equipo());
        e.setNombre_equipo(eDTO.getNombre_equipo());
        dao.updateEquipo(e);
    }
    
    public void deleteEquipo(int id){
        dao.deleteEquipo(id);
    }
    
    public ArrayList<EquipoDTO> allEquipos(){
        List<Equipo> equipos = dao.allEquipos();
        ArrayList<EquipoDTO> retorno = new ArrayList<>();
        for(Equipo e: equipos){
            EquipoDTO eDTO = new EquipoDTO();
            eDTO.setId_equipo(e.getId_equipo());
            eDTO.setNombre_equipo(e.getNombre_equipo());
            retorno.add(eDTO);
        }
        return retorno;
    }
}
