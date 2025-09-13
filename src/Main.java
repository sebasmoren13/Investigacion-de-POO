//Sebastian Andres Prieto Moreno

import java.util.*;

// Clase principal con el método main
public class Main {
    public static void main(String[] args) {
        // Objeto de récord Persona
        Persona persona = new Persona("Sebastian", 18);
        persona.mostrarInfo();

        // Objeto de clase Coche (herencia, abstracción, polimorfismo, encapsulación)
        Coche coche = new Coche("Toyota", 200);
        coche.mostrarInfo();
        coche.encenderMotor();
        coche.mover();


        // Objeto creado con Builder
        VehiculoBuilder builder = new VehiculoBuilder()
                .setMarca("Honda")
                .setVelocidadMaxima(180)
                .setTipo("Coche Deportivo");
        Vehiculo cocheDeportivo = builder.build();
        cocheDeportivo.mostrarInfo();
    }
}

// 1. RÉCORDS: Estructura inmutable para datos simples, con métodos automáticos (getters, equals, hashCode, toString).
record Persona(String nombre, int edad) {
    // Método personalizado para mostrar información
    public void mostrarInfo() {
        System.out.println("Persona: " + nombre + ", Edad: " + edad);
    }
}

// 2. CLASES: Plantilla que define atributos y métodos para crear objetos.
class Vehiculo {
    // 3. ENCAPSULACIÓN: Control de acceso a datos mediante modificadores.
    private String marca; // Privado: solo accesible dentro de la clase.
    protected int velocidadMaxima; // Protegido: accesible en la clase y subclases.
    public String tipo; // Público: accesible desde cualquier lugar.

    // Constructor
    public Vehiculo(String marca, int velocidadMaxima, String tipo) {
        this.marca = marca;
        this.velocidadMaxima = velocidadMaxima;
        this.tipo = tipo;
    }

    // Métodos getter/setter para encapsulación del atributo privado
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    // Método para mostrar información
    public void mostrarInfo() {
        System.out.println("Vehículo: " + tipo + ", Marca: " + marca + ", Velocidad Máxima: " + velocidadMaxima + " km/h");
    }
}

// 4. ABSTRACCIÓN: Clase abstracta que define comportamiento genérico sin implementación completa.
abstract class VehiculoMotorizado {
    abstract void encenderMotor(); // Método abstracto: debe implementarse en subclases.

    public void detener() { // Método concreto
        System.out.println("Vehículo detenido.");
    }
}

// 5. HERENCIA: Una clase hereda atributos y métodos de otra.
class Coche extends Vehiculo implements Movible {
    public Coche(String marca, int velocidadMaxima) {
        super(marca, velocidadMaxima, "Coche");
    }

    // Implementación de método abstracto (abstracción)
    void encenderMotor() {
        System.out.println("Motor del coche encendido.");
    }

    // 6. POLIMORFISMO: Implementación específica del método de la interfaz Movible.
    public void mover() {
        System.out.println("El coche se mueve a " + velocidadMaxima + " km/h.");
    }
}

// Interfaz para polimorfismo
interface Movible {
    void mover();
}

// 7. BUILDER: Patrón de diseño para construir objetos complejos paso a paso.
class VehiculoBuilder {
    private String marca;
    private int velocidadMaxima;
    private String tipo;

    // Métodos encadenables para establecer valores
    public VehiculoBuilder setMarca(String marca) {
        this.marca = marca;
        return this;
    }

    public VehiculoBuilder setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
        return this;
    }

    public VehiculoBuilder setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    // Construye el objeto final
    public Vehiculo build() {
        return new Vehiculo(marca, velocidadMaxima, tipo);
    }
}
