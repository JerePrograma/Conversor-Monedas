# Conversor de Monedas - Proyecto de Desafío ONE

## Descripción del Proyecto

Este repositorio contiene la solución al desafío propuesto como parte del programa ONE. El proyecto consiste en el desarrollo de un conversor de monedas completamente funcional, utilizando Java y las mejores prácticas de programación para garantizar un código legible, mantenible y eficiente.

Si bien originalmente se solicitaba la conversión de USD a ARS, COP, y BRL y viceversa (ARS a USD, COP a USD, y BRL a USD), decidí dar un paso más haciendo uso de la posibilidad de manejo de excepciones brindadas en el curso, así como la flexibilidad de cambiar el URI dinámicamente con un String. Esto me permitió implementar un sistema que soporta la conversión entre cualquier moneda admitida por la API, lo que hace que la solución sea más completa y robusta.

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
- [Contribuyentes](#contribuyentes)
- [Licencia](#licencia)

---

## Características

- **Interfaz de Usuario Interactiva:** Menú claro para seleccionar monedas y monto a convertir.
- **Validación de Datos:** Verificación de entradas y manejo de errores comunes.
- **Conversión Universal:** Permite convertir entre cualquier par de monedas admitidas por la API.
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