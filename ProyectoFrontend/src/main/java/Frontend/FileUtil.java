package Frontend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author ordson
 */
public class FileUtil {

    private ArrayList<File> archivos = new ArrayList<>();

    public void findFiles(File folder) {
        this.archivos.clear();
        if (folder == null) {
            return;
        }
        try {
            for (File file : folder.listFiles()) {
                if (!file.isDirectory()) {
                    if (FilenameUtils.getExtension(file.getPath()).equals("java")) {
                        archivos.add(file);
                    }
                } else {
                    findFiles(file);
                }
            }
        } catch (IllegalArgumentException e) {

        } finally {

        }
    }

    public File chooseDirectory() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos JAVA", "java");
        fileChooser.setFileFilter(filtro);

        int result = fileChooser.showOpenDialog(null);

        if (result != JFileChooser.CANCEL_OPTION) {

            File archivo = fileChooser.getSelectedFile();

            if ((archivo != null)) {
                if ((!archivo.getName().isEmpty())) {
                    return archivo;
                }
            }
        }
        return null;
    }

    public void showFileList() {
        int contador = 0;
        for (File archivo : archivos) {
            contador++;
            System.out.println(contador + " " + archivo.getPath());
        }
    }

    public String getFileText(File file) {
        StringBuilder texto = new StringBuilder("");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                texto.append(scanner.nextLine()).append("\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("nel");
        }
        return texto.toString();
    }

    public ArrayList<File> getArchivos() {
        return archivos;
    }

    public void setArchivos(ArrayList<File> archivos) {
        this.archivos = archivos;
    }
    public void guardarJson(String json){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int accion = fileChooser.showSaveDialog(fileChooser);
        if (accion!= JFileChooser.CANCEL_OPTION) {
            try {

                Files.writeString(fileChooser.getSelectedFile().toPath(),json);
            } catch (IOException e) {
            }
        }
    }
    
    public String cargarJson(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int accion = fileChooser.showOpenDialog(fileChooser);
        if (accion != JFileChooser.CANCEL_OPTION) {
            return getFileText(fileChooser.getSelectedFile());
        }
        return "";
    }
}
