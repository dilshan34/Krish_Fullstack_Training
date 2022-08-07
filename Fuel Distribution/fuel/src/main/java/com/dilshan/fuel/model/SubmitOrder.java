package com.dilshan.fuel.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "createorder")
public class SubmitOrder {

    @Id
    int id;
    int dispatch;

//    @Temporal(TemporalType.DATE)
//    @Column(nullable = false)
//    Date dispatch_date;
//
//    @PrePersist
//    private void onCreate(){
//        dispatch_date=new Date();
//    }
//
//    public Date getDispatch_date() {
//        return dispatch_date;
//    }
//
//    public void setDispatch_date(Date dispatch_date) {
//        this.dispatch_date = dispatch_date;
//    }

    public int getDispatch() {
        return dispatch;
    }

    public void setDispatch(int dispatch) {
        this.dispatch = dispatch;
    }

    public SubmitOrder() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SubmitOrder(int id) {
        this.id = id;
    }
}
