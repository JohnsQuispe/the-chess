package br.com.johnsquispe.thechess.domain;

import br.com.johnsquispe.thechess.domain.queryfilter.QueryBuilder;

import java.util.List;

public interface AbstractBuscarPorFiltroDAO <T extends AbstractDomain>{

    List<T> buscarTodosPorFiltro (QueryBuilder<T> queryBuilder);

}
