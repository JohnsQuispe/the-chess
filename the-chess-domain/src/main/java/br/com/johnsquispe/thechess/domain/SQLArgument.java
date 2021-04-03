package br.com.johnsquispe.thechess.domain;

import java.util.Map;

public class SQLArgument {

    private final String SQL;

    private final Map<String, Object> params;

    public SQLArgument(String SQL, Map<String, Object> params) {
        this.SQL = SQL;
        this.params = params;
    }

    public String getSQL() {
        return SQL;
    }

    public Map<String, Object> getParams() {
        return params;
    }

}
