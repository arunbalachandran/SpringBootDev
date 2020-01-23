package com.arunbalachandran.pifinder.dto;

public class PiDTO {

    private String precision;

    public PiDTO(String precision) {
        this.precision = precision;
    }

    public PiDTO() {}

    public void setPrecision(String precision) {
        this.precision = precision;
    }
   
    // maybe this should return precision? why?
    public String getPrecision() {
        return this.precision;
    }
}