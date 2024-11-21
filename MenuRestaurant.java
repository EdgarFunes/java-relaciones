import java.util.ArrayList;
import java.util.Scanner;

public class MenuRestaurant {
    public static void main(String[] args) {
        ArrayList<Plato> platosMenu = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de platos a cargar:");
        int cantidadPlatos = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        for (int i = 0; i < cantidadPlatos; i++) {
            System.out.println("Ingrese el nombre completo del plato:");
            String nombreCompleto = scanner.nextLine();

            System.out.println("Ingrese el precio del plato:");
            double precio = scanner.nextDouble();
            scanner.nextLine(); // Limpiar buffer

            System.out.println("¿Es una bebida? (true/false):");
            boolean esBebida = scanner.nextBoolean();
            scanner.nextLine(); // Limpiar buffer

            Plato plato = new Plato(nombreCompleto, precio, esBebida);

            if (!esBebida) {
                System.out.println("Ingrese la cantidad de ingredientes para el plato (debe ser al menos 1):");
                int cantidadIngredientes = scanner.nextInt();
                while (cantidadIngredientes < 1) {
                    System.out.println("Debe ingresar al menos un ingrediente. Intente nuevamente:");
                    cantidadIngredientes = scanner.nextInt();
                }
                scanner.nextLine(); // Limpiar buffer

                for (int j = 0; j < cantidadIngredientes; j++) {
                    System.out.println("Ingrese el nombre del ingrediente:");
                    String nombreIngrediente = scanner.nextLine();

                    System.out.println("Ingrese la cantidad del ingrediente:");
                    double cantidad = scanner.nextDouble();
                    scanner.nextLine(); // Limpiar buffer

                    System.out.println("Ingrese la unidad de medida del ingrediente:");
                    String unidadDeMedida = scanner.nextLine();

                    Ingrediente ingrediente = new Ingrediente(nombreIngrediente, cantidad, unidadDeMedida);
                    plato.agregarIngrediente(ingrediente);
                }
            }

            platosMenu.add(plato);
        }

        System.out.println("\nMENÚ DEL RESTAURANT:");
        for (Plato plato : platosMenu) {
            System.out.println(plato);
        }

        scanner.close();
    }
}
