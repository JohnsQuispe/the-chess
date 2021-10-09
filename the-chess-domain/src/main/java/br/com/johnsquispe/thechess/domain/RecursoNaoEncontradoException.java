package br.com.johnsquispe.thechess.domain;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecursoNaoEncontradoException extends Exception {

    public RecursoNaoEncontradoException() {
    }

    public RecursoNaoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }

}
