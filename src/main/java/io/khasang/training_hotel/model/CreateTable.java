package io.khasang.training_hotel.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class CreateTable {
    private JdbcTemplate jdbcTemplate;

    public CreateTable() {
    }

    public CreateTable(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String createTableStatus() {
        try {
            jdbcTemplate.execute("DROP TABLE IF EXISTS films");
            jdbcTemplate.execute("CREATE TABLE PUBLIC.films (\n" +
                    "id INTEGER NOT NULL, \n" +
                    "title CHARACTER VARYING (255), \n" +
                    "CONSTRAINT firstkey PRIMARY KEY (id)" +
                    ");");
            return "table created";
        } catch (Exception e) {
            return "Table creation faile. " + e;
        }
    }
}
