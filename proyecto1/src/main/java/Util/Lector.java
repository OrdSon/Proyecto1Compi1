/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import DataClasses.ClassData;
import DataClasses.MethodData;
import DataClasses.VariableData;
import Parser.Lexer;
import Parser.Parser;
import Reportes.ScoreGenerator;
import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ordson
 */
public class Lector {

    DataRecorder recorder = new DataRecorder();

    private FileUtil fileUtil;
    String primerDirectorio;
    String segundoDirectorio;
    ArrayList<File> proyecto1;
    ArrayList<File> proyecto2;
    ArrayList<ClassData> clasesProyecto1;
    ArrayList<ClassData> clasesProyecto2;
    Analizador analizador = new Analizador();

    public Analizador getAnalizador() {
        return analizador;
    }

    public void setAnalizador(Analizador analizador) {
        this.analizador = analizador;
    }

    public void leerDosCarpetas(File temp1, File temp2) {
        fileUtil.findFiles(temp1);
        proyecto1 = (ArrayList<File>) fileUtil.getArchivos().clone();
        fileUtil.findFiles(temp2);
        proyecto2 = (ArrayList<File>) fileUtil.getArchivos().clone();
        parsear(proyecto1);
        clasesProyecto1 = (ArrayList<ClassData>) recorder.getClases().clone();
        recorder.getClases().clear();
        parsear(proyecto2);
        clasesProyecto2 = (ArrayList<ClassData>) recorder.getClases().clone();
        recorder.getClases().clear();
        imprimir(clasesProyecto1);
        imprimir(clasesProyecto2);
        
        System.out.println("****************************");
        System.out.println("****************************");
        System.out.println("****************************");
        System.out.println("****************************");
        
        analizador.analizarTodo(clasesProyecto1, clasesProyecto2);
        
        
    }

    public void parsear(ArrayList<File> archivos) {
        for (File file : archivos) {
            try {
                StringReader reader = new StringReader(fileUtil.getFileText(file));
                Parser parser = new Parser(new Lexer(reader));
                parser.setRecorder(recorder);
                parser.parse();
                recorder.guardarClase();
            } catch (Exception ex) {
                Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    
    public void imprimir(ArrayList<ClassData> clases){
        for (ClassData clase : clases) {
            if (clase != null) {
                System.out.println("Clase : " + clase.getNombre());
                for (MethodData metodo : clase.getMetodos()) {
                    System.out.println("Metodo " +metodo.toString());
                }
                for (VariableData variable : clase.getVariables()) {
                    System.out.println("Variable " + variable.getTipo() + " " + variable.getNombre() + " " + variable.getMetodo());
                }
            }
        }
    }

    public FileUtil getFileUtil() {
        return fileUtil;
    }

    public void setFileUtil(FileUtil fileUtil) {
        this.fileUtil = fileUtil;
    }
    
    
    
}
