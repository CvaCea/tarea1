import java.util.ArrayList;
class Nodo {
    String palabra;
    ArrayList<Integer> paginas;
    int frecuencia;
    Nodo izquierda, derecha;

    public Nodo(String palabra, int pagina) {
        this.palabra = palabra;
        this.paginas = new ArrayList<>();
        this.paginas.add(pagina);
        this.frecuencia = 1;
        this.izquierda = this.derecha = null;
    }
    public void setPaginas(int pagina) {
        if (!paginas.contains(pagina)) {
            paginas.add(pagina);
        }
    }
}

