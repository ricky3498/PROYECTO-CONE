/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import accesodatos.Conexion;
import entidades.Paciente;
import entidades.historial_clinico;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alberto
 */
public class DAO_historial_clinico extends Conexion{
    public void registrar(historial_clinico hc) throws Exception {
        String sql = "INSERT INTO historial_clinico( id_historial, id_paciente,id_atencion, estado) "
                + " VALUES ( '" + hc.getId_historial()+ "', '" + hc.getId_paciente()
                + "', '" + hc.getId_atencion()+ "','" + hc.isEstado()
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
    
    public List<historial_clinico> listar() throws Exception {
        List<historial_clinico> historial = null;
        historial_clinico hc;
        ResultSet rs = null;
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT hc.id_historial, hc.id_paciente, hc.id_atencion, hc.estado"
                    + " FROM historial_clinico hc "
                    + "ORDER BY hc.id_paciente");
            historial = new ArrayList<>();
            while (rs.next() == true) {
                hc = new historial_clinico();
                hc.setId_historial(rs.getInt("id_historial"));
                hc.setId_paciente(rs.getInt("id_paciente"));
                hc.setId_atencion(rs.getInt("id_atencion"));
                //me.setCodigo(rs.getInt("Codigo"));
                hc.setEstado(rs.getBoolean("estado"));
                historial.add(hc);
            }
            rs.close();
            this.cerrar(true);
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
        return historial;
    }
    
    
    public historial_clinico leer(int id) throws Exception {
        historial_clinico hc = null;
        ResultSet rs = null;
        try {
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT * "
                    + " FROM historial "
                    + " WHERE codigo = " + id + ";");
            while (rs.next() == true) {
                hc = new historial_clinico();
                hc.setId_historial(rs.getInt("id_historial"));
                hc.setId_paciente(rs.getInt("id_paciente"));
                hc.setId_atencion(rs.getInt("id_atencion"));
                //me.setCodigo(rs.getInt("Codigo"));
                hc.setEstado(rs.getBoolean("estado"));
            }
        } catch (Exception e) {
            this.cerrar(false);
            throw e;
        }
        return hc;
    }
    
    
    public void modificar(historial_clinico hc) throws Exception {
        String sql = "UPDATE historial SET "
                + "Historial = '" + hc.getId_historial()+ "', "
                + "Paciente = '" + hc.getId_paciente()+ "', "
                + "Atencion = '" + hc.getId_atencion()+ "', "
                + "Estado = '" + hc.isEstado()+ "', ";
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
        String sql = "DELETE FROM historial "
                + "WHERE historial=" + id + ";";
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
    
    public List<historial_clinico> buscarNombre(String nombre) throws Exception{
        List<historial_clinico> historial = null;
        historial_clinico hc = null;
        ResultSet rs = null;
        
        try{
            this.conectar(false);
            rs = this.ejecutarOrdenDatos("SELECT * "
                    + "FROM paciente  WHERE nombre LIKE '%" + nombre + "%'");
            
            historial = new ArrayList<>();
            while (rs.next() == true){
                hc = new historial_clinico();
                hc.setId_historial(rs.getInt("id_historial"));
                hc.setId_paciente(rs.getInt("id_paciente"));
                hc.setId_atencion(rs.getInt("id_atencion"));
                //me.setCodigo(rs.getInt("Codigo"));
                hc.setEstado(rs.getBoolean("estado"));
                historial.add(hc);              
            }
            rs.close();
            this.cerrar(true);
        } catch(Exception e){
            this.cerrar(false);
            throw  e;
        }
        return historial;
    }
}
