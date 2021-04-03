package br.com.johnsquispe.thechess.infraestructure;

import br.com.johnsquispe.thechess.domain.AbstractBuscarPorFiltroDAO;
import br.com.johnsquispe.thechess.domain.AbstractDomain;
import br.com.johnsquispe.thechess.domain.SQLArgument;
import br.com.johnsquispe.thechess.domain.queryfilter.QueryBuilder;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class AbstractBuscarPorFiltroDAOImpl<T extends AbstractDomain> implements AbstractBuscarPorFiltroDAO<T> {

    private final AbstractRowMapper<T> abstractRowMapper;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public AbstractBuscarPorFiltroDAOImpl(AbstractRowMapper<T> abstractRowMapper, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.abstractRowMapper = abstractRowMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<T> buscarTodosPorFiltro (QueryBuilder<T> queryBuilder) {

        SQLArgument sqlArgument = queryBuilder.buildQuery();

        return this.namedParameterJdbcTemplate.query(sqlArgument.getSQL(), sqlArgument.getParams(), abstractRowMapper);
    }

}
