package ar.edu.wmstms.servicio;

import ar.edu.wmstms.modelo.Pedido;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnvioServiceTest {

    @Test
    void flujoCompletoDeEnvio() {
        EnvioService tms = new EnvioService();
        Pedido pedido = new Pedido("P1", "Calle Falsa 123");
        pedido.setEstado(Pedido.Estado.PREPARADO);

        tms.despachar(pedido);
        assertEquals(Pedido.Estado.EN_TRANSITO, pedido.getEstado());

        tms.confirmarEntrega(pedido);
        assertEquals(Pedido.Estado.ENTREGADO, pedido.getEstado());
    }

    @Test
    void noSePuedeDespacharUnPedidoNoPreparado() {
        EnvioService tms = new EnvioService();
        Pedido pedido = new Pedido("P2", "Calle Falsa 123");

        assertThrows(IllegalStateException.class, () -> tms.despachar(pedido));
    }
}
