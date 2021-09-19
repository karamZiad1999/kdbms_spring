package com.atypon.kdbms_spring.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Record {
    private LinkedHashMap<String, String> fields;
    private ArrayList<String> fieldNames;
    private String primaryKeyName;

    public Record(String record, ArrayList<String> fieldNames, String primaryKeyName){
        fields = new LinkedHashMap<String, String>();
        this.primaryKeyName = primaryKeyName;
        this.fieldNames=fieldNames;
        parseFields(record);
    }

    public LinkedHashMap<String, String> getFields() {
        return fields;
    }

    private void parseFields(String record){
        String[] fieldSections = record.trim().split(",");
        int i = 0;
        for(String fieldName : fieldNames){
            fields.put(fieldName, fieldSections[i++]);
        }
    }
    public String getPrimaryKey(){
        return fields.get(primaryKeyName);
    }

    public String getField(String fieldName){
        if(fields.containsKey(fieldName)) return fields.get(fieldName);
        else return "NaN";
    }
}
