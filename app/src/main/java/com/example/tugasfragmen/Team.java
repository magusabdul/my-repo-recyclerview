package com.example.tugasfragmen;

import android.os.Parcel;
import android.os.Parcelable;

public class Team {
    private String name;
    private String logo;
    private String detail;
    private String no;

    public Team(){

    }

    public Team(String name, String logo, String detail,String no) {
        this.name = name;
        this.logo = logo;
        this.detail = detail;
        this.no=no;

    }

    public String getName() {
        return name;
    }

    public String getLogo() {
        return logo;
    }

    public String getDetail() {
        return detail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
}
