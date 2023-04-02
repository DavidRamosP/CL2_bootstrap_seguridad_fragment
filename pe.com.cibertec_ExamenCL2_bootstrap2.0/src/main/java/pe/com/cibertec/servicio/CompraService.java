/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.cibertec.servicio;

import java.util.List;
import pe.com.cibertec.domain.Compra;

/**
 *
 * @author USUARIO
 */
public interface CompraService {
    public List<Compra> listarCompras();
    public void guardarCompra(Compra compra);
    public void eliminarCompra(Compra compra);
    public Compra encontrarCompra(Compra compra);
}
