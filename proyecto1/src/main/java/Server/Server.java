/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import JParser.JSONLexer;
import JParser.JSONParser;
import JParser.JSONRecorder;
import Util.JSONGenerator;
import Util.Lector;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StringReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ordson
 */
public class Server {

    Lector lector = new Lector();
    ServerSocket serverSocket;
    JSONGenerator generador = new JSONGenerator();
    JSONRecorder recorder = new JSONRecorder();
    String generacion;

    ArrayList<File> archivos = new ArrayList<>();
    boolean impreso;
    
    public void recibirJson(ServerSocket socket){
        try {
            System.out.println("Esperando conexion");
            Socket socket2 = socket.accept();
            System.out.println("conectado a " + socket);
            InputStream inputStream = socket2.getInputStream();
            ObjectInputStream flujoEntrada = new ObjectInputStream(inputStream);
            String mensaje = flujoEntrada.readUTF();
            System.out.println(mensaje);
            flujoEntrada.close();

        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<File> getData() {
        try {
            archivos.clear();
            System.out.println("Esperando conexion");
            Socket socket = serverSocket.accept();
            System.out.println("conectado a " + socket);
            InputStream inputStream = socket.getInputStream();
            ObjectInputStream flujoEntrada = new ObjectInputStream(inputStream);
            ArrayList<File> archivos = (ArrayList<File>) flujoEntrada.readObject();
            System.out.println("RECIBIDOS: " + archivos.size() + " Archivos");
            this.archivos = archivos;
            analizar(archivos);
            if (generacion != null && !generacion.isEmpty()) {
                ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
                os.writeUTF(generacion);
                os.close();
            }
            flujoEntrada.close();
            imprimir();
            socket.close();
            return archivos;
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    void setServerSocket(ServerSocket socket) {
        this.serverSocket = socket;
    }

    public void permitirImpresion() {
        this.impreso = true;
    }

    public void imprimir() {
        if (impreso) {
            for (File archivo : archivos) {
                System.out.println(archivo.getPath());
            }
        }
        impreso = false;
    }

    public void analizar(ArrayList<File> archivos) {
        if (archivos.size() < 2) {
            return;
        }
        File archivo1 = archivos.get(0);
        File archivo2 = archivos.get(1);
        if (archivo1 == null || archivo2 == null) {
            return;
        }
        lector.leerDosCarpetas(archivo1, archivo2);
        generador.setAnalizador(lector.getAnalizador());
        String json = generador.generarJSON();
        if (analizarJson(json)) {
            this.generacion = json;
        }
        
        if (!lector.getError().isBlank() || !lector.getError().isEmpty()) {
            generacion = lector.getError();
        }
    }

    public boolean analizarJson(String json) {
        StringReader reader = new StringReader(json); 
        JSONLexer lexer = new JSONLexer(reader);
        JSONParser parser = new JSONParser(lexer);
        try { 
            parser.setRecorder(recorder);
            parser.parse();
            if (!parser.getErr().isEmpty() || !lexer.getErr().isEmpty()) {
                StringBuilder sb = new StringBuilder();
                sb.append("ERROR");
                for (String string : parser.getErr()) {
                sb.append("\n").append(string);
                }
                sb.append("\n");
                for (String string : lexer.getErr()) {
                    sb.append("\n").append(string);
                }
                generacion = sb.toString();
                return false;
            }
            
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
