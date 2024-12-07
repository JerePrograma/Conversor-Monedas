import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ConversorMoneda {
    private final HttpClient client;
    private final Gson gson;

    public ConversorMoneda() {
        this.client = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public Moneda buscarMoneda(String monedaBase) {
        String url = "https://v6.exchangerate-api.com/v6/f97113d3bf68c6039b5329ba/latest/" + monedaBase;
        URI direccion = URI.create(url);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Validar respuesta HTTP
            if (response.statusCode() != 200) {
                throw new RuntimeException("Error en la solicitud HTTP: Código " + response.statusCode());
            }

            // Deserializar JSON
            Moneda moneda = gson.fromJson(response.body(), Moneda.class);

            if (moneda == null || moneda.conversion_rates() == null) {
                throw new RuntimeException("Error al procesar los datos de la moneda.");
            }

            return moneda;
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar la moneda: " + e.getMessage(), e);
        }
    }

    public float convertirMoneda(Moneda monedaBase, String monedaDestino, String monedaOrigen, float monto) {
        // Validar si ambas monedas están disponibles
        Map<String, Float> tasas = monedaBase.conversion_rates();
        if (!tasas.containsKey(monedaDestino)) {
            throw new RuntimeException("La moneda destino " + monedaDestino + " no está disponible.");
        }
        if (!tasas.containsKey(monedaOrigen)) {
            throw new RuntimeException("La moneda origen " + monedaOrigen + " no está disponible.");
        }

        // Obtener la tasa de conversión indirecta usando la moneda base
        float tasaOrigen = tasas.get(monedaOrigen);
        float tasaDestino = tasas.get(monedaDestino);

        // Calcular el monto convertido
        return ((monto / tasaOrigen) * tasaDestino);
    }
}
