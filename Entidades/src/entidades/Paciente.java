/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author jhon
 */
public class Paciente {
    private int id_pac;
    private String dni_pac;
    private String nombre_pac;
    private String apellido_pac;
    private int id_usuario;

    public int getId_pac() {
        return id_pac;
    }

    public void setId_pac(int id_pac) {
        this.id_pac = id_pac;
    }

    public String getDni_pac() {
        return dni_pac;
    }

    public void setDni_pac(String dni_pac) {
        this.dni_pac = dni_pac;
    }

    public String getNombre_pac() {
        return nombre_pac;
    }

    public void setNombre_pac(String nombre_pac) {
        this.nombre_pac = nombre_pac;
    }

    public String getApellido_pac() {
        return apellido_pac;
    }

    public void setApellido_pac(String apellido_pac) {
        this.apellido_pac = apellido_pac;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    
    
}
