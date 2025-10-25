# Flashcard CRUD (Aplicación de consola de Java)

Esta aplicación de consola desarrollada en la versión de **Java 17** permite gestionar **tarjetas de estudio (Flashcard)** y **tarjetas de pregunta tipo multiplechoice (Triviacard)**.
El objetivo del proyecto fue para practicar la **Programación Orientada a Objetos**.

---

## Funcionalidades principales

- Crear, listar, modificar y eliminar tarjetas **Flashcard** y **Triviacard**
- Cada tarjeta pertenece a una **categoría**
- Cada **Flashcard** tiene su **nivel** de dificultad a travez de `enum`
- Cada **Triviacard** tiene su pregunta y 3 posibles respuestas, solo una correcta
- Limpieza y control de consola con `ConsolaUtils`
- Cada tarjeta tiene la fecha y hora de cuando fue creada con `LocalDateTime`
- Uso de **conceptos POO**:
  - **Herencia:** clase padre `Card`, extendida por `Flashcard` y `Triviacard`
  - **Abstracción:** clase abstracta `Card`
  - **Encapsulamiento:** atributos privados con getters y setters
  - **Polimorfismo:** `toString()` y métodos sobrescritos en las subclases

---

## Ejecución

### Desde VS Code
- Abrir el proyecto en Visual Studio Code.  
- Compilar con el botón **Run**

---

## Ejemplos
---
### Ejemplo de **Flashcard**
---
<pre>
Flashcard {
  id: 1,
  categoría: Ciencia,
  pregunta: ¿Qué planeta es el más grande del sistema solar?
  respuesta: Júpiter
  nivel: MEDIO
  fecha de creación: 22/10/2025 10:15
}
</pre>
### Ejemplo de **Triviacard**
---
<pre>
Triviacard {
  id: 2,
  categoría: Historia,
  pregunta: ¿En qué año llegó el hombre a la Luna?
  opciones: [1969, 1970, 1959]
  índice correcto: 0
  fecha de creación: 22/10/2025 10:15
}
</pre>
---
