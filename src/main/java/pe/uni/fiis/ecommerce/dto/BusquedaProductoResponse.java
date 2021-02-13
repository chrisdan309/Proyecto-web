package pe.uni.fiis.ecommerce.dto;

import lombok.Data;

import java.util.List;
@Data
public class BusquedaProductoResponse {
    private List<Producto> lista;
}
