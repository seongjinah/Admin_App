package com.example.adminapp.Data;

import java.io.Serializable;

public class License implements Serializable {

    private Long id;
    private String certificateURL;

    public License(Long id, String certificateURL) {
        this.id = id;
        this.certificateURL = certificateURL;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCertificateURL() {
        return certificateURL;
    }

    public void setCertificateURL(String certificateURL) {
        this.certificateURL = certificateURL;
    }

    @Override
    public String toString() {
        return "License{" +
                "id=" + id +
                ", certificateURL='" + certificateURL + '\'' +
                '}';
    }
}