/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.cibertec.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.cibertec.domain.Producto;
import pe.com.cibertec.Dao.ProductoDao;

/**
 *
 * @author USUARIO
 */

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoDao productoDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Producto> listarProductos() {
     return (List<Producto>) productoDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Producto pro) {
        productoDao.save(pro);
    }

    @Override
    @Transactional
    public void eliminar(Producto pro) {
     productoDao.delete(pro);
    }

    @Override
    @Transactional(readOnly = true)
    public Producto encontrarProducto(Producto pro) {
       return productoDao.findById(pro.getId_producto()).orElse(null);
    }
    
}
