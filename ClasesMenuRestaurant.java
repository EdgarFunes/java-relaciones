import java.util.ArrayList;

class Ingrediente {
    private String nombre;
    private double cantidad;
    private String unidadDeMedida;

    // Constructor
    public Ingrediente(String nombre, double cantidad, String unidadDeMedida) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.unidadDeMedida = unidadDeMedida;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public double getCantidad() {
        return cantidad;
    }

    public String getUnidadDeMedida() {
        return unidadDeMedida;
    }

    @Override
    public String toString() {
        return nombre + " " + cantidad + " " + unidadDeMedida;
    }
}

class Plato {
    private String nombreCompleto;
    private double precio;
    private boolean esBebida;
    private ArrayList<Ingrediente> ingredientes;

    // Constructor
    public Plato(String nombreCompleto, double precio, boolean esBebida) {
        this.nombreCompleto = nombreCompleto;
        this.precio = precio;
        this.esBebida = esBebida;
        this.ingredientes = new ArrayList<>();
    }

    // Métodos para manejar ingredientes
    public void agregarIngrediente(Ingrediente ingrediente) {
        ingredientes.add(ingrediente);
    }

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public boolean esBebida() {
        return esBebida;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombreCompleto).append("\n");
        sb.append("Precio: $").append(precio).append("\n");
        if (!esBebida) {
            sb.append("Ingredientes:\n");
            for (Ingrediente ingrediente : ingredientes) {
                sb.append(ingrediente).append("\n");
            }
        }
        return sb.toString();
    }
}
