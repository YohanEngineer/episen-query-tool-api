package com.episen.controller;

import com.episen.model.ForeignKeyRelationship;
import com.episen.service.InformationSchemaTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
public class InformationSchemaTableController {
    private final InformationSchemaTableService informationSchemaTableService;

    @Autowired
    public InformationSchemaTableController(InformationSchemaTableService informationSchemaTableService) {
        this.informationSchemaTableService = informationSchemaTableService;
    }

    @GetMapping("/information-schema/tables")
    public List<String> getAllInformationSchemaTables() {
        return informationSchemaTableService.findAll();
    }

    @GetMapping("/information-schema/foreign-keys/{tableName}")
    public List<ForeignKeyRelationship> getForeignKeyRelationshipsByTableName(@PathVariable("tableName") String tableName) {
        return informationSchemaTableService.findForeignKeyRelationshipsByTableName(tableName);
    }

    @GetMapping("/information-schema/columns/{tableName}")
    public List<Map<String, String>> getColumnNamesByTableName(@PathVariable("tableName") String tableName) {
        return informationSchemaTableService.findColumnNamesByTableName(tableName);
    }
}
