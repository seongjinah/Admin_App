package com.example.adminapp.Data;

import java.io.Serializable;

public class Broker implements Serializable {
    private Long id;
    private String userId;
    private String qualification;
    private String phoneNumber;
    private String name;
    private String imageUrl;
    private String idNum;
    private License license;

    public Broker(Long id, String userId, String qualification, String phoneNumber, String name, String imageUrl, String idNum, License license) {
        this.id = id;
        this.userId = userId;
        this.qualification = qualification;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.imageUrl = imageUrl;
        this.idNum = idNum;
        license = license;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        license = license;
    }

    @Override
    public String toString() {
        return "Broker{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", qualification='" + qualification + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", idNum='" + idNum + '\'' +
                ", license=" + license +
                '}';
    }
}
