/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.cibertec.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.cibertec.domain.Usuario;

/**
 *
 * @author USUARIO
 */

public interface UsuarioDAO extends JpaRepository<Usuario, Long> {
    // implementando los metodos para la validacion a diferencia de CrudRepository, aqui se va  a inmplemntar
    
    Usuario findByUsername(String username);
    
// no es un metodo creado, se debe crear igual al nombre para que springboot lo reconozca 
    
    
}
