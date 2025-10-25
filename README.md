# Flashcard CRUD (Aplicación de consola de Java)

Esta aplicacion de consola desarrollada en la version de **Java 17** permite gestionar **tarjetas de estudio (Flashcard)** y **tarjetas de pregunta tipo multiplechoice (Triviacard)**.
El objetivo del proyecto fue para practicar la **Programación Orientada a Objetos**.

---

## Funcionalidades principales

- Crear, listar, modificar y eliminar tarjetas Flashcard y Triviacard
- Cada tarjeta pertenece a una **categoría**
- Cada carta tiene su **nivel** de dificultad a travez de `enum`
- Limpieza y control de consola con `ConsolaUtils`
- Uso de **conceptos POO**:
  - **Herencia:** clase padre `Card`, extendida por `Flashcard` y `Triviacard`
  - **Abstracción:** clase abstracta `Card`
  - **Encapsulamiento:** atributos privados con getters y setters
  - **Polimorfismo:** `toString()` y métodos sobrescritos en las subclases

---
