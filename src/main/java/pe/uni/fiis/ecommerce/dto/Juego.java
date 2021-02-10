package pe.uni.fiis.ecommerce.dto;

import lombok.Data;

@Data
public class Juego {
    private Integer idJuego;
    private String titulo;
    private Double precio;
    private Double descuento;
}
