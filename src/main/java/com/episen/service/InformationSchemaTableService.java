package com.episen.service;

import com.episen.model.ForeignKeyRelationship;
import com.episen.repository.ForeignKeyRelationshipRepository;
import com.episen.repository.InformationSchemaColumnRepository;
import com.episen.repository.InformationSchemaTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class InformationSchemaTableService {

    private final InformationSchemaTableRepository informationSchemaTableRepository;
    private final ForeignKeyRelationshipRepository foreignKeyRelationshipRepository;

    private final InformationSchemaColumnRepository informationSchemaColumnRepository;




    @Autowired
    public InformationSchemaTableService(InformationSchemaTableRepository informationSchemaTableRepository, ForeignKeyRelationshipRepository foreignKeyRelationshipRepository, InformationSchemaColumnRepository informationSchemaColumnRepository) {
        this.informationSchemaTableRepository = informationSchemaTableRepository;
        this.foreignKeyRelationshipRepository = foreignKeyRelationshipRepository;
        this.informationSchemaColumnRepository = informationSchemaColumnRepository;
    }

    public List<ForeignKeyRelationship> findForeignKeyRelationshipsByTableName(String tableName) {
        return foreignKeyRelationshipRepository.findForeignKeyRelationshipsByTableName(tableName);
    }

    public List<String> findAll() {
        return informationSchemaTableRepository.findDistinctTableNames();
    }


    public List<Map<String, String>> findColumnNamesByTableName(String tableName) {
        return informationSchemaColumnRepository.findColumnNamesByTableName(tableName);
    }
}