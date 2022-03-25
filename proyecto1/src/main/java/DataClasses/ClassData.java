/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataClasses;

import java.util.ArrayList;

/**
 *
 * @author ordson
 */
public class ClassData {
    private ArrayList<MethodData> metodos;
    private String nombre;
    private String visibilidad;

    public ArrayList<MethodData> getMetodos() {
        return metodos;
    }

    public void setMetodos(ArrayList<MethodData> metodos) {
        this.metodos = metodos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVisibilidad() {
        return visibilidad;
    }

    public void setVisibilidad(String visibilidad) {
        this.visibilidad = visibilidad;
    }
    
}
