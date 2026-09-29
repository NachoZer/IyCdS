package ar.edu.wmstms;

import ar.edu.wmstms.modelo.Pedido;
import ar.edu.wmstms.modelo.Producto;
import ar.edu.wmstms.servicio.EnvioService;
import ar.edu.wmstms.servicio.InventarioService;

public class Main {
    public static void main(String[] args) {
        InventarioService wms = new InventarioService();
        EnvioService tms = new EnvioService();

        wms.registrarProducto(new Producto("SKU-001", "Auriculares Bluetooth", 50));

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
