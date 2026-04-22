package org.example.proyectofinal.config;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.function.CommonFunctionFactory;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class SQLiteDialect extends Dialect {

    public SQLiteDialect() {
        super();
    }

    @Override
    public void initializeFunctionRegistry(CommonFunctionFactory functionFactory) {
        functionFactory.concat();
        functionFactory.length();
        functionFactory.lower();
        functionFactory.upper();
        functionFactory.substring();
        functionFactory.trim();
    }

    @Override
    public void contributeJdbcTypes(
            org.hibernate.type.spi.TypeConfiguration typeConfiguration,
            JdbcEnvironment jdbcEnvironment
    ) {
        // SQLite no necesita configuraciones especiales aquí
    }

    @Override
    public boolean supportsIdentityColumns() {
        return true;
    }

    @Override
    public String getIdentityColumnString(int type) {
        return "integer";
    }

    @Override
    public String getIdentitySelectString(String table, String column, int type) {
        return "select last_insert_rowid()";
    }
}
