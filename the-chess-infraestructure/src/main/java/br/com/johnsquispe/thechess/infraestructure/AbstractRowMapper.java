package br.com.johnsquispe.thechess.infraestructure;

import br.com.johnsquispe.thechess.domain.AbstractDomain;
import br.com.johnsquispe.thechess.domain.logger.ApplicationLogger;
import com.google.common.base.CaseFormat;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Map;

public abstract class AbstractRowMapper<T extends AbstractDomain> implements RowMapper<T> {

    public void mapBeans(Map<String, BeanMap> beansNameByBeanMapMap, ResultSet rs) throws SQLException {

        ResultSetMetaData resultSetMetaData = rs.getMetaData();

        for (int rowCount = 1; rowCount <= resultSetMetaData.getColumnCount(); rowCount++) {

            String columnName = resultSetMetaData.getColumnName(rowCount);

            String tableName = columnName.split("\\.")[0];
            String fieldName = columnName.split("\\.")[1];

            BeanMap beanMap = beansNameByBeanMapMap.get(tableName);

            if (rs.getObject(rowCount) != null) {

                String attributeName = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, fieldName);

                if (beanMap.getPropertyType(attributeName).isEnum()) {

                    String className = beanMap.getPropertyType(attributeName).getName();

                    try {

                        Class<? extends Enum> clazz = (Class<? extends Enum>) Class.forName(className);

                        Enum<? extends Enum> eEnum = EnumUtils.getEnum(clazz, rs.getString(columnName));

                        beanMap.put(attributeName, eEnum);

                    } catch (ClassNotFoundException e) {

                        ApplicationLogger.error("Classe não encontrada para " + className, this.getClass(), e);

                    }

                } else {

                    beanMap.put(attributeName, rs.getObject(columnName));

                }

            }

        }

    }

}