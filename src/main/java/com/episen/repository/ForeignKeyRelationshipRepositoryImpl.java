package com.episen.repository;

import com.episen.model.ForeignKeyRelationship;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ForeignKeyRelationshipRepositoryImpl implements ForeignKeyRelationshipRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ForeignKeyRelationship> findForeignKeyRelationshipsByTableName(String tableName) {
        String sql = "SELECT " +
                "    tc.table_name, " +
                "    kcu.column_name, " +
                "    ccu.table_name AS foreign_table_name, " +
                "    ccu.column_name AS foreign_column_name " +
                "FROM " +
                "    information_schema.table_constraints AS tc " +
                "    JOIN information_schema.key_column_usage AS kcu ON tc.constraint_name = kcu.constraint_name " +
                "    JOIN information_schema.constraint_column_usage AS ccu ON ccu.constraint_name = tc.constraint_name " +
                "WHERE " +
                "    tc.constraint_type = 'FOREIGN KEY' " +
                "    AND tc.table_schema = 'public' " +
                "    AND tc.table_name = :tableName";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("tableName", tableName);

        @SuppressWarnings("unchecked")
        List<Object[]> resultList = query.getResultList();

        return resultList.stream()
                .map(record -> new ForeignKeyRelationship(
                        (String) record[0],
                        (String) record[1],
                        (String) record[2],
                        (String) record[3]))
                .collect(Collectors.toList());
    }
}
