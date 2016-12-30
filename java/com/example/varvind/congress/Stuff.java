package com.example.varvind.congress;

/**
 * Created by v Arvind on 11/25/2016.
 */
public class Stuff {
    private String image;
    private String name;
    private String state;
    private String district;
    private String party;
    private String title;
    private String email;
    private String chamber;
    private String contact;
    private String start;
    private String end;
    private String office;
    private String fax;
    private String birthday;

    public Stuff(String image, String name, String party, String state, String district, String title, String email, String chamber, String contact, String start, String end, String office, String fax, String birthday) {
        this.state = state;
        this.name = name;
        this.image = image;
        this.district = district;
        this.party = party;
        this.title = title;
        this.email = email;
        this.chamber = chamber;
        this.contact = contact;
        this.start = start;
        this.end = end;
        this.office = office;
        this.fax = fax;
        this.birthday = birthday;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getChamber() {
        return chamber;
    }

    public void setChamber(String chamber) {
        this.chamber = chamber;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
