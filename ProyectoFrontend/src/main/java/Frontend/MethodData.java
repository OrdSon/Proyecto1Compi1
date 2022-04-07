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
public class MethodData {
    private String nombre;
    private String tipo;
    private int argumentos;
    private ArrayList<VariableData> variables = new ArrayList<>();
    
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

    public int getArgumentos() {
        return argumentos;
    }

    public void setArgumentos(int argumentos) {
        this.argumentos = argumentos;
    }

    public ArrayList<VariableData> getVariables() {
        return variables;
    }

    public void setVariables(ArrayList<VariableData> variables) {
        this.variables = variables;
    }
    
    public void addVariable(VariableData variableData){
        this.variables.add(variableData);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MethodData{");
        sb.append("nombre=").append(nombre);
        sb.append(", tipo=").append(tipo);
        sb.append(", argumentos=").append(argumentos);
        sb.append("Variables del metodo");
        for (VariableData variable : variables) {
            sb.append(variable.toString()).append("\n");
        }
        sb.append('}');
        return sb.toString();
    }
    
    
}
