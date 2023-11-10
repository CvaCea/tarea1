public class Diccionario {
    private Nodo raiz;

    public Diccionario() {
        this.raiz = null;
    }

    public void insertar(String palabra, int pagina) {
        raiz = insertarRec(raiz, palabra, pagina);
    }

    private Nodo insertarRec(Nodo nodo, String palabra, int pagina) {
        if (nodo == null) {
            return new Nodo(palabra, pagina);
        }

        // Comparación lexicográfica para determinar la posición en el árbol
        if (palabra.compareTo(nodo.palabra) < 0) {
            nodo.izquierda = insertarRec(nodo.izquierda, palabra, pagina);
        } else if (palabra.compareTo(nodo.palabra) > 0) {
            nodo.derecha = insertarRec(nodo.derecha, palabra, pagina);
        } else {
            // Si la palabra ya existe, actualiza las páginas y la frecuencia
            nodo.paginas.add(pagina);
            nodo.frecuencia++;
        }

        return nodo;
    }

    public void mostrarDiccionario(Nodo nodo) {
        if (nodo != null) {
            mostrarDiccionario(nodo.izquierda);
            System.out.println( nodo.palabra+" \t" + nodo.paginas+ "\t (" + nodo.frecuencia+")");
            mostrarDiccionario(nodo.derecha);
        }
    }

    public static void main(String[] args) {
        Diccionario diccionario = new Diccionario();

        diccionario.insertar("Hola", 1);
        diccionario.insertar("Mundo", 1);
        diccionario.insertar("Hola", 2);
        diccionario.insertar("Java", 3);
        diccionario.insertar("Mundo", 4);

        diccionario.mostrarDiccionario(diccionario.raiz);
    }
}
