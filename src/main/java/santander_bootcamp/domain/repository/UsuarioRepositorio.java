package santander_bootcamp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import santander_bootcamp.domain.model.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{
}
