/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Rodrigo
 */

@Entity
@Table (name="jugadores")
public class Jugador implements Serializable{
    @Id
    @Column(name="id_jugador")
    private int id_jugador;
    
    @Column(name="nombre_jugador")
    private String nombre_jugador;
    
    @Column(name="numero_camiseta")
    private int numero_camiseta;
    
    @ManyToOne //indica explicitamente un relacion "muchos a uno"
    
    @JoinColumn(name="id_equipo", referencedColumnName = "id_equipo")
    //esta etiqueta indica el nombre d ela columna y la referencia a la columna de la tabla "equipo"
    private Equipo id_equipo;
    //es muy importante que este atributo sea una clase y no un atributo nativo, 
    //puesto a que crea la relacion entre las entidades

    public Jugador() {
    }

    public int getId_jugador() {
        return id_jugador;
    }

    public void setId_jugador(int id_jugador) {
        this.id_jugador = id_jugador;
    }

    public String getNombre_jugador() {
        return nombre_jugador;
    }

    public void setNombre_jugador(String nombre_jugador) {
        this.nombre_jugador = nombre_jugador;
    }

    public int getNumero_camiseta() {
        return numero_camiseta;
    }

    public void setNumero_camiseta(int numero_camiseta) {
        this.numero_camiseta = numero_camiseta;
    }

    public Equipo getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(Equipo id_equipo) {
        this.id_equipo = id_equipo;
    }
    
    
}
