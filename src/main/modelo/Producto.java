package main.modelo;

public class Producto {
    private final String sku;
    private final String nombre;
    private int stock;

    public Producto(String sku, String nombre, int stock) {
        this.sku = sku;
        this.nombre = nombre;
        this.stock = stock;
    }

    public String getSku() { return sku; }
    public String getNombre() { return nombre; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    @Override
    public String toString() {
        return sku + " - " + nombre + " (stock: " + stock + ")";
    }
}
