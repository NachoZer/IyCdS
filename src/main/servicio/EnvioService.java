package ar.edu.wmstms.servicio;

import ar.edu.wmstms.modelo.Pedido;

/** TMS: gestión del transporte y despacho de pedidos. */
public class EnvioService {

    public void despachar(Pedido pedido) {
        if (pedido.getEstado() != Pedido.Estado.PREPARADO) {
            throw new IllegalStateException("El pedido debe estar PREPARADO para despacharse");
        }
        pedido.setEstado(Pedido.Estado.EN_TRANSITO);
    }

    public void confirmarEntrega(Pedido pedido) {
        if (pedido.getEstado() != Pedido.Estado.EN_TRANSITO) {
            throw new IllegalStateException("El pedido no está en tránsito");
        }
        pedido.setEstado(Pedido.Estado.ENTREGADO);
    }
}
