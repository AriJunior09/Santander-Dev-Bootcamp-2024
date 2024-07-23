package santander_bootcamp.domain.servico.impl;

import org.springframework.stereotype.Service;
import santander_bootcamp.domain.model.Usuario;
import santander_bootcamp.domain.repository.UsuarioRepositorio;
import santander_bootcamp.domain.servico.UserService;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UsuarioRepositorio usuarioRepositorio;

    public UserServiceImpl(UsuarioRepositorio usuarioRepositorio){
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioRepositorio.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Usuario create(Usuario userToCreate) {
        if(usuarioRepositorio.existsByNumeroConta(userToCreate.getConta().getNumero())){
            throw new IllegalArgumentException("O Número de conta já existe!");
        }
        return usuarioRepositorio.save(userToCreate);
    }
}
