package br.com.johnsquispe.thechess.api.usuario;

import br.com.johnsquispe.thechess.domain.usuario.Usuario;

import javax.validation.constraints.NotBlank;

public class UsuarioInput {

    @NotBlank(message = "nickname não pode estar em branco")
    private String nickname;

    @NotBlank(message = "email não pode estar em branco")
    private String email;

    //TODO - ADICIONAR VALIDAÇÃO DE COMPLEXIDADE DE SENHA
    @NotBlank(message = "senha não pode estar vazia")
    private String senha;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario toUsuario () {

        return new Usuario(this.nickname, this.email, this.senha, Usuario.TipoConta.COMUM);

    }

}
