package com.example.adminapp.Data;

import java.io.Serializable;

public class House implements Serializable {

    private Long idx;
    private String residence_type;
    private String code;
    private String residence_name;
    private int dong;
    private int ho;
    private String address;
    private double net_leaseable_area;
    private double leaseable_area;
    private String titleImg;
    private String sellerName;
    private String sellerIdNum;

    public House(Long idx, String residence_type, String code, int dong, int ho) {
        this.idx = idx;
        this.residence_type = residence_type;
        this.code = code;
        this.dong = dong;
        this.ho = ho;
    }

    public House(Long idx, String residence_type, String code, int dong, int ho, double net_leaseable_area, double leaseable_area, String titleImg, String sellerName, String sellerIdNum) {
        this.idx = idx;
        this.residence_type = residence_type;
        this.code = code;
        this.dong = dong;
        this.ho = ho;
        this.net_leaseable_area = net_leaseable_area;
        this.leaseable_area = leaseable_area;
        this.titleImg = titleImg;
        this.sellerName = sellerName;
        this.sellerIdNum = sellerIdNum;

        this.residence_name = "default";
        this.address = "default";
    }

    public House() {
    }

    @Override
    public String toString() {
        return "House{" +
                "idx=" + idx +
                ", residence_type='" + residence_type + '\'' +
                ", code='" + code + '\'' +
                ", residence_name='" + residence_name + '\'' +
                ", dong=" + dong +
                ", ho=" + ho +
                ", address='" + address + '\'' +
                ", net_leaseable_area=" + net_leaseable_area +
                ", leaseable_area=" + leaseable_area +
                ", titleImg='" + titleImg + '\'' +
                ", sellerName='" + sellerName + '\'' +
                ", sellerIdNum='" + sellerIdNum + '\'' +
                '}';
    }

    public Long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
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

    public int getDong() {
        return dong;
    }

    public void setDong(int dong) {
        this.dong = dong;
    }

    public int getHo() {
        return ho;
    }

    public void setHo(int ho) {
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

    public String getSellerIdNum() {
        return sellerIdNum;
    }

    public void setSellerIdNum(String sellerIdNum) {
        this.sellerIdNum = sellerIdNum;
    }
}
