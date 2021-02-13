package pe.uni.fiis.ecommerce.dto;

import lombok.Data;

import java.util.List;

@Data
public class Venta {
    private Integer idVenta;
    private Integer idProducto;
    private Integer idUsuario;
    private Integer monto;
    List<Producto> productos;
}
