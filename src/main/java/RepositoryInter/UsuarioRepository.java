package RepositoryInter;
import Modelo.Usuario;
import Modelo.Cliente;
import Modelo.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Consulta JPQL para obtener clientes
    @Query("SELECT u FROM Usuario u WHERE TYPE(u) = Cliente")
    List<Cliente> findClientes();

    // Consulta JPQL para obtener administradores
    @Query("SELECT u FROM Usuario u WHERE TYPE(u) = Administrador")
    List<Administrador> findAdministradores();
}
