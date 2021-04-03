package br.com.johnsquispe.thechess.domain.queryfilter;

import br.com.johnsquispe.thechess.domain.AbstractDomain;
import br.com.johnsquispe.thechess.domain.SQLArgument;

public interface QueryCountBuilder<T extends AbstractDomain> {

    SQLArgument buildCountQuery ();

}
