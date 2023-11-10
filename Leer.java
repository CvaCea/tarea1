import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Leer {

    public static void main(String[] args) {
        String filePath = "archivo.txt"; // Ruta del archivo
        try {
            String content = readTextFile(filePath);
            displaySortedWords(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readTextFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    private static void displaySortedWords(String content) {
        // Utiliza una expresión regular para encontrar las palabras entre barras diagonales
        Pattern pattern = Pattern.compile("/([^/]+?)/");
        Matcher matcher = pattern.matcher(content);

        // Utiliza un TreeSet para almacenar y ordenar las palabras
        Set<String> wordsSet = new TreeSet<>();

        // Itera sobre las coincidencias e agrega las palabras al TreeSet
        while (matcher.find()) {
            String word = matcher.group(1);
            wordsSet.add(word);
        }

        // Imprime las palabras ordenadas
        System.out.println("Palabras encontradas ordenadas alfabéticamente:");
        for (String word : wordsSet) {
            System.out.println(word);
        }
    }
}
