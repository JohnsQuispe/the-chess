package br.com.johnsquispe.thechess.domain;

import br.com.johnsquispe.thechess.domain.queryfilter.QueryPagedQueryBuilder;
import org.springframework.data.domain.Page;

interface AbstractBuscarPaginadoPorFiltroDAO <T extends AbstractDomain>{

    Page<T> buscarPaginadoPorFiltro (QueryPagedQueryBuilder<T> queryBuilder);

}
