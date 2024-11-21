import java.util.Scanner;

public class Facturacion {
    private static final String[][] articulos = {
            {"101", "Leche", "25"},
            {"102", "Gaseosa", "30"},
            {"103", "Fideos", "15"},
            {"104", "Arroz", "28"},
            {"105", "Vino", "120"},
            {"106", "Manteca", "20"},
            {"107", "Lavandina", "18"},
            {"108", "Detergente", "46"},
            {"109", "Jabón en Polvo", "96"},
            {"110", "Galletas", "60"}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Factura factura = new Factura();

        // Solicitar datos de la factura
        System.out.println("Ingrese la fecha de la factura:");
        factura.setFechaFactura(scanner.nextLine());

        System.out.println("Ingrese el número de la factura:");
        long numeroFactura = scanner.nextLong();
        while (numeroFactura <= 0) {
            System.out.println("El número de factura debe ser mayor a cero. Intente nuevamente:");
            numeroFactura = scanner.nextLong();
        }
        factura.setNumeroFactura(numeroFactura);

        scanner.nextLine(); // Limpiar buffer
        System.out.println("Ingrese el nombre del cliente:");
        String cliente = scanner.nextLine();
        while (cliente.isEmpty()) {
            System.out.println("El nombre del cliente no puede estar vacío. Intente nuevamente:");
            cliente = scanner.nextLine();
        }
        factura.setCliente(cliente);

        // Cargar detalles de la factura
        boolean continuar = true;
        while (continuar) {
            System.out.println("Ingrese el código del artículo:");
            String codigoArticulo = scanner.nextLine();

            // Buscar artículo
            String[] articuloEncontrado = null;
            for (String[] articulo : articulos) {
                if (articulo[0].equals(codigoArticulo)) {
                    articuloEncontrado = articulo;
                    break;
                }
            }

            if (articuloEncontrado == null) {
                System.out.println("El código ingresado no existe, intente nuevamente.");
                continue;
            }

            System.out.println("Ingrese la cantidad del artículo:");
            int cantidad = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            // Calcular detalle
            double precioUnitario = Double.parseDouble(articuloEncontrado[2]);
            double descuentoItem = (cantidad > 5) ? precioUnitario * 0.1 : 0;
            double subTotal = (precioUnitario - descuentoItem) * cantidad;

            DetalleFactura detalle = new DetalleFactura();
            detalle.setCodigoArticulo(articuloEncontrado[0]);
            detalle.setNombreArticulo(articuloEncontrado[1]);
            detalle.setCantidad(cantidad);
            detalle.setPrecioUnitario(precioUnitario);
            detalle.setDescuentoItem(descuentoItem);
            detalle.setSubTotal(subTotal);

            factura.agregarDetalle(detalle);

            System.out.println("¿Desea continuar agregando artículos? (si/no):");
            String respuesta = scanner.nextLine();
            continuar = respuesta.equalsIgnoreCase("si");
        }

        // Calcular el total de la factura
        factura.calcularMontoTotal();

        // Imprimir factura
        System.out.println("\nFactura");
        System.out.println("Fecha: " + factura.getFechaFactura());
        System.out.println("Número: " + factura.getNumeroFactura());
        System.out.println("Cliente: " + factura.getCliente());
        System.out.println("Detalles:");
        System.out.printf("%-10s %-20s %-10s %-15s %-10s %-10s\n", "Código", "Nombre", "Cantidad", "Precio Unitario", "Descuento", "Subtotal");
        for (DetalleFactura detalle : factura.getDetallesFactura()) {
            System.out.printf("%-10s %-20s %-10d %-15.2f %-10.2f %-10.2f\n",
                    detalle.getCodigoArticulo(),
                    detalle.getNombreArticulo(),
                    detalle.getCantidad(),
                    detalle.getPrecioUnitario(),
                    detalle.getDescuentoItem(),
                    detalle.getSubTotal());
        }
        System.out.println("Total: " + factura.getTotalCalculadoFactura());
    }
}
