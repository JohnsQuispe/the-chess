package br.com.johnsquispe.thechess.infraestructure.usuario;

import br.com.johnsquispe.thechess.domain.SQLArgument;
import br.com.johnsquispe.thechess.domain.queryfilter.QueryBuilder;
import br.com.johnsquispe.thechess.domain.usuario.Usuario;

import java.util.Collections;

public class UsuarioQueryBuilder implements QueryBuilder<Usuario> {

    @Override
    public SQLArgument buildQuery() {

        return new SQLArgument(UsuarioSQL.SELECT_USUARIO, Collections.emptyMap());

    }
}
