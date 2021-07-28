package com.example.adminapp.Data;

import java.io.Serializable;

public class House implements Serializable {

    private int idx;
    private String residence_type;
    private String code;
    private String residence_name;
    private String dong;
    private String ho;
    private String address;
    private double net_leaseable_area;
    private double leaseable_area;
    private String titleImg;
    private String sellerName;
    private String sellerNum;

    public House(int idx, String residence_type, String code, String dong, String ho, double net_leaseable_area, double leaseable_area, String titleImg, String sellerName, String sellerNum) {
        this.idx = idx;
        this.residence_type = residence_type;
        this.code = code;
        this.dong = dong;
        this.ho = ho;
        this.net_leaseable_area = net_leaseable_area;
        this.leaseable_area = leaseable_area;
        this.titleImg = titleImg;
        this.sellerName = sellerName;
        this.sellerNum = sellerNum;

        this.residence_name = "default";
        this.address = "default";
    }

    public House() {
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getResidence_type() {
        return residence_type;
    }

    public void setResidence_type(String residence_type) {
        this.residence_type = residence_type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getResidence_name() {
        return residence_name;
    }

    public void setResidence_name(String residence_name) {
        this.residence_name = residence_name;
    }

    public String getDong() {
        return dong;
    }

    public void setDong(String dong) {
        this.dong = dong;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getNet_leaseable_area() {
        return net_leaseable_area;
    }

    public void setNet_leaseable_area(double net_leaseable_area) {
        this.net_leaseable_area = net_leaseable_area;
    }

    public double getLeaseable_area() {
        return leaseable_area;
    }

    public void setLeaseable_area(double leaseable_area) {
        this.leaseable_area = leaseable_area;
    }

    public String getTitleImg() {
        return titleImg;
    }

    public void setTitleImg(String titleImg) {
        this.titleImg = titleImg;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerNum() {
        return sellerNum;
    }

    public void setSellerNum(String sellerNum) {
        this.sellerNum = sellerNum;
    }
}
