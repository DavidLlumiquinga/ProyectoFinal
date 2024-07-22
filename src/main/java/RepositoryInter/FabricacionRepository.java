package RepositoryInter;

import Modelo.Fabricacion;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FabricacionRepository extends JpaRepository<Fabricacion, Long> {

}