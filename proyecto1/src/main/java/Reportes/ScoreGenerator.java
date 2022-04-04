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
    
    public double generarScore(ArrayList<ClassData> lista1, ArrayList<ClassData> lista2, Analizador analizador) {
        /*
        ¡¡¡¡¡¡¡¡FALTA AGREGAR LO DE LOS COMENTARIOSSSSSS!!!!!!!
        */
        double score = 0;
        double cuentaVariables1 = getVariableCount(lista1);
        double cuentaVariables2 = getVariableCount(lista2);
        double cuentaMetodos1 = getMethodCount(lista1);
        double cuentaMetodos2 = getMethodCount(lista2);
        double cuentaClases1 = lista1.size();
        double cuentaClases2 = lista2.size();        
        
        double sumatoriaVariables = cuentaVariables1 + cuentaVariables2;
        double sumatoriaMetodos = cuentaMetodos1+cuentaMetodos2;
        double sumatoriaClases = cuentaClases1+cuentaClases2;
        
        double variablesRepetidas = analizador.getVariablesRepetidas().size();
        double metodosRepetidos = analizador.getMetodosRepetidos().size();
        double clasesRepetidas = analizador.getClasesRepetidas().size();
        
        score+= ((variablesRepetidas/(sumatoriaVariables))*0.25);
        score+= ((metodosRepetidos/(sumatoriaMetodos))*0.25);
        score+= ((clasesRepetidas/(sumatoriaClases))*0.25);
        
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


}
