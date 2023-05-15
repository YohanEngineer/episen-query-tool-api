package com.episen.repository;

import com.episen.model.InformationSchemaColumn;
import com.episen.model.InformationSchemaTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface InformationSchemaColumnRepository extends JpaRepository<InformationSchemaColumn, String> {
    @Query(value = "SELECT column_name, data_type FROM information_schema.columns WHERE table_name = ?1 ORDER BY column_name ASC", nativeQuery = true)
    public List<Map<String,String>> findColumnNamesByTableName(String tableName);
}
