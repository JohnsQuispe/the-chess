package br.com.johnsquispe.thechess.domain.usuario;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioCadastroService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioCadastroService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario salvar (Usuario usuario) {

        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));

        return this.usuarioRepository.save(usuario);

    }

    public Usuario editar (Usuario usuario) {

        if (usuario.getId() == null) {
            throw new IllegalStateException("Usuário deve estar persistido na base");
        }

        return this.usuarioRepository.save(usuario);
    }


}
