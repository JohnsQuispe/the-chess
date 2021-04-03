package br.com.johnsquispe.thechess.api.security;

import br.com.johnsquispe.thechess.domain.usuario.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UsuarioAuth implements UserDetails {

    private final Long id;
    private final String nickname;
    private final String senha;
    private final Usuario.TipoConta tipoConta;

    public UsuarioAuth(Long id, String nickname, String senha, Usuario.TipoConta tipoConta) {
        this.id = id;
        this.nickname = nickname;
        this.senha = senha;
        this.tipoConta = tipoConta;
    }

    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getSenha() {
        return senha;
    }

    public Usuario.TipoConta getTipoConta() {
        return tipoConta;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.nickname;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
