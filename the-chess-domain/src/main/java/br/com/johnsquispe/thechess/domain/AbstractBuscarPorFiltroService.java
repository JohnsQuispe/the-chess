package br.com.johnsquispe.thechess.domain;

import br.com.johnsquispe.thechess.domain.queryfilter.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractBuscarPorFiltroService <T extends AbstractDomain>{

    @Autowired
    AbstractBuscarPorFiltroDAO<T> abstractBuscarPorFiltroDAO;

    public List<T> buscarTodosPorFiltro (QueryBuilder<T> queryPagedQueryBuilder) {
        return this.abstractBuscarPorFiltroDAO.buscarTodosPorFiltro(queryPagedQueryBuilder);
    }

}
