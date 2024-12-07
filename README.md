# Conversor de Monedas - Proyecto de Desafío ONE

## Descripción del Proyecto

Este repositorio contiene la solución al desafío propuesto como parte del programa ONE. El proyecto consiste en el desarrollo de un conversor de monedas completamente funcional, utilizando Java y las mejores prácticas de programación para garantizar un código legible, mantenible y eficiente.

El proyecto incluye las siguientes funcionalidades:
- **Historial de Conversiones:** Rastrea todas las conversiones realizadas durante la sesión.
- **Soporte para Más Monedas:** Permite la conversión entre cualquier par de monedas disponibles en la API.
- **Registros con Marca de Tiempo:** Cada conversión incluye un registro de la fecha y hora en que se realizó.
- **Almacenamiento del Historial:** Guarda todas las conversiones realizadas en un archivo JSON para referencia futura.
- **Interfaz Interactiva:** Un menú fácil de usar que guía a los usuarios en cada paso.

El conversor permite:

- Convertir entre cualquier moneda disponible en la API de tasas de cambio.
- Validar las entradas de los usuarios.
- Mostrar los resultados de manera clara y concisa.

## Estado del Proyecto

<p align="center">
  <img src="https://img.shields.io/badge/STATUS-COMPLETADO-blue">
</p>

---

## Índice

- [Descripción del Proyecto](#descripción-del-proyecto)
- [Estado del Proyecto](#estado-del-proyecto)
- [Características](#características)
- [Tecnologías Utilizadas](#tecnologías-utilizadas)
- [Cómo Usar el Proyecto](#cómo-usar-el-proyecto)

---

## Características

- **Interfaz de Usuario Interactiva:** Menú claro para seleccionar monedas y monto a convertir.
- **Validación de Datos:** Verificación de entradas y manejo de errores comunes.
- **Conversión Universal:** Permite convertir entre cualquier par de monedas admitidas por la API.
- **Historial de Conversiones:** Rastrea las conversiones realizadas durante la sesión.
- **Soporte para Más Monedas:** Lista todas las monedas disponibles en la API para facilitar su uso.
- **Registros con Marca de Tiempo:** Cada conversión incluye la fecha y hora en que fue realizada.
- **Almacenamiento del Historial:** Guarda las conversiones en un archivo JSON para referencia futura.
- **Código Modular y Optimizado:** Implementado con buenas prácticas para facilitar su mantenimiento y ampliación.

---

## Tecnologías Utilizadas

- **Lenguaje de Programación:** Java
- **Librerías Externas:**
  - [Gson](https://github.com/google/gson) para manejar JSON.
  - [HttpClient](https://docs.oracle.com/en/java/javase/11/docs/api/java.net.http/java/net/http/HttpClient.html) para solicitudes HTTP.

---

## Cómo Usar el Proyecto

1. **Clonar el Repositorio:**
   ```bash
   git clone https://github.com/JerePrograma/Conversor-Monedas
2. **Abrir el Proyecto en tu IDE Favorito:** Asegúrate de que tienes configurado Java 17.
3. **Ejecutar el Archivo `Principal.java`:** Sigue las instrucciones en pantalla para realizar conversiones.

### Funcionalidades Disponibles en el Menú:

1. **Convertir Moneda**  
   - Permite seleccionar una moneda de origen y otra de destino, junto con el monto a convertir. El resultado se muestra inmediatamente en la pantalla.

2. **Mostrar Historial**  
   - Presenta un registro detallado de todas las conversiones realizadas durante la sesión, incluyendo la fecha, hora, monto, moneda de origen y moneda de destino.

3. **Listar Monedas Disponibles**  
   - Muestra todas las monedas admitidas por la API, proporcionando un listado completo para facilitar la selección.

4. **Guardar Historial**  
   - Almacena el historial de conversiones en un archivo JSON para referencia futura, permitiendo al usuario revisar sus actividades en otro momento.

5. **Salir**  
   - Finaliza la ejecución del programa de forma segura.