package pe.uni.fiis.ecommerce.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.uni.fiis.ecommerce.dto.BusquedaProductoResponse;
import pe.uni.fiis.ecommerce.dto.Producto;
import pe.uni.fiis.ecommerce.dto.Usuario;
import pe.uni.fiis.ecommerce.dto.Venta;

import java.sql.*;
import java.util.ArrayList;

@Repository
public class WebDaoImpl implements WebDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public Usuario autenticar(Usuario usuario) {
        String SQL = " SELECT id_usuario, pass, nombre,apellido, email, telefono,dinero  FROM usuario WHERE id_usuario = ? AND pass = ? ";
        try{
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, usuario.getIdUsuario());
            ps.setString(2, usuario.getPass());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                usuario = new Usuario();
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setEmail(rs.getString("email"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setDinero(rs.getDouble("dinero"));
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    private Integer obtenerIdUsuario(){
        Integer id = 0;
        String SQL = " SELECT nvl(MAX(id_usuario)+1,1) codigo FROM usuario ";
        try{
            Connection con = jdbcTemplate.getDataSource().getConnection();
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(SQL);
            while(rs.next()){
                id = rs.getInt("codigo");
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
    public Usuario registrar(Usuario usuario) {
        String SQL = "INSERT INTO usuario(id_usuario,nombre,apellido,telefono,email,pass)"+
                " VALUES(?,?,?,?,?,?) ";
        try{
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            usuario.setIdUsuario(obtenerIdUsuario());
            ps.setInt(1, usuario.getIdUsuario());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getApellido());
            ps.setString(4, usuario.getTelefono());
            ps.setString(5, usuario.getEmail());
            ps.setString(6, usuario.getPass());
            ps.executeUpdate();
            ps.close();
            con.commit();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public BusquedaProductoResponse buscarProducto(Producto producto) {
        BusquedaProductoResponse r = new BusquedaProductoResponse();
        r.setLista(new ArrayList<Producto>());
        String SQL = " SELECT titulo FROM producto " +
                " WHERE upper(titulo) LIKE ? ";
        try{
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, "%"+producto.getTitulo().toUpperCase()+"%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Producto p = new Producto();
                p.setIdProducto(rs.getInt("id_producto"));
                p.setTitulo(rs.getString("titulo"));
                p.setCategoria(rs.getString("categoria"));
                p.setPrecio(rs.getDouble("precio"));
                p.setDescuento(rs.getDouble("descuento"));
                p.setDescripcion(rs.getString("descripcion"));
                r.getLista().add(p);
            }
            ps.close();
            con.commit();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }
    private Integer obtenerIdVenta(){
        Integer ventaId = 0;
        String SQL = " SELECT nvl(MAX(id_venta)+1,1) codigo FROM venta ";
        try{
            Connection con = jdbcTemplate.getDataSource().getConnection();
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(SQL);
            while(rs.next()){
                ventaId = rs.getInt("codigo");
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ventaId;
    }
    public Venta agregarVenta(Venta venta) {
        String SQL = "INSERT INTO venta(id_venta,id_producto,id_usuario,monto) "+
                " VALUES(?,?,?,?,?,?) ";
        try{
            Connection con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            venta.setIdUsuario(obtenerIdUsuario());
            ps.setInt(1, venta.getIdVenta());
            ps.setInt(2, venta.getIdProducto());
            ps.setInt(3, venta.getIdUsuario());
            ps.setDouble(4, venta.getMonto());
            ps.executeUpdate();
            ps.close();
            con.commit();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return venta;
    }
}
