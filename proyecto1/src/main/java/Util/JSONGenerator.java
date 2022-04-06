/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import DataClasses.ClassData;
import Reportes.ScoreGenerator;
import Results.MethodResult;
import Results.VariableResult;

/**
 *
 * @author ordson
 */
public class JSONGenerator {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("JSONGenerator{");
        sb.append("analizador=").append(analizador);
        sb.append(", scoreGenerator=").append(scoreGenerator);
        sb.append('}');
        return sb.toString();
    }
    
    private Analizador analizador;
    ScoreGenerator scoreGenerator = new ScoreGenerator();
    
    
    public String generarJSON(){
        double score = scoreGenerator.generarScore(analizador.getLista1(), analizador.getLista2(), analizador);
        System.out.println("SCORE GENERADOOO "+score);
        StringBuilder sb = new StringBuilder();
        sb.append("{ \n");
        sb.append("Score:").append(score).append(",").append("\n");        
        sb.append("Clases:[ \n");
   
        for (int i = 0; i < analizador.getClasesRepetidas().size(); i++) {
            ClassData claseRepetida = analizador.getClasesRepetidas().get(i);
            sb.append("\t{Nombre:").append("\"").append(claseRepetida.getNombre()).append("\"}");
            if (i<analizador.getClasesRepetidas().size()-1) {
                sb.append(", \n");
            }else{
                sb.append("\n");
            }
        }
        sb.append(" \t], \n");
        sb.append("Variables:[ \n");
        
        for (int i = 0; i < analizador.getVariablesRepetidas().size(); i++) {
            VariableResult variable = analizador.getVariablesRepetidas().get(i);
            sb.append("\t {Nombre:").append("\"").append(variable.getNombre()).append("\"").append(",");
            sb.append("Tipo:").append("\"").append(variable.getTipo()).append("\"").append(",");
            sb.append("Funcion:\"");
            for (int j = 0; j < variable.getMetodos().size(); j++) {
                String metodo = variable.getMetodos().get(j);
                sb.append(metodo);
                if (j<variable.getMetodos().size()-1) {
                    sb.append(",");
                }else{
                    sb.append("\"}");
                }
            }
            if (i<analizador.getVariablesRepetidas().size()-1) {
                    sb.append(",\n");
                }else{
                sb.append("\n \t],");
            }
        }
        sb.append("\n");
        sb.append("Metodos:[ \n");
        for (int i = 0; i < analizador.getMetodosRepetidos().size(); i++) {
            MethodResult metodo = analizador.getMetodosRepetidos().get(i);
            sb.append("\t {Nombre:").append("\"").append(metodo.getMetodo().getNombre()).append("\"").append(",");
            sb.append("Tipo:").append("\"").append(metodo.getMetodo().getTipo()).append("\"").append(",");
            sb.append("Parametros:").append(metodo.getMetodo().getArgumentos());
            sb.append("}");
            if (i<analizador.getMetodosRepetidos().size()-1) {
                sb.append(",\n");
            }
            
            
        }
        sb.append("\n \t]");
            
        
        sb.append("\n }");
        return sb.toString();
    }
    
    public Analizador getAnalizador() {
        return analizador;
    }

    public void setAnalizador(Analizador analizador) {
        this.analizador = analizador;
    }
    
}
