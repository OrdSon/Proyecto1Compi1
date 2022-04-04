/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import DataClasses.ClassData;
import DataClasses.MethodData;
import DataClasses.VariableData;
import Reportes.ScoreGenerator;
import Results.MethodResult;
import Results.VariableResult;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author ordson
 */
public class Analizador {

    private ArrayList<VariableResult> variablesRepetidas = new ArrayList<>();
    private ArrayList<MethodResult> metodosRepetidos = new ArrayList<>();
    private ArrayList<ClassData> clasesRepetidas = new ArrayList<>();
    private ArrayList<ClassData> lista1 = new ArrayList<>();
    private ArrayList<ClassData> lista2 = new ArrayList<>();
    private double score = 0;
    public void analizarTodo(ArrayList<ClassData> lista1, ArrayList<ClassData> lista2) {
        this.lista1=lista1;
        this.lista2=lista2;
        for (ClassData clase1 : lista1) {

            for (ClassData clase2 : lista2) {
                analizarVariables(clase1.getVariables(), clase2.getVariables());
                analizarMetodos(clase1.getMetodos(), clase2.getMetodos());
                analizarClases(lista1, lista2);
            }

        }
        
        System.out.println("SCOREE "+score);
        corregirRepeticiones();
        imprimir();

    }

    public void analizarClases(ArrayList<ClassData> lista1, ArrayList<ClassData> lista2) {
        for (ClassData clase1 : lista1) {
            for (ClassData clase2 : lista2) {
                System.out.println(clase1.getNombre()+"  "+clase2.getNombre());
                if (clase1.getNombre().equals(clase2.getNombre())) {
                    if (compararMetodos(clase1.getMetodos(), clase2.getMetodos())) {
                        if (!esClaseRepetida(clase1.getNombre())) {
                            clasesRepetidas.add(clase1);
                        }
                    }
                }
            }
        }
    }
    private boolean esClaseRepetida(String nombre){
        for (ClassData clasesRepetida : clasesRepetidas) {
            if (clasesRepetida.getNombre().equals(nombre)) {
                return true; 
            }
        }
        return false;
    }
    public boolean compararMetodos(ArrayList<MethodData> lista1, ArrayList<MethodData> lista2) {
        if (lista1.size() != lista2.size()) {
            return false;
        }
        ArrayList<String> metodos1 = new ArrayList<>();
        ArrayList<String> metodos2 = new ArrayList<>();
        for (MethodData methodData : lista1) {
            metodos1.add(methodData.getNombre());
        }
        for (MethodData methodData : lista2) {
            metodos2.add(methodData.getNombre());
        }
        
        Collections.sort(metodos1);
        Collections.sort(metodos2);
        
        return metodos1.equals(metodos2);/*
        int contador = 0;
        for (MethodData metodo1 : lista1) {
            for (MethodData metodo2 : lista2) {
                System.out.println(metodo1.getNombre()+"  "+metodo2.getNombre());
                if (metodo1.getNombre().equals(metodo2.getNombre())) {
                    contador++;
                }
            }
        }
        return lista1.size() == contador;*/
    }

    public void analizarMetodos(ArrayList<MethodData> lista1, ArrayList<MethodData> lista2) {

        for (MethodData metodo1 : lista1) {

            for (MethodData metodo2 : lista2) {
                if (metodo1.getTipo() == null || metodo2.getTipo() == null) {
                    continue;
                }
                if (metodo1.getNombre().equals(metodo2.getNombre())
                        && metodo1.getTipo().equals(metodo2.getTipo())
                        && metodo1.getArgumentos() == metodo2.getArgumentos()) {
                    if (metodo1.getArgumentos() == 0) {
                        int encontrado = isMetodoReconocido(metodo1);
                        if (encontrado < 0) {
                            MethodResult nuevo = new MethodResult();
                            nuevo.setMetodo(metodo1);
                            nuevo.agregarRepeticion();
                            metodosRepetidos.add(nuevo);
                        } else {
                            metodosRepetidos.get(encontrado).agregarRepeticion();
                        }
                    } else {
                        if (compararArgumentos(metodo1, metodo2)) {
                            int encontrado = isMetodoReconocido(metodo1);
                            if (encontrado < 0) {
                                MethodResult nuevo = new MethodResult();
                                nuevo.setMetodo(metodo1);
                                nuevo.agregarRepeticion();
                                metodosRepetidos.add(nuevo);
                            } else {
                                metodosRepetidos.get(encontrado).agregarRepeticion();
                            }
                        }
//                        for (int i = 0; i < metodo1.getArgumentos(); i++) {
//                            for (int j = 0; j < metodo2.getArgumentos(); j++) {
//                                VariableData temporal1 = metodo1.getVariables().get(i);
//                                VariableData temporal2 = metodo1.getVariables().get(j);
//                                if (temporal1.getNombre().equals(temporal2.getNombre())
//                                        && temporal1.getTipo().equals(temporal2.getTipo())) {
//                                    int encontrado = isMetodoReconocido(metodo1);
//                                    if (encontrado < 0) {
//                                        MethodResult nuevo = new MethodResult();
//                                        nuevo.setMetodo(metodo1);
//                                        nuevo.agregarRepeticion();
//                                        metodosRepetidos.add(nuevo);
//                                    } else {
//                                        metodosRepetidos.get(encontrado).agregarRepeticion();
//                                    }
//                                }
//                            }
//                        }
                    }
                }
            }
        }

    }

    public boolean compararArgumentos(MethodData metodo1, MethodData metodo2) {
        ArrayList<VariableData> args1 = new ArrayList<>();
        ArrayList<VariableData> args2 = new ArrayList<>();
        for (int i = 0; i < metodo1.getArgumentos(); i++) {
            args1.add(metodo1.getVariables().get(i));
        }
        for (int i = 0; i < metodo2.getArgumentos(); i++) {
            args2.add(metodo2.getVariables().get(i));
        }

        int contador = 0;
        for (VariableData variable1 : args1) {
            for (VariableData variable2 : args2) {
                if (variable1.getNombre().equals(variable2.getNombre())
                        && variable1.getTipo().equals(variable2.getTipo())) {
                    contador++;
                }
            }
        }
        return contador == args1.size();

    }

    public void analizarVariables(ArrayList<VariableData> lista1, ArrayList<VariableData> lista2) {
        for (VariableData variable1 : lista1) {

            for (VariableData variable2 : lista2) {
                //compara los tipos de variables
                if (variable1.getTipo().equals(variable2.getTipo())) {
                    //compara los nombres de las variables
                    if (variable1.getNombre().equals(variable2.getNombre())) {
                        //Revisa si se habia encontrado una variable con el mismo tipo
                        variableRepetida(variable1);
                    }
                }
            }

        }
        //
        System.out.println("fin metodo");

    }

    public void variableRepetida(VariableData variable) {
        for (VariableResult variableRepetida : variablesRepetidas) {
            System.out.println(variableRepetida.getNombre() + " " + variable.getNombre());
            System.out.println(variableRepetida.getTipo() + " " + variable.getTipo());

            if (variableRepetida.getNombre().equals(variable.getNombre())
                    && variableRepetida.getTipo().equals(variable.getTipo())) {

                if (!isFuncionReconocida(variableRepetida.getMetodos(), variable.getMetodo())) {
                    variableRepetida.añadirMetodo(variable.getMetodo());
                    variableRepetida.añadirRepeticion();

                    return;
                }
                variableRepetida.añadirRepeticion();
                return;
            }
        }
        VariableResult nuevo = new VariableResult();
        nuevo.añadirRepeticion();
        nuevo.setNombre(variable.getNombre());
        nuevo.setTipo(variable.getTipo());
        nuevo.añadirMetodo(variable.getMetodo());
        variablesRepetidas.add(nuevo);
    }

    public int isMetodoReconocido(MethodData metodo) {
        int contador = 0;
        for (MethodResult resultado : metodosRepetidos) {
            if (resultado.getMetodo().getNombre().equals(metodo.getNombre())
                    && resultado.getMetodo().getTipo().equals(metodo.getTipo())
                    && resultado.getMetodo().getArgumentos() == metodo.getArgumentos()) {
                return contador;
            }
            contador++;
        }
        return -1;
    }

    public boolean isFuncionReconocida(ArrayList<String> metodos, String metodo) {
        for (String metodo1 : metodos) {
            System.out.println(metodo1 + " " + metodo);
            if (metodo1.equals(metodo)) {
                return true;
            }
        }
        return false;

    }

    public void corregirRepeticiones() {
        for (int i = 0; i < variablesRepetidas.size(); i++) {
            VariableResult temp = variablesRepetidas.get(i);

            int cuadrado = temp.getRepeticiones();
            System.out.println(cuadrado + "");
            int raiz = (int) Math.sqrt(cuadrado);
            variablesRepetidas.get(i).setRepeticiones(raiz);

        }
        for (MethodResult temp : metodosRepetidos) {
            temp.setRepeticiones((int) Math.sqrt(temp.getRepeticiones()));
        }
    }

    public void imprimir() {
        for (VariableResult variable : variablesRepetidas) {

            System.out.println(variable.toString());

        }
        for (MethodResult metodo : metodosRepetidos) {
            System.out.println(metodo.toString());
        }
        for (ClassData clase : clasesRepetidas) {
            System.out.println(clase.getNombre());
        }
    }

    public ArrayList<VariableResult> getVariablesRepetidas() {
        return variablesRepetidas;
    }

    public ArrayList<MethodResult> getMetodosRepetidos() {
        return metodosRepetidos;
    }

    public ArrayList<ClassData> getClasesRepetidas() {
        return clasesRepetidas;
    }

    public double getScore() {
        return score;
    }

    public ArrayList<ClassData> getLista1() {
        return lista1;
    }

    public void setLista1(ArrayList<ClassData> lista1) {
        this.lista1 = lista1;
    }

    public ArrayList<ClassData> getLista2() {
        return lista2;
    }

    public void setLista2(ArrayList<ClassData> lista2) {
        this.lista2 = lista2;
    }
    
    

}
