package br.com.johnsquispe.thechess.domain.usuario;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UsuarioSenhaService {

    private final UsuarioCadastroService usuarioCadastroService;

    public void criarNovoTokenResetSenha (Usuario usuario) {
        usuario.criarNovoTokenResetSEnha(UUID.randomUUID());
        this.usuarioCadastroService.editar(usuario);
    }

}
