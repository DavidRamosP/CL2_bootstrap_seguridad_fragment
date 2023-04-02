/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.cibertec.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import net.bytebuddy.asm.Advice;

/**
 *
 * @author USUARIO
 */

@Data /* Es para generar get/set*/
@Entity
@Table (name="producto")

public class Producto implements Serializable{
    private static final long serialVersionUID = 1L ;
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id_producto;
    
    @NotEmpty
    private String descripcion;
    
    @NotEmpty
    private String unidad;
    
    @NotNull
    private Double precio;
    
 
    
    
}
