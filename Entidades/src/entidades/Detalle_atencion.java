/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Alberto
 */
public class Detalle_atencion {
    private int id_detalle_atencion;
    private int id_atencion;
    private int id_medicamentos;
    private String tratamiento;
    private boolean estado;

    public int getId_detalle_atencion() {
        return id_detalle_atencion;
    }

    public void setId_detalle_atencion(int id_detalle_atencion) {
        this.id_detalle_atencion = id_detalle_atencion;
    }

    public int getId_atencion() {
        return id_atencion;
    }

    public void setId_atencion(int id_atencion) {
        this.id_atencion = id_atencion;
    }

    public int getId_medicamentos() {
        return id_medicamentos;
    }

    public void setId_medicamentos(int id_medicamentos) {
        this.id_medicamentos = id_medicamentos;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
}
