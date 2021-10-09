package br.com.johnsquispe.thechess.api.usuario;

import br.com.johnsquispe.thechess.domain.usuario.Usuario;

import java.time.LocalDateTime;

public class UsuarioOutput {

    private final String nickname;
    private final String email;
    private final LocalDateTime dataCriacao;

    public UsuarioOutput(String nickname, String email, LocalDateTime dataCriacao) {
        this.nickname = nickname;
        this.email = email;
        this.dataCriacao = dataCriacao;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public static UsuarioOutput of (Usuario usuario) {
        return new UsuarioOutput(usuario.getNickname(), usuario.getEmail(), usuario.getDataCriacao());
    }

}
