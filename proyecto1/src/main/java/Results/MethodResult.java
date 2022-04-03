/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Results;

import DataClasses.MethodData;
import java.util.ArrayList;

/**
 *
 * @author ordson
 */
public class MethodResult {
    private int repeticiones;
    private MethodData metodo;

    public int getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

    public MethodData getMetodo() {
        return metodo;
    }

    public void setMetodo(MethodData metodo) {
        this.metodo = metodo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MethodResult{");
        sb.append("repeticiones=").append(repeticiones);
        sb.append(", metodo=").append(metodo.getNombre());
        sb.append('}');
        return sb.toString();
    }

    public void agregarRepeticion() {
        this.repeticiones++;
    }
    
}
