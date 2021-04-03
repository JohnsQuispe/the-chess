package br.com.johnsquispe.thechess.api.to;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

public class ListaFieldErrorTO {

    private final List<FieldErrorTO> erros;
    private final int quantidadeErros;

    public ListaFieldErrorTO(List<FieldErrorTO> erros, int quantidadeErros) {
        this.erros = erros;
        this.quantidadeErros = quantidadeErros;
    }

    public List<FieldErrorTO> getErros() {
        return erros;
    }

    public int getQuantidadeErros() {
        return quantidadeErros;
    }

    public static final ListaFieldErrorTO of (BindingResult bindingResult) {

        final List<FieldErrorTO> erros = new ArrayList<>(bindingResult.getFieldErrorCount());

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            erros.add(FieldErrorTO.of(fieldError));
        }

        return new ListaFieldErrorTO(erros, bindingResult.getFieldErrorCount());

    }

}
