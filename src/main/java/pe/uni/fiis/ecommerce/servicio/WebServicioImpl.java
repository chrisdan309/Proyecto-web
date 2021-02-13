package pe.uni.fiis.ecommerce.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.uni.fiis.ecommerce.dao.WebDao;
import pe.uni.fiis.ecommerce.dto.BusquedaProductoResponse;
import pe.uni.fiis.ecommerce.dto.Producto;
import pe.uni.fiis.ecommerce.dto.Usuario;
import pe.uni.fiis.ecommerce.dto.Venta;
@Service
@Transactional
public class WebServicioImpl implements WebServicio{
    @Autowired
    private WebDao dao;
    public Usuario autenticar(Usuario usuario) {
        return dao.autenticar(usuario);
    }

    public Usuario registrar(Usuario usuario) {
        return dao.registrar(usuario);
    }

    public BusquedaProductoResponse buscarProducto(Producto producto) {
        return dao.buscarProducto(producto);
    }

    public Venta agregarVenta(Venta venta) {
        return dao.agregarVenta(venta);
    }
}
