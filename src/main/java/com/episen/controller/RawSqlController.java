package com.episen.controller;

import com.episen.service.RawSqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class RawSqlController {
    @Autowired
    private RawSqlService rawSqlService;

    @PostMapping("/raw-sql")
    public ResponseEntity<?> executeSql(@RequestBody String sql) {
        try {
            List<Map<String, Object>> result = rawSqlService.executeSql(sql);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erreur lors de l'exécution de la requête SQL : " + e.getMessage());
        }
    }
}
