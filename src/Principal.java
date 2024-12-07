import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            ConversorMoneda conversor = new ConversorMoneda();
            // Obtener todas las tasas de conversión desde una moneda base (por ejemplo, USD)
            System.out.println("Cargando tasas de conversión...");
            Moneda monedaBase = conversor.buscarMoneda("USD");
            System.out.println("Tasas de conversión cargadas exitosamente.\n");

            int opcion;
            do {
                // Mostrar el menú principal
                System.out.println("===== Conversor de Monedas =====");
                System.out.println("1) Convertir moneda");
                System.out.println("2) Salir");
                System.out.print("Seleccione una opción: ");

                while (!scanner.hasNextInt()) {
                    System.out.println("Por favor, ingrese un número válido.");
                    scanner.next(); // Limpiar entrada inválida
                }
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        // Solicitar monedas y monto al usuario
                        System.out.print("Ingrese la moneda de origen (ejemplo: USD): ");
                        String monedaOrigen = scanner.next().toUpperCase();

                        System.out.print("Ingrese la moneda de destino (ejemplo: ARS): ");
                        String monedaDestino = scanner.next().toUpperCase();

                        System.out.print("Ingrese el monto a convertir: ");
                        while (!scanner.hasNextFloat()) {
                            System.out.println("Por favor, ingrese un valor numérico válido.");
                            scanner.next(); // Limpiar entrada inválida
                        }
                        float monto = scanner.nextFloat();

                        // Intentar realizar la conversión
                        try {
                            float resultado = conversor.convertirMoneda(monedaBase, monedaDestino, monedaOrigen, monto);
                            System.out.printf("%.2f %s equivale a %.2f %s%n", monto, monedaOrigen, resultado, monedaDestino);
                        } catch (RuntimeException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 2:
                        System.out.println("Gracias por utilizar el conversor de monedas.");
                        break;

                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            } while (opcion != 2);

        } catch (RuntimeException e) {
            System.out.println("Error al cargar las tasas de conversión: " + e.getMessage());
        }
    }
}
