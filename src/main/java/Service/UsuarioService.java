package Service;

import RepositoryInter.UsuarioRepository;
import Modelo.Administrador;
import Modelo.Cliente;
import Modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> obtenerTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public List<Cliente> obtenerClientes() {
        return usuarioRepository.findClientes();
    }

    public List<Administrador> obtenerAdministradores() {
        return usuarioRepository.findAdministradores();
    }

    public List<Usuario> guardarUsuarios(List<Usuario> usuarios) {
        int numThreads = 10; // Puedes ajustar este valor según sea necesario
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        List<Future<Usuario>> futures = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            Callable<Usuario> task = () -> usuarioRepository.save(usuario);
            Future<Usuario> future = executorService.submit(task);
            futures.add(future);
        }

        List<Usuario> result = new ArrayList<>();
        for (Future<Usuario> future : futures) {
            try {
                result.add(future.get());
            } catch (Exception e) {
                // Manejo de excepciones
                e.printStackTrace();
            }
        }

        executorService.shutdown();
        return result;
    }

}
