package org.ddiachenko.utils;

import org.flywaydb.core.Flyway;

public class DatabaseMigrationService {

    public static void doMigrate() {
        Flyway flyway = Flyway.configure().dataSource(PropertyReader.getConnectionUrlForPostgres(),
                PropertyReader.getUserForPostgres(),
                PropertyReader.getPasswordForPostgres())
                .load();
        flyway.migrate();
    }

}