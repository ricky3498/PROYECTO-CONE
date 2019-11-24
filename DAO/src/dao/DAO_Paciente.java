/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import accesodatos.Conexion;
import entidades.Paciente;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alberto
 */
public class DAO_Paciente extends Conexion{
    public void registrar(Paciente p) throws Exception {
        String sql = "INSERT INTO paciente( dni_pac, nombre_pac,apellido_pac , id_usuario) "
                + " VALUES ( '" + p.getDni_pac() + "', '" + p.getNombre_pac()
                + "', '" + p.getApellido_pac() + "','" + p.getId_usuario()
                +  ")";
        try {
            this.conectar(true);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }
    
    public List<Paciente> listar() throws Exception {
        List<Paciente> paciente = null;
        Paciente pa;
        ResultSet rs = null;
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT P.id_pac, P.dni_pac, P.nombre_pac, P.apellido_pac,P.id_usuario"
                    + " FROM paciente P "
                    + "ORDER BY P.nombre_pac");
            paciente = new ArrayList<>();
            while (rs.next() == true) {
                pa = new Paciente();
                pa.setId_pac(rs.getInt("id_pac"));
                pa.setDni_pac(rs.getString("dni_pac"));
                pa.setNombre_pac(rs.getString("nombre_pac"));
                //me.setCodigo(rs.getInt("Codigo"));
                pa.setApellido_pac(rs.getString("apellido_pac"));
                pa.setId_usuario(rs.getInt("id_usuario"));
                paciente.add(pa);
            }
            rs.close();
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
        return paciente;
    }
    
    
    public Paciente leer(int id) throws Exception {
        Paciente pa = null;
        ResultSet rs = null;
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT * "
                    + " FROM paciente "
                    + " WHERE codigo = " + id + ";");
            while (rs.next() == true) {
                pa = new Paciente();
                pa.setId_pac(rs.getInt("id_pac"));
                pa.setDni_pac(rs.getString("dni_pac"));
                pa.setNombre_pac(rs.getString("nombre_pac"));
                //me.setCodigo(rs.getInt("Codigo"));
                pa.setApellido_pac(rs.getString("apellido_pac"));
                pa.setId_usuario(rs.getInt("id_usuario"));
            }
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
        return pa;
    }
    
    
    public void modificar(Paciente pac) throws Exception {
        String sql = "UPDATE paciente SET "
                + "ID = '" + pac.getId_pac()+ "', "
                + "DNI = '" + pac.getDni_pac()+ "', "
                + "Nombre = '" + pac.getNombre_pac()+ "', "
                + "Apellido = '" + pac.getApellido_pac()+ "', "
                + "Usuario = '" + pac.getId_usuario()+ "', ";
        try {
            this.conectar(true);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }
    
    public void eliminar(int id) throws Exception {
        String sql = "DELETE FROM paciente "
                + "WHERE codigo=" + id + ";";
        System.out.println("sql eliminar--> " + sql);
        try {
            this.conectar(true);
            this.ejecutarOrden(sql);
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
    }
    
    public List<Paciente> buscarNombre(String nombre) throws Exception{
        List<Paciente> paciente = null;
        Paciente pa = null;
        ResultSet rs = null;
        
        try{
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT * "
                    + "FROM paciente  WHERE nombre LIKE '%" + nombre + "%'");
            
            paciente = new ArrayList<>();
            while (rs.next() == true){
                pa = new Paciente();
                pa.setId_pac(rs.getInt("id_pac"));
                pa.setDni_pac(rs.getString("dni_pac"));
                pa.setNombre_pac(rs.getString("nombre_pac"));
                //me.setCodigo(rs.getInt("Codigo"));
                pa.setApellido_pac(rs.getString("apellido_pac"));
                pa.setId_usuario(rs.getInt("id_usuario"));
                paciente.add(pa);
                
            }
            rs.close();
            this.cerrar(true);
        } catch(Exception e){
            this.cerrar(false);
            throw  e;
        }
        return paciente;
    }
}
