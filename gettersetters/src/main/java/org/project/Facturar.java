package org.project;

public class Facturar {
    
    private double cantidad;
    private double precio;
    private final double PORCENTAJE_IVA = 0.13;
    private final double DESCUENTO_POR_MAYOR = 0.05; 
    private final int UMBRAL_DESCUENTO = 10;        

    public Facturar(){
        this.cantidad = 0;
        this.precio = 0;
    }

    public Facturar(double cantidad, double precio) {
        this.cantidad = cantidad;
        this.precio = precio; 
    }

    // --- Setters ---
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidad(double cantidad){
        this.cantidad = cantidad;
    }

    // --- Getters ---
    public double getPrecio(){
        return this.precio;
    }

    public double getCantidad(){
        return this.cantidad;
    }

    // --- Nuevas Funciones ---
    public double aplicarDescuento() {
        if (this.cantidad >= UMBRAL_DESCUENTO) {
            double subtotal = this.cantidad * this.precio;
            return subtotal * DESCUENTO_POR_MAYOR;
        }
        return 0;
    }
    public double calcularVenta(){
        double subtotal = this.cantidad * this.precio;
        double descuento = aplicarDescuento();
        double subtotalConDescuento = subtotal - descuento;
        double iva = subtotalConDescuento * PORCENTAJE_IVA;
        double total = subtotalConDescuento + iva;

        return total;
    }
    
    public String obtenerDetalleFactura() {
        double subtotal = this.cantidad * this.precio;
        double descuento = aplicarDescuento();
        double subtotalConDescuento = subtotal - descuento;
        double iva = subtotalConDescuento * PORCENTAJE_IVA;
        double total = subtotalConDescuento + iva;
        
        java.text.DecimalFormat df = new java.text.DecimalFormat("#.##");

        return "\n---DETALLE DE FACTURA CREATIVA---\n" +
               String.format("Precio Unitario: \t\t%.2f\n", this.precio) +
               String.format("Cantidad Comprada: \t\t%.0f\n", this.cantidad) +
               "-----------------------------------------\n" +
               String.format("Subtotal (sin IVA/Desc.): \t%.2f\n", subtotal) +
               (descuento > 0 ? String.format("🎉 Descuento por Volumen: \t-%.2f\n", descuento) : "Sin Descuento Aplicado.\n") +
               String.format("Subtotal Neto: \t\t\t%.2f\n", subtotalConDescuento) +
               String.format("IVA (%s): \t\t\t+%.2f\n", df.format(PORCENTAJE_IVA * 100) + "%", iva) +
               "=========================================\n" +
               String.format("💰 TOTAL A PAGAR: \t\t%.2f\n", total) +
               "=========================================\n";
    }
}


