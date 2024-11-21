import java.util.ArrayList;
import java.util.Scanner;

public class CargaNotas {
    public static void main(String[] args) {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de alumnos a cargar:");
        int cantidadAlumnos = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        for (int i = 0; i < cantidadAlumnos; i++) {
            System.out.println("Ingrese el nombre completo del alumno:");
            String nombreCompleto = scanner.nextLine();

            System.out.println("Ingrese el legajo del alumno:");
            long legajo = scanner.nextLong();
            scanner.nextLine(); // Limpiar buffer

            Alumno alumno = new Alumno(nombreCompleto, legajo);

            System.out.println("Ingrese la cantidad de notas para el alumno (debe ser al menos 1):");
            int cantidadNotas = scanner.nextInt();
            while (cantidadNotas < 1) {
                System.out.println("Debe ingresar al menos una nota. Intente nuevamente:");
                cantidadNotas = scanner.nextInt();
            }
            scanner.nextLine(); // Limpiar buffer

            for (int j = 0; j < cantidadNotas; j++) {
                System.out.println("Ingrese el nombre de la cátedra:");
                String catedra = scanner.nextLine();

                System.out.println("Ingrese la nota del examen:");
                double notaExamen = scanner.nextDouble();
                scanner.nextLine(); // Limpiar buffer

                Nota nota = new Nota(catedra, notaExamen);
                alumno.agregarNota(nota);
            }

            alumnos.add(alumno);
        }

        System.out.println("\nInformación de los alumnos cargados:");
        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
            System.out.println("Notas:");
            for (Nota nota : alumno.getNotas()) {
                System.out.println(nota);
            }
            System.out.printf("Promedio de notas: %.2f%n", alumno.calcularPromedio());
            System.out.println();
        }

        scanner.close();
    }
}
