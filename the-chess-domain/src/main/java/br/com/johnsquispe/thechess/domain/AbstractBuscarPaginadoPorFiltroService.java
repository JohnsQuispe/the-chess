package br.com.johnsquispe.thechess.domain;

import br.com.johnsquispe.thechess.domain.queryfilter.QueryPagedQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

public abstract class AbstractBuscarPaginadoPorFiltroService<T extends AbstractDomain> {

    @Autowired
    AbstractBuscarPaginadoPorFiltroDAO<T> abstractBuscarPaginadoPorFiltroDAO;

    public Page<T> buscarPaginadoPorFiltro (QueryPagedQueryBuilder<T> queryPagedQueryBuilder) {
        return abstractBuscarPaginadoPorFiltroDAO.buscarPaginadoPorFiltro(queryPagedQueryBuilder);
    }


}
