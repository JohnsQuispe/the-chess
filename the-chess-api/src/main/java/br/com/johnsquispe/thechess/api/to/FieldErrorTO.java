package br.com.johnsquispe.thechess.api.to;

import org.springframework.validation.FieldError;

public class FieldErrorTO {

    private final String campo;
    private final String mensagem;

    public FieldErrorTO(String campo, String mensagem) {
        this.campo = campo;
        this.mensagem = mensagem;
    }

    public static FieldErrorTO of (FieldError fieldError) {
        return new FieldErrorTO(fieldError.getField(), fieldError.getDefaultMessage());
    }

    public String getCampo() {
        return campo;
    }

    public String getMensagem() {
        return mensagem;
    }

}