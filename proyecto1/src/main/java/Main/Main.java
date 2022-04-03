/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Util.Lector;

/**
 *
 * @author ordson
 */
public class Main {

    private String pepe, lol, neneco;

    public static void main(String[] args) {
//        FileUtil fileUtil = new FileUtil();
//        fileUtil.findFiles(fileUtil.chooseDirectory());
//        fileUtil.showFileList();

        Lector analizador = new Lector();
        analizador.leerDosCarpetas();

    }
}
