/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.cibertec.Dao;

import org.springframework.data.repository.CrudRepository;
import pe.com.cibertec.domain.Producto;

/**
 *
 * @author USUARIO
 */
public interface ProductoDao extends CrudRepository<Producto, Long>{
    
}
