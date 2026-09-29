package main;

import main.modelo.*;
import main.servicio.*;

public class Main {
    public static void main(String[] args) {
        InventarioService wms = new InventarioService();
        EnvioService tms = new EnvioService();

        wms.registrarProducto(new Producto("SKU-001", 50));

        Pedido pedido = new Pedido("PED-1001", "Av. Siempre Viva 742");
        pedido.agregarItem("SKU-001", 2);

        wms.prepararPedido(pedido);
        tms.despachar(pedido);
        tms.confirmarEntrega(pedido);

        System.out.println("Pedido " + pedido.getId() + " -> " + pedido.getEstado());
        System.out.println(wms.buscar("SKU-001"));
        System.out.println("Stock disponible SKU-001: " + wms.obtenerStock("SKU-001"));
    }
}
