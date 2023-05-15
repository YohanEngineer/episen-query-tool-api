package com.episen.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RawSqlService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> executeSql(String sql) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(sql);
        String query = jsonNode.get("sql").asText();
        System.out.println("Executing SQL query: " + query);
        if (!query.trim().toLowerCase().startsWith("select")) {
            throw new Exception("Seules les requêtes SELECT sont autorisées.");
        }
        return jdbcTemplate.queryForList(query);
    }
}
