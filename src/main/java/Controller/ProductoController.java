package Controller;

import Service.ProductoService;
import Modelo.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping("/crear")
    public ResponseEntity<List<Producto>> crearProductos(@RequestBody List<Producto> productos, Model model) {
        List<Producto> productosGuardados = productoService.insertarProductos(productos);
        model.addAttribute("productos", productosGuardados); // Cambiado a "productos"
        return new ResponseEntity<>(productosGuardados, HttpStatus.CREATED);
    }

    @GetMapping("/productos")
    public String verProductos(Model model) {
        List<Producto> productos = productoService.obtenerTodosProductos();
        model.addAttribute("productos", productos); // Cambiado a "productos"
        return "producto";
    }
}
