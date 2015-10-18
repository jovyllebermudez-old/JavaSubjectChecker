/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.twero.subjectchecker.model;

import java.util.Date;

/**
 *
 * @author twero
 */
public class Subject {
    
    private int id;
    private String name;
    private Date time;
    //TODO Chane rooom to room
    private String rooom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getRooom() {
        return rooom;
    }

    public void setRooom(String rooom) {
        this.rooom = rooom;
    }
    
    
    
    
    
    
}
