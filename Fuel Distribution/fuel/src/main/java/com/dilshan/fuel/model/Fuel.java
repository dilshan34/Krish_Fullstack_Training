package com.dilshan.fuel.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "createorder")
public class Fuel {

    @Id
    int id;
    int f_id;
    String f_name;
    int f_capacity;
    String f_type;

    public int getF_id() {
        return f_id;
    }

    public void setF_id(int f_id) {
        this.f_id = f_id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getF_capacity() {
        return f_capacity;
    }

    public void setF_capacity(int f_capacity) {
        this.f_capacity = f_capacity;
    }

    public String getF_type() {
        return f_type;
    }

    public void setF_type(String f_type) {
        this.f_type = f_type;
    }
}
