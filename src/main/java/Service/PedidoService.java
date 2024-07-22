package Service;

import RepositoryInter.PedidoRepository;
import Modelo.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido crearPedido(Pedido pedido) {
        pedido.setFechaPedido(LocalDateTime.now());
        // Validaciones u lógica de negocio antes de guardar
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> obtenerTodosPedidos() {
        return pedidoRepository.findAll();
    }

    // Otros métodos según la lógica de negocio requerida
}