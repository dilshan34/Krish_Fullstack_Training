package com.dilshan.fuel.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "createorder")
public class Fuel {

    @Id
    int id;
    int f_id;
    String f_name;
    int f_capacity;
    String f_type;
    int dispatch;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    Date submit_date;

    @PrePersist
    private void onCreate(){
        submit_date=new Date();
    }

    public int getDispatch() {
        return dispatch;
    }

    public void setDispatch(int dispatch) {
        this.dispatch = dispatch;
    }

    public Fuel(int f_id, String f_name, int f_capacity, String f_type) {
        this.f_id = f_id;
        this.f_name = f_name;
        this.f_capacity = f_capacity;
        this.f_type = f_type;
    }

    public Fuel(){};

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

    public Date getSubmit_date() {
        return submit_date;
    }

    public Fuel(Date submit_date) {
        this.submit_date = submit_date;
    }

    public void setSubmit_date(Date submit_date) {
        this.submit_date = submit_date;
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
