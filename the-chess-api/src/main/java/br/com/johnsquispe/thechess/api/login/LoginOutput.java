package br.com.johnsquispe.thechess.api.login;

public class LoginOutput {

    private final String token;

    public LoginOutput(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

}
