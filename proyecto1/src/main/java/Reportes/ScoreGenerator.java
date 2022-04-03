/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reportes;

import DataClasses.ClassData;
import Util.Analizador;
import java.util.ArrayList;

/**
 *
 * @author ordson
 */
public class ScoreGenerator {
    private double score = 0;
    public double generarScore(ArrayList<ClassData> lista1, ArrayList<ClassData> lista2, Analizador analizador) {
        /*
        ¡¡¡¡¡¡¡¡FALTA AGREGAR LO DE LOS COMENTARIOSSSSSS!!!!!!!
        */
        
        int cuentaVariables1 = getVariableCount(lista1);
        int cuentaVariables2 = getVariableCount(lista2);
        int cuentaMetodos1 = getMethodCount(lista1);
        int cuentaMetodos2 = getMethodCount(lista2);
        int cuentaClases1 = lista1.size();
        int cuentaClases2 = lista2.size();        
        
        int sumatoriaVariables = cuentaVariables1 + cuentaVariables2;
        int sumatoriaMetodos = cuentaMetodos1+cuentaMetodos2;
        int sumatoriaClases = cuentaClases1+cuentaClases2;
        
        int variablesRepetidas = analizador.getVariablesRepetidas().size();
        int metodosRepetidos = analizador.getMetodosRepetidos().size();
        int clasesRepetidas = analizador.getClasesRepetidas().size();
        
        score += (variablesRepetidas/(sumatoriaVariables)*0.25);
        score += (metodosRepetidos/(sumatoriaMetodos)*0.25);
        score += (clasesRepetidas/(sumatoriaClases)*0.25);
        
        return score;
    }

    private int getVariableCount(ArrayList<ClassData> lista) {
        int total = 0;
        for (ClassData classData : lista) {
            total += classData.getVariables().size();
        }
        return total;
    }

    private int getMethodCount(ArrayList<ClassData> lista) {
        int total = 0;
        for (ClassData classData : lista) {
            total += classData.getMetodos().size();
        }
        return total;
    }

    public double getScore() {
        return score;
    }
}
