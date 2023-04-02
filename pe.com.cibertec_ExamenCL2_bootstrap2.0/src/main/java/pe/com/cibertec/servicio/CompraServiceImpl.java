/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.cibertec.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.cibertec.Dao.CompraDao;
import pe.com.cibertec.domain.Compra;

/**
 *
 * @author USUARIO
 */
@Service
public class CompraServiceImpl implements CompraService{

    @Autowired
    private CompraDao compraDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Compra> listarCompras() {
       return (List<Compra>) compraDao.findAll();
    }

    @Override
    @Transactional
    public void guardarCompra(Compra compra) {
        compraDao.save(compra);
    }

    @Override
    @Transactional
    public void eliminarCompra(Compra compra) {
        compraDao.delete(compra);
    }

    @Override
    @Transactional(readOnly = true)
    public Compra encontrarCompra(Compra compra) {
        return compraDao.findById(compra.getId_compra()).orElse(null);
       
    }
    
}
