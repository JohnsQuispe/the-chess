package br.com.johnsquispe.thechess.api.security;

import br.com.johnsquispe.thechess.domain.usuario.Usuario;
import br.com.johnsquispe.thechess.domain.usuario.UsuarioBuscaService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioDetailsService implements UserDetailsService {

    private final UsuarioBuscaService usuarioBuscaService;

    public UsuarioDetailsService(UsuarioBuscaService usuarioBuscaService) {
        this.usuarioBuscaService = usuarioBuscaService;
    }

    @Override
    public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {

        Optional<Usuario> usuarioOptional = usuarioBuscaService.buscarPorNickname(nickname);

        if (usuarioOptional.isEmpty()) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }

        Usuario usuario = usuarioOptional.get();

        return new UsuarioAuth(usuario.getId(), usuario.getNickname(), usuario.getSenha(), usuario.getTipoConta());

    }
}
