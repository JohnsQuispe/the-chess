package br.com.johnsquispe.thechess.infraestructure.usuario;

import br.com.johnsquispe.thechess.domain.usuario.Usuario;
import br.com.johnsquispe.thechess.infraestructure.AbstractRowMapper;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

@Component
public class UsuarioRowMapper extends AbstractRowMapper<Usuario> {

    @Override
    public Usuario mapRow(ResultSet rs, int i) throws SQLException {

        final Map<String, BeanMap> beanMapMap = Map.of(Usuario.Table.NAME, BeanMap.create(new Usuario()));

        super.mapBeans(beanMapMap, rs);

        return (Usuario) beanMapMap.get(Usuario.Table.NAME).getBean();
    }

}
