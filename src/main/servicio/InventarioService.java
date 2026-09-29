package ar.edu.wmstms.servicio;

import ar.edu.wmstms.modelo.Pedido;
import ar.edu.wmstms.modelo.Producto;

import java.util.HashMap;
import java.util.Map;

/** WMS: gestión de stock y preparación de pedidos en el almacén. */
public class InventarioService {
    private final Map<String, Producto> productos = new HashMap<>();

    public void registrarProducto(Producto p) {
        productos.put(p.getSku(), p);
    }

    public Producto buscar(String sku) {
        return productos.get(sku);
    }

    public boolean hayStock(String sku, int cantidad) {
        Producto p = productos.get(sku);
        return p != null && p.getStock() >= cantidad;
    }

    // Devuelve el stock disponible del producto o 0 si no existe.
    public int obtenerStock(String sku) {
        Producto p = productos.get(sku);
        return p != null ? p.getStock() : 0;
    }

    // Consulta la cantidad de stock disponible según su SKU.
    public int consultarStock(String sku) {
        return obtenerStock(sku);
    }

    /** Descuenta stock y marca el pedido como PREPARADO. */
    public void prepararPedido(Pedido pedido) {
        for (Map.Entry<String, Integer> item : pedido.getItems().entrySet()) {
            if (!hayStock(item.getKey(), item.getValue())) {
                throw new IllegalStateException("Stock insuficiente para SKU " + item.getKey());
            }
        }
        pedido.getItems().forEach((sku, cant) -> {
            Producto p = productos.get(sku);
            p.setStock(p.getStock() - cant);
        });
        pedido.setEstado(Pedido.Estado.PREPARADO);
    }
}
