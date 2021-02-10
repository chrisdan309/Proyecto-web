package pe.uni.fiis.ecommerce.dto;

import lombok.Data;

@Data
public class Usuario {
    private Integer idUsuario;
    private String nombre;
    private String apellido;
    private String email;
    private Integer telefono;
    private String contraseña;
    private Double dinero;

}
