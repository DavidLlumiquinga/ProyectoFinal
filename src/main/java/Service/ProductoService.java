package Service;

import RepositoryInter.ProductoRepository;
import Modelo.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> insertarProductos(List<Producto> productos) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        List<Future<Producto>> futures = new ArrayList<>();
        for (Producto producto : productos) {
            Callable<Producto> task = () -> {
                Producto savedProducto = productoRepository.save(producto);
                System.out.println("Producto guardado: " + savedProducto.getNombre());
                return savedProducto;
            };
            Future<Producto> future = executorService.submit(task);
            futures.add(future);
        }

        List<Producto> result = new ArrayList<>();
        for (Future<Producto> future : futures) {
            try {
                result.add(future.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();
        return result;
    }

    public List<Producto> obtenerTodosProductos() {
        return productoRepository.findAll();
    }
}
