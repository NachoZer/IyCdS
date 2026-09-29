package ar.edu.wmstms.modelo;

import java.util.HashMap;
import java.util.Map;

public class Pedido {
    public enum Estado { CREADO, PREPARADO, EN_TRANSITO, ENTREGADO }

    private final String id;
    private final String direccionEntrega;
    private final Map<String, Integer> items = new HashMap<>(); // sku -> cantidad
    private Estado estado = Estado.CREADO;

    public Pedido(String id, String direccionEntrega) {
        this.id = id;
        this.direccionEntrega = direccionEntrega;
    }

    public void agregarItem(String sku, int cantidad) {
        items.merge(sku, cantidad, Integer::sum);
    }

    public String getId() { return id; }
    public String getDireccionEntrega() { return direccionEntrega; }
    public Map<String, Integer> getItems() { return items; }
    public Estado getEstado() { return estado; }
    public void setEstado(Estado estado) { this.estado = estado; }
}
