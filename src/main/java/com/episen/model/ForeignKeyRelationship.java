package com.episen.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForeignKeyRelationship {

    @Column(name = "table_name")
    private String tableName;

    @Column(name = "column_name")
    private String columnName;

    @Column(name = "foreign_table_name")
    private String foreignTableName;

    @Column(name = "foreign_column_name")
    private String foreignColumnName;

}
