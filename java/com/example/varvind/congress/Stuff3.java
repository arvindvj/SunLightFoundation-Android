package com.example.varvind.congress;

import java.io.Serializable;

/**
 * Created by v Arvind on 11/30/2016.
 */
public class Stuff3 implements Serializable{
    private String id;
    private String name;
    private String chamber;
    private String parentcom;
    private String contact;
    private String office;

    public Stuff3(String id, String name, String chamber, String parentcom, String contact, String office) {
        this.id = id;
        this.name = name;
        this.chamber = chamber;
        this.contact = contact;
        this.parentcom = parentcom;
        this.office = office;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChamber() {
        return chamber;
    }

    public void setChamber(String chamber) {
        this.chamber = chamber;
    }

    public String getParentcom() {
        return parentcom;
    }

    public void setParentcom(String parentcom) {
        this.parentcom = parentcom;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }
}