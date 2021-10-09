package br.com.johnsquispe.thechess.domain.usuario;

import br.com.johnsquispe.thechess.domain.AbstractBuscarPorFiltroService;
import br.com.johnsquispe.thechess.domain.RecursoNaoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioBuscaService extends AbstractBuscarPorFiltroService<Usuario> {

    private final UsuarioRepository usuarioRepository;

    public UsuarioBuscaService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Optional<Usuario> buscarPorNickname (String nickname) {
        return usuarioRepository.findByNickname(nickname);
    }

    public Usuario buscarPorUuid (UUID usuarioUuid) throws RecursoNaoEncontradoException {
        return this.usuarioRepository.findByUuid(usuarioUuid).orElseThrow(RecursoNaoEncontradoException::new);
    }

}
