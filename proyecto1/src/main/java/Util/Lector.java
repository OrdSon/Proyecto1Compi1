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
import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;

/**
 *
 * @author ordson
 */
public class Lector {

    DataRecorder recorder = new DataRecorder();

    private FileUtil fileUtil = new FileUtil();
    String primerDirectorio;
    String segundoDirectorio;
    ArrayList<File> proyecto1;
    ArrayList<File> proyecto2;
    ArrayList<ClassData> clasesProyecto1;
    ArrayList<ClassData> clasesProyecto2;
    Analizador analizador = new Analizador();
    private String error = "";

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
            Parser parser = null;
            StringReader reader = new StringReader(fileUtil.getFileText(file));
            Lexer lexer = new Lexer(reader);
            try {

                parser = new Parser(lexer);
                parser.setRecorder(recorder);
                parser.parse();
                if (!parser.getErr().isEmpty()) {
                    guardarErrores(lexer, parser);
                    return;
                }
                recorder.guardarClase();
            } catch (Exception ex) {
                guardarErrores(lexer, parser);

            }
        }
    }
    
    public void guardarErrores(Lexer lexer, Parser parser){
        StringBuilder builder = new StringBuilder("ERROR ");
                for (String string : lexer.getErr()) {
                    builder.append("\n").append("Lexer: ").append(string);
                }

                if (parser != null) {
                    for (String string : parser.getErr()) {
                        builder.append("\n").append("Parser: ").append(string);
                    }
                }
                this.error = builder.toString();
    }

    public void imprimir(ArrayList<ClassData> clases) {
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

    public FileUtil getFileUtil() {
        return fileUtil;
    }

    public void setFileUtil(FileUtil fileUtil) {
        this.fileUtil = fileUtil;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
