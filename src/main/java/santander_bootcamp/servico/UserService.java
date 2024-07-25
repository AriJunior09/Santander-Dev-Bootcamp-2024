package santander_bootcamp.servico;

import santander_bootcamp.model.Usuario;

public interface UserService {
    Usuario findById(Long id);

    Usuario create(Usuario userToCreate);

}
