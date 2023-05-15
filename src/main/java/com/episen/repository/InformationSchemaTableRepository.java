package com.episen.repository;

import com.episen.model.InformationSchemaTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InformationSchemaTableRepository extends JpaRepository<InformationSchemaTable, String> {
    @Query(value = "SELECT DISTINCT tc.table_name FROM information_schema.tables tc WHERE tc.table_schema = 'public'", nativeQuery = true)
    List<String> findDistinctTableNames();
}
