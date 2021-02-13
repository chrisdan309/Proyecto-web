package pe.uni.fiis.ecommerce.dto;

import lombok.Data;

import java.util.List;
@Data
public class Producto {
    private Integer idProducto;
    private String titulo;
    private Double precio;
    private Double descuento;
    private String categoria;
    private String descripcion;
}
