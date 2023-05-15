package com.episen.repository;

import com.episen.model.ForeignKeyRelationship;

import java.util.List;

public interface ForeignKeyRelationshipRepository {
    List<ForeignKeyRelationship> findForeignKeyRelationshipsByTableName(String tableName);
}
