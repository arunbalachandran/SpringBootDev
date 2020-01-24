package com.arunbalachandran.pifinder.dto;

public class PiDTO {

    private String precision;

    public PiDTO(String precision) {
        this.precision = precision;
    }

    public PiDTO() {}

    // TODO: add checks
    public void setPrecision(String precision) {
        this.precision = precision;
    }
   
    public int getPrecision() {
        return Integer.parseInt(this.precision);
    }
}