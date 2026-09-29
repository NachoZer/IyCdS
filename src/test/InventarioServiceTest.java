package ar.edu.wmstms.servicio;

import ar.edu.wmstms.modelo.Pedido;
import ar.edu.wmstms.modelo.Producto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventarioServiceTest {

    @Test
    void prepararPedidoDescuentaStock() {
        InventarioService wms = new InventarioService();
        wms.registrarProducto(new Producto("SKU-001", "Mouse", 10));
        Pedido pedido = new Pedido("P1", "Calle Falsa 123");
        pedido.agregarItem("SKU-001", 3);

        wms.prepararPedido(pedido);

        assertEquals(7, wms.buscar("SKU-001").getStock());
        assertEquals(Pedido.Estado.PREPARADO, pedido.getEstado());
    }

    @Test
    void prepararPedidoSinStockLanzaExcepcion() {
        InventarioService wms = new InventarioService();
        wms.registrarProducto(new Producto("SKU-001", "Mouse", 1));
        Pedido pedido = new Pedido("P2", "Calle Falsa 123");
        pedido.agregarItem("SKU-001", 5);

        assertThrows(IllegalStateException.class, () -> wms.prepararPedido(pedido));
    }

    @Test
    void obtenerStockRetornaCantidadCorrecta() {
        InventarioService wms = new InventarioService();
        wms.registrarProducto(new Producto("SKU-001", "Teclado", 15));

        assertEquals(15, wms.obtenerStock("SKU-001"));
        assertEquals(15, wms.consultarStock("SKU-001"));
    }

    @Test
    void obtenerStockProductoInexistenteRetornaCero() {
        InventarioService wms = new InventarioService();

        assertEquals(0, wms.obtenerStock("SKU-NO-EXISTE"));
    }
}
