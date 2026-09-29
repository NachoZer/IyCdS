package main.modelo;

import java.util.HashMap;
import java.util.Map;

public class Producto {
    private final String sku;
    private final String nombre;
    private int stock;
    private static final Map<String, String> SKU_A_NOMBRE = new HashMap<>(
            Map.of(
                    "SKU-001", "Auriculares Bluetooth",
                    "SKU-002", "Parlante Bluetooth",
                    "SKU-003", "Lavaropas",
                    "SKU-004", "Heladera",
                    "SKU-005", "Tostadora"
            )
    );

    public Producto(String sku, int stock) {
        this.sku = sku;
        this.nombre = SKU_A_NOMBRE.get(sku);
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
