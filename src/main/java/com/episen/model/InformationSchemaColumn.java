package com.episen.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "columns", schema = "information_schema")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InformationSchemaColumn {
    @Id
    @Column(name = "column_name")
    private String columnName;

    @Column(name = "table_schema")
    private String tableSchema;

    @Column(name = "table_name")
    private String tableName;

    @Column(name = "data_type")
    private String dataType;
}
