package pe.uni.fiis.ecommerce.dto;

import lombok.Data;

@Data
public class Usuario {
    private Integer idUsuario;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String pass;
    private Double dinero;

}
