import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        List<String> historial = new ArrayList<>();

        try (Scanner scanner = new Scanner(System.in)) {
            ConversorMoneda conversor = new ConversorMoneda();
            // Obtener todas las tasas de conversión desde una moneda base (USD)
            System.out.println("Cargando tasas de conversión...");
            Moneda monedaBase = conversor.buscarMoneda("USD");
            System.out.println("Tasas de conversión cargadas exitosamente.\n");

            int opcion;
            do {
                // Mostrar el menú principal
                System.out.println("===== Conversor de Monedas =====");
                System.out.println("1) Convertir moneda");
                System.out.println("2) Mostrar monedas disponibles");
                System.out.println("3) Mostrar historial");
                System.out.println("4) Guardar historial en un archivo");
                System.out.println("5) Salir");
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
                            String registro = String.format("(%s) %.2f %s => %.2f %s",
                                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy")),
                                    monto, monedaOrigen, resultado, monedaDestino);
                            historial.add(registro);
                            System.out.println(registro);
                        } catch (RuntimeException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 2: // Mostrar monedas disponibles
                        System.out.println("Monedas disponibles:");
                        conversor.obtenerMonedasDisponibles(monedaBase).forEach(System.out::println);
                        break;

                    case 3: // Mostrar historial
                        if (historial.isEmpty()) {
                            System.out.println("No hay conversiones registradas.");
                        } else {
                            System.out.println("Historial de conversiones:");
                            historial.forEach(System.out::println);
                        }
                        break;

                    case 4: // Guardar historial en un archivo
                        try {
                            GeneradorDeArchivo generador = new GeneradorDeArchivo();
                            generador.guardarHistorial(historial);
                            System.out.println("Historial guardado exitosamente en historial_conversiones.json");
                        } catch (IOException e) {
                            System.out.println("Error al guardar el historial: " + e.getMessage());
                        }
                        break;

                    case 5:
                        System.out.println("Gracias por utilizar el conversor de monedas.");
                        break;


                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            } while (opcion != 5);

        } catch (RuntimeException e) {
            System.out.println("Error al cargar las tasas de conversión: " + e.getMessage());
        }
    }
}
