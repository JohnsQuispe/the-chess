package br.com.johnsquispe.thechess.api.login;

import javax.validation.constraints.NotBlank;

public class LoginInput {

    @NotBlank(message = "nickname não pode estar vazio")
    private String nickname;

    @NotBlank(message = "senha não pode estar vazio")
    private String senha;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
