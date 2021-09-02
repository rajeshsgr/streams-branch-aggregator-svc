package com.raj.nola.streams.model.salesRecord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Schema {
    private String type;
    private List<Field> fields = new ArrayList<Field>();
    private Boolean optional;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public Boolean getOptional() {
        return optional;
    }

    public void setOptional(Boolean optional) {
        this.optional = optional;
    }

    @Override
    public String toString() {
        return "Schema{" +
                "type='" + type + '\'' +
                ", fields=" + fields +
                ", optional=" + optional +
                '}';
    }
}