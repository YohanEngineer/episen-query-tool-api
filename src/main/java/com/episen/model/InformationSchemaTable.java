package com.episen.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tables", schema = "information_schema")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InformationSchemaTable {
    @Id
    @Column(name = "table_catalog")
    private String tableCatalog;

    @Column(name = "table_schema")
    private String tableSchema;

    @Column(name = "table_name")
    private String tableName;

    @Column(name = "table_type")
    private String tableType;
}
