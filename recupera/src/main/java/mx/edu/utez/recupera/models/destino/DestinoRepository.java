package mx.edu.utez.recupera.models.destino;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinoRepository extends JpaRepository <Destino, Long> {
    boolean existsByNameAndUsuarioId(String name, Long usuarioId);


}
