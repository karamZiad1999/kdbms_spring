package com.atypon.kdbms_spring.domain;

public class Relation {
    String relationName;
    String fieldName;
    String foreignFieldName;

    public Relation(String relationName, String fieldName){
        this.relationName=relationName;
        this.fieldName=fieldName;
    }
    public String getRelationName() {
        return relationName;
    }

    public void setRelationName(String relationName) {
        this.relationName = relationName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getForeignFieldName() {
        return foreignFieldName;
    }

    public void setForeignFieldName(String foreignFieldName) {
        this.foreignFieldName = foreignFieldName;
    }
}
