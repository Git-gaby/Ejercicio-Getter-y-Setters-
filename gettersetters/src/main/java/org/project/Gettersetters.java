package org.project;

import java.util.Scanner;

public class Gettersetters {

    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("--- 🛒 SIMULADOR DE FACTURACIÓN 🛒 ---\n");
        
        // 1. Solicitud de Datos
        System.out.print("Introduzca la cantidad de artículos (ej. 15): ");
        double cant = entrada.nextDouble();

        System.out.print("Introduzca el precio unitario (ej. 45000): ");
        double price = entrada.nextDouble();
        
        // 2. Creación del Objeto
        Facturar miFactura = new Facturar (cant, price);
        
        // --- Uso de los Setters (Opcional, para demostrar su uso) ---
        // Si quisiéramos cambiar el precio después de crearlo:
        // miFactura.setPrecio(50.0); 
        // 4. Salida Creativa
        System.out.println("\n Datos de Entrada Registrados.");
        System.out.println("Cantidad de Artículos: " + miFactura.getCantidad()); // Uso del Getter
        System.out.println("Precio Unitario: " + miFactura.getPrecio());       // Uso del Getter
        
        // Imprime el detalle completo de la factura
        System.out.println(miFactura.obtenerDetalleFactura());

        // El total final se muestra como double, no como int, para ser más preciso.
        System.out.println("¡Gracias por su compra! Vuelva pronto.");
        
        entrada.close();
    }
}

