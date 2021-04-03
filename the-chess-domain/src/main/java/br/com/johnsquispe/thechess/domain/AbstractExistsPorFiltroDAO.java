package br.com.johnsquispe.thechess.domain;

import br.com.johnsquispe.thechess.domain.queryfilter.QueryExistsBuilder;

public interface AbstractExistsPorFiltroDAO <T extends AbstractDomain> {

    Boolean existsPorFiltro (QueryExistsBuilder<T> existsBuilder);

}
