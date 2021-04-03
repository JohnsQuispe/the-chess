package br.com.johnsquispe.thechess.domain;

import br.com.johnsquispe.thechess.domain.queryfilter.QueryCountBuilder;

public interface AbstractContarPorFiltroDAO <T extends AbstractDomain>{

    Long contarPporFiltro (QueryCountBuilder<T> queryCountBuilder);

}
