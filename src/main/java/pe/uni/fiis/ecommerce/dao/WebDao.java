package pe.uni.fiis.ecommerce.dao;

import pe.uni.fiis.ecommerce.dto.BusquedaProductoResponse;
import pe.uni.fiis.ecommerce.dto.Producto;
import pe.uni.fiis.ecommerce.dto.Usuario;
import pe.uni.fiis.ecommerce.dto.Venta;

public interface WebDao {
    public abstract Usuario autenticar(Usuario usuario);
    public abstract Usuario registrar(Usuario usuario);
    public abstract BusquedaProductoResponse buscarProducto(Producto producto);
    public abstract Venta agregarVenta(Venta venta);

}
