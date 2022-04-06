/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JParser;

import DataClasses.MethodData;
import DataClasses.VariableData;
import java.util.ArrayList;

/**
 *
 * @author ordson
 */
public class JSONRecorder {
    ArrayList<String> clases = new ArrayList<>();
    ArrayList<MethodData> metodos = new ArrayList<>();
    ArrayList<VariableData> variables = new ArrayList<>();
    StringBuilder string = new StringBuilder();
    String score;
    
    
    public void addClase(String clase){
        clases.add(clase);
    }
    
    public void addMetodo(String name, String tipo, String parametros){
        try {
            System.out.println("INFOMETODO"+" "+name+" "+tipo+" "+parametros);
            int params = Integer.parseInt(parametros);
            MethodData metodo = new MethodData();
            metodo.setNombre(name);
            metodo.setTipo(tipo);
            metodo.setArgumentos(params);
            metodos.add(metodo);
        } catch (NumberFormatException e) {
            MethodData metodo = new MethodData();
            metodo.setNombre(name);
            metodo.setTipo(tipo);
            metodo.setArgumentos(0);
            metodos.add(metodo);
        }
    }
    
    public void addVariable(String name, String tipo){
        VariableData variable = new VariableData();
        variable.setNombre(name);
        variable.setTipo(tipo);
        variable.setMetodo(string.toString());
        variables.add(variable);
        string.setLength(0);
    }
    
    public void append(String cadena){
        string.append(cadena);
        System.out.println("APENDICEE"+string.toString());
    }
    
    public void setScore(String score){
        this.score = score;
    }
    
    public void imprimir(){
        for (String clase : clases) {
            System.out.println("Clase: "+clase);
        }
        
        for (VariableData variable : variables) {
            System.out.println(variable.toString());
        }
        for (MethodData metodo : metodos) {
            System.out.println(metodo.toString());
        }
    }
    
    
}
