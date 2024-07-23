package santander_bootcamp.domain.servico;

import santander_bootcamp.domain.model.Usuario;

public interface UserService {
    Usuario findById(Long id);

    Usuario create(Usuario userToCreate);

}
