import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Leer {

    public static void main(String[] args) {
        // Ruta del archivo de texto
        String rutaArchivo = "archivo.txt";

        try {
            // Crear un objeto FileReader para leer el archivo
            FileReader fileReader = new FileReader(rutaArchivo);

            // Crear un objeto BufferedReader para facilitar la lectura
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Variable para almacenar cada línea leída
            String linea;

            // Leer y mostrar cada palabra del archivo
            while ((linea = bufferedReader.readLine()) != null) {
                // Dividir la línea en palabras usando el espacio como delimitador
                String[] palabras = linea.split(" ");

                // Imprimir cada palabra
                for (String palabra : palabras) {
                    System.out.println(palabra);
                }
            }

            // Cerrar el BufferedReader después de su uso
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
