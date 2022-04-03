/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Results;

import java.util.ArrayList;

/**
 *
 * @author ordson
 */
public class VariableResult {
    private String nombre;
    private String tipo;
    private ArrayList<String> metodos = new ArrayList<>();
    private int repeticiones;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void añadirMetodo(String tipo){
        this.metodos.add(tipo);
    }
    public ArrayList<String> getMetodos() {
        return metodos;
    }

    public void setMetodos(ArrayList<String> metodos) {
        this.metodos = metodos;
    }
    
    public void añadirRepeticion(){
        repeticiones++;
    }
    
    public int getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VariableResult{");
        sb.append("nombre=").append(nombre);
        sb.append(", tipo=").append(tipo);
        sb.append(", metodos=");
        for (String metodo : metodos) {
            sb.append(" | ").append(metodo);
        }
        sb.append(", repeticiones=").append(repeticiones);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
