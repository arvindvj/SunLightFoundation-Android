package com.example.varvind.congress;

import java.io.Serializable;

/**
 * Created by v Arvind on 11/30/2016.
 */
public class Stuff2 implements Serializable {
        private String billid;
        private String billtype;
        private String sponsor;
        private String chamber;
        private String intro;
        private String congurl;
        private String version;
        private String billurl;
    private String title;
    private String active;

        public Stuff2(String billid, String billtype, String sponsor, String chamber, String intro, String congurl, String version, String billurl, String titl, String active ) {
            this.billid = billid;
            this.billtype = billtype;
            this.sponsor = sponsor;
            this.chamber = chamber;
            this.intro = intro;
            this.congurl = congurl;
            this.version = version;
            this.billurl = billurl;
            this.title = titl;
            this.active = active;

        }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBillid() {
        return billid;
    }

    public void setBillid(String billid) {
        this.billid = billid;
    }

    public String getBilltype() {
        return billtype;
    }

    public void setBilltype(String billtype) {
        this.billtype = billtype;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public String getChamber() {
        return chamber;
    }

    public void setChamber(String chamber) {
        this.chamber = chamber;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getCongurl() {
        return congurl;
    }

    public void setCongurl(String congurl) {
        this.congurl = congurl;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getBillurl() {
        return billurl;
    }

    public void setBillurl(String billurl) {
        this.billurl = billurl;
    }
}
