import java.util.ArrayList;

class Nota {
    private String catedra;
    private double notaExamen;

    // Constructor
    public Nota(String catedra, double notaExamen) {
        this.catedra = catedra;
        this.notaExamen = notaExamen;
    }

    // Getters
    public String getCatedra() {
        return catedra;
    }

    public double getNotaExamen() {
        return notaExamen;
    }

    @Override
    public String toString() {
        return "Cátedra: " + catedra + ", Nota: " + notaExamen;
    }
}

class Alumno {
    private String nombreCompleto;
    private long legajo;
    private ArrayList<Nota> notas;

    // Constructor
    public Alumno(String nombreCompleto, long legajo) {
        this.nombreCompleto = nombreCompleto;
        this.legajo = legajo;
        this.notas = new ArrayList<>();
    }

    // Métodos para manejar las notas
    public void agregarNota(Nota nota) {
        notas.add(nota);
    }

    public ArrayList<Nota> getNotas() {
        return notas;
    }

    // Método para calcular el promedio de las notas
    public double calcularPromedio() {
        if (notas.isEmpty()) {
            return 0;
        }
        double suma = 0;
        for (Nota nota : notas) {
            suma += nota.getNotaExamen();
        }
        return suma / notas.size();
    }

    @Override
    public String toString() {
        return "Alumno: " + nombreCompleto + ", Legajo: " + legajo;
    }
}
