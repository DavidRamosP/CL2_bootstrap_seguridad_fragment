/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.cibertec.servicio;

import java.util.List;
import pe.com.cibertec.domain.Producto;

/**
 *
 * @author USUARIO
 */
public interface ProductoService {
    
    public List<Producto> listarProductos();
    public void guardar(Producto pro);
    public void eliminar(Producto pro);
    public Producto encontrarProducto(Producto pro);
}
