package com.atypon.kdbms_spring.service;

import com.atypon.kdbms_spring.domain.Payload;
import com.atypon.kdbms_spring.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordService {
    @Autowired
    RecordRepository recordRepository;
    public Payload getRecords(String schemaName, String tableName, String field, String value) {
        String query = "USE " + schemaName + " SELECT * FROM " + tableName + " WHERE " + field + " = " + value;
        return recordRepository.getQuery(query);
    }

    public Payload getRecordsWithCondition(String schemaName, String tableName, String field, String condition, String value){
        String query = "USE " + schemaName + " SELECT * FROM " + tableName + " WHERE " + field + condition + value;
        return recordRepository.getQuery(query);
    }

    public Payload getAllRecords(String schemaName, String tableName){
        String query = "USE " + schemaName + " SELECT * FROM " + tableName;
        return recordRepository.getQuery(query);
    }

    public Payload deleteRecords(String schemaName, String tableName, String field, String condition, String value){
        String query = "USE " + schemaName + " DELETE FROM " + tableName + " WHERE " + field + condition + value;
        return recordRepository.getQuery(query);
    }

    public Payload InsertRecord(String schemaName, String tableName, String values){
        String query = "USE " + schemaName + " INSERT INTO " + tableName + " " + values;
        return recordRepository.getQuery(query);
    }

    public Payload createSchema(String schemaName){
        String query = "CREATE SCHEMA " + schemaName;
        return recordRepository.getQuery(query);
    }

    public Payload getMeta(String schemaName, String tableName){
        String query = "USE " + schemaName + " SELECT META FROM " + tableName;
        return recordRepository.getQuery(query);
    }

    public Payload createTable(String schemaName, String tableName, String metaData){
        String query = "USE " + schemaName + " CREATE TABLE " + metaData;
        return recordRepository.getQuery(query);
    }

    public Payload sendQuery(String schemaName, String tableName, String query){
        return recordRepository.getQuery(query);
    }
}
