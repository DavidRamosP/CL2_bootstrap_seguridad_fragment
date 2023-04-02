/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.cibertec.web;

import java.awt.PageAttributes;
import java.util.ArrayList;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.cibertec.domain.Producto;
import pe.com.cibertec.servicio.ProductoService;
import pe.com.cibertec.Dao.ProductoDao;
import pe.com.cibertec.domain.Compra;
import pe.com.cibertec.servicio.CompraService;

/**
 *
 * @author USUARIO
 */
@Controller
@Slf4j
public class ControladorInicio {

@Autowired
private ProductoService productoService; 

@Autowired
private CompraService compraService;
    
    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user){
      
        var productos = productoService.listarProductos();
        
        model.addAttribute("productos", productos);
        
        
        log.info("ejecutando controlador spring con MVC ");
        log.info("el usuario es "+ user);
        
    return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar(Producto producto){
        
        
        return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar(@Valid Producto producto, Errors errores){
        if(errores.hasErrors()){
        return "modificar";
        }
        
        productoService.guardar(producto);
        return "redirect:/";
     }

    @GetMapping("/editar/{id_producto}")
    public String editar(Producto producto, Model model){
        producto = productoService.encontrarProducto(producto);
        
        model.addAttribute("producto", producto);
        
        return "modificar";
    }
    
    @GetMapping("/eliminar/{id_producto}")
    public String eliminar(Producto producto, Model model){
        productoService.eliminar(producto);
        
        return "redirect:/";
    }

    
    
    /*PARTE CODIFICADA PARA LAS COMPRAS*/
    
    
    @GetMapping("/comprar/{id_producto}")
    public String comprar(Producto producto, Model model){
        producto = productoService.encontrarProducto(producto);
        
        model.addAttribute("compra", producto);
        
        return "comprar";
    }
    
    
     @PostMapping("/guardarCompra")
    public String guardarCompra(Compra compra){
    
        
        compraService.guardarCompra(compra);
        return "redirect:/";
     }
    
    @GetMapping("/listarCompras")
    public String listarCompras(Model model){
      
        var compras = compraService.listarCompras();
        
        model.addAttribute("compras", compras);
        
        
    return "listarCompras";
    }
}