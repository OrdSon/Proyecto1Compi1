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
    boolean conTipo = false;
    private int argumentos;

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
        for (VariableData temp : variablesActivas) {
            if (temp.getTipo() == null) {
                temp.setTipo(tipo);
            }
        }
    }

    public void setClaseActiva(String n) {
        this.claseActiva = new ClassData();
        this.claseActiva.setNombre(n);
    }

    public void addVariable(String id) {
        VariableData temp = new VariableData();
        temp.setTipo(tipo);
        temp.setNombre(id);
        temp.setClase(claseActiva.getNombre());
        setearMetodo(temp);
        this.variablesActivas.add(temp);
    }

    private void setearMetodo(VariableData temp) {
        if (this.metodoActivo != null && this.metodoActivo.getNombre() != null) {
            temp.setMetodo(this.metodoActivo.getNombre());
            metodoActivo.addVariable(temp);
        } else {
            temp.setMetodo(this.claseActiva.getNombre());
        }
    }

    public void cambiarTipo(String tipo) {
        for (VariableData temp : this.variablesActivas) {
            temp.setTipo(tipo);
        }
    }

    public void guardar() {
        for (VariableData temp : this.variablesActivas) {
            this.variables.add(temp);
        }
        this.variablesActivas.clear();
        this.tipo = null;
    }

    public void setTipoMetodo(String c) {
        if (!metodos.isEmpty()) {
            MethodData temp = metodos.get(metodos.size() - 1);
            temp.setTipo(c);
        }
    }

    public void setTipoMetodo() {
        if (this.tipo != null) {
            this.metodoActivo.setTipo(tipo);
        } else {
            System.out.println("Nullll");
        }
    }

    public void setValor(String c) {
        for (VariableData temp : variablesActivas) {
            temp.setValor(c);
        }
    }

    public void guardarMetodo() {
        if (this.metodoActivo != null && this.metodoActivo.getNombre() != null && !this.metodoActivo.getNombre().equals("null")) {
            metodoActivo.setArgumentos(argumentos);
            metodos.add(metodoActivo);
            metodoActivo = new MethodData();
            this.conTipo = false;
            argumentos = 0;
            
        }

    }

    public void addMetodo(String n) {
        this.metodoActivo = new MethodData();
        metodoActivo.setNombre(n);
    }

    public void guardarClase(){
        if (this.claseActiva != null) {
            claseActiva.setMetodos((ArrayList<MethodData>) metodos.clone());
            claseActiva.setVariables((ArrayList<VariableData>) variables.clone());
            clases.add(claseActiva);
        }
        clearAll();
    }
    
    private void clearAll(){
        this.metodoActivo = null;
        this.metodos.clear();
        this.claseActiva = null;
        this.conTipo = false;
        this.tipo = null;
        this.variables.clear();
        this.variablesActivas.clear();
        this.argumentos = 0;
    }
    public void imprimir() {
        for (ClassData clase : clases) {
            if (clase != null) {
                System.out.println("Clase : " + clase.getNombre());
                for (MethodData metodo : clase.getMetodos()) {
                    System.out.println("Metodo " + metodo.toString());
                }
                for (VariableData variable : clase.getVariables()) {
                    System.out.println("Variable " + variable.getTipo() + " " + variable.getNombre() + " " + variable.getMetodo());
                }
            }
        }
    }

    public void contarArgumento() {
        this.argumentos++;
    }

    public void cerrarMetodo() {

    }

    public void cerrarConstructor() {
    }

    public void asignarInt() {
    }

    /*
    
    
    class prueba{
 String cadena;
int numero;
String cadena2;
short peque1;
Objetoo objetito;
Pele futbolista;
}
    
    
    
     */
}
