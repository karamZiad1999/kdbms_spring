package com.atypon.kdbms_spring.domain;

import java.util.ArrayList;

public class Payload {
    private ArrayList<String> fieldNames;
    private ArrayList<Record> records;
    private String primaryKeyName;

    public Payload(String csv){
        fieldNames = new ArrayList<String>();
        records = new ArrayList<Record>();
        parseCsv(csv);
    }

    private void parseCsv(String csv){
        String[] lines = csv.trim().split("\n");
        String header = lines[0];

        parseHeaders(header);
        parseFields(lines);
    }

    private void parseHeaders(String header){
        String[] headerSections = header.split(",");
        for(int i = 0; i < headerSections.length; i++){
            if(headerSections[i].trim().equals("primary key")&&++i<headerSections.length) primaryKeyName = headerSections[i];
            else fieldNames.add(headerSections[i]);
        }
    }

    public ArrayList<Record> getRecords() {
        return records;
    }

    private void parseFields(String[] csvRecords){
        for(int i = 1; i< csvRecords.length ; i++){
            records.add(new Record(csvRecords[i], fieldNames, primaryKeyName));
        }
    }

    public ArrayList<String> getFieldNames() {
        return fieldNames;
    }

    public String getPrimaryKeyName() {
        return primaryKeyName;
    }
}
