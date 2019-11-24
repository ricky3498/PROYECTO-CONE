/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import accesodatos.Conexion;
import entidades.Medico;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yamir
 */
public class DAOMedico extends Conexion{
    public void registrar(Medico m) throws Exception {
        String sql = "INSERT INTO medico( nombre, apellido, edad, sexo, correo, telefono, id_medico) "
                + " VALUES ( '" + m.getNombre()+ "', '" + m.getApellido()
                + "', '" + m.getEdad() + "','" +m.getCorreo() + "','" +m.getTelefono() 
                + "','" + m.getId_medico()
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
    
    public List<Medico> listar() throws Exception {
        List<Medico> medico = null;
        Medico me;
        ResultSet rs = null;
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT M.nombre, M.apellido, M.edad, M.sexo, M.correo, M.telefono, M.id_medico"
                    + " FROM medico M "
                    + "ORDER BY M.nombre");
            medico = new ArrayList<>();
            while (rs.next() == true) {
                me = new Medico();
                me.setNombre(rs.getString("nombre"));
                me.setApellido(rs.getString("apellido"));
                me.setEdad(rs.getInt("edad"));
                me.setSexo(rs.getBoolean("sexo"));
                me.setCorreo(rs.getString("correo"));
                me.setTelefono(rs.getString("telefono"));
                //me.setCodigo(rs.getInt("Codigo"));
                me.setId_medico(rs.getInt("id_medico"));
                medico.add(me);
            }
            rs.close();
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
        return medico;
    }
    
    
    public Medico leer(int id) throws Exception {
        Medico me = null;
        ResultSet rs = null;
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT * "
                    + " FROM medico "
                    + " WHERE id_medico = " + id + ";");
            while (rs.next() == true) {
                me = new Medico();
                me.setNombre(rs.getString("nombre"));
                me.setApellido(rs.getString("apellido"));
                me.setEdad(rs.getInt("edad"));
                //me.setCodigo(rs.getInt("Codigo"));
                me.setSexo(rs.getBoolean("sexo"));
                me.setCorreo(rs.getString("correo"));
                me.setTelefono(rs.getString("telefono"));
                me.setId_medico(rs.getInt("id_medico"));
            }
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
        return me;
    }
    
    
    public void modificar(Medico med) throws Exception {
        String sql = "UPDATE paciente SET "
                + "Nombre = '" + med.getNombre()+ "', "
                + "Apellido = '" + med.getApellido()+ "', "
                + "Edad = '" + med.getEdad()+ "', "
                + "Sexo = '" + med.isSexo()+ "', "
                + "Correo = '" + med.getCorreo()+ "', "
                + "Telefono = '" + med.getTelefono()+ "', "
                + "ID = '" + med.getId_medico()+ "', ";
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
        String sql = "DELETE FROM medico "
                + "WHERE id_medico=" + id + ";";
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
    
    public List<Medico> buscarNombre(String nombre) throws Exception{
        List<Medico> medico = null;
        Medico me = null;
        ResultSet rs = null;
        
        try{
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT * "
                    + "FROM medico  WHERE nombre LIKE '%" + nombre + "%'");
            
            medico = new ArrayList<>();
            while (rs.next() == true){
                me = new Medico();
                me.setNombre(rs.getString("nombre"));
                me.setApellido(rs.getString("apellido"));
                me.setEdad(rs.getInt("edad"));
                me.setSexo(rs.getBoolean("sexo"));
                me.setCorreo(rs.getString("correo"));
                me.setTelefono(rs.getString("telefono"));
                me.setId_medico(rs.getInt("id_medico"));
                medico.add(me);
                
            }
            rs.close();
            this.cerrar(true);
        } catch(Exception e){
            this.cerrar(false);
            throw  e;
        }
        return medico;
    }
}
