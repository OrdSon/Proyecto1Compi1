/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import DataClasses.ClassData;
import DataClasses.MethodData;
import DataClasses.VariableData;
import java.util.ArrayList;

/**
 *
 * @author ordson
 */
public class DataRecorder {
    private ArrayList<ClassData> clases = new ArrayList<>();
    private ClassData claseActiva;
    private ArrayList<MethodData> metodos = new ArrayList<>();
    private MethodData metodoActivo;
    private ArrayList<VariableData> variables = new ArrayList<>();
    private ArrayList<VariableData> variablesActivas = new ArrayList<>();
    private String tipo;

    public ArrayList<ClassData> getClases() {
        return clases;
    }

    public void setClases(ArrayList<ClassData> clases) {
        this.clases = clases;
    }

    public ClassData getClaseActiva() {
        return claseActiva;
    }

    public void setClaseActiva(ClassData claseActiva) {
        this.claseActiva = claseActiva;
    }

    public ArrayList<MethodData> getMetodos() {
        return metodos;
    }

    public void setMetodos(ArrayList<MethodData> metodos) {
        this.metodos = metodos;
    }

    public MethodData getMetodoActivo() {
        return metodoActivo;
    }

    public void setMetodoActivo(MethodData metodoActivo) {
        this.metodoActivo = metodoActivo;
    }

    public ArrayList<VariableData> getVariables() {
        return variables;
    }

    public void setVariables(ArrayList<VariableData> variables) {
        this.variables = variables;
    }

    public ArrayList<VariableData> getVariablesActivas() {
        return variablesActivas;
    }

    public void setVariablesActivas(ArrayList<VariableData> variablesActivas) {
        this.variablesActivas = variablesActivas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setClaseActiva(String n) {
        this.claseActiva = new ClassData();
        claseActiva.setNombre(n);
    }

    public void addVariable(String id) {
        VariableData temp = new VariableData();
        temp.setTipo(tipo);
        temp.setNombre(id);
        variablesActivas.add(temp);
    }

    public void cambiarTipo(String tipo) {
        for (VariableData temp : variablesActivas) {
            temp.setTipo(tipo);
        }
    }

    public void guardar() {
        for (VariableData temp : variablesActivas) {
            variables.add(temp);
        }
        variablesActivas.clear();
    }

    public void setTipoMetodo(String c) {
        if (this.metodoActivo!=null) {
            this.metodoActivo.setTipo(c);
        }
    }

    public void setTipo() {
        if (metodoActivo!=null) {
            this.metodoActivo.setTipo(tipo);
        }
    }

    public void setValor(String c) {
        for (VariableData temp : variablesActivas ) {
            temp.setValor(c);
        }
    }

    public void guardarMetodo() {
        metodos.add(metodoActivo);
        metodoActivo=new MethodData();
    }

    public void addMetodo(String n) {
        this.metodoActivo = new MethodData();
        metodoActivo.setNombre(n);
    }


    public void imprimir(){
        System.out.println("Clase Activa "+claseActiva.getNombre());
        for (MethodData metodo: metodos) {
            System.out.println("Metodo "+metodo.getTipo()+"  "+metodo.getNombre()); 
        }
        for (VariableData variable: variables){
            System.out.println("Variable "+variable.getTipo()+" "+variable.getNombre()+" "+variable.getValor());
        }
    }
    
}
