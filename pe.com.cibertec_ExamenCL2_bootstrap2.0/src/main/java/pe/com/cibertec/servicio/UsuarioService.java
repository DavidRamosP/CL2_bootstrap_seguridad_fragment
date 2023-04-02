/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.cibertec.servicio;

import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.cibertec.Dao.UsuarioDAO;
import pe.com.cibertec.domain.Rol;
import pe.com.cibertec.domain.Usuario;

/**
 *
 * @author USUARIO
 */
@Service("userDetailsService") // respetar las mayusculas y minusculas  , en este caso se esta usando jpaRepository y reconocera este metodo con este nombre
@Slf4j  // Lombok para que podamos usar el log para imprimir
public class UsuarioService implements UserDetailsService{

    @Autowired 
    private UsuarioDAO usuarioDao;
    
    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       
     Usuario usuario = usuarioDao.findByUsername(username);
     
     if(usuario == null){
         throw new UsernameNotFoundException(username);
     }
     
     var roles = new ArrayList<GrantedAuthority>();
     
     
        for (Rol rol : usuario.getRoles()) {
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
            
        }
        
     
       return new User(usuario.getUsername(),usuario.getPassword(),roles);
    }
    
}
