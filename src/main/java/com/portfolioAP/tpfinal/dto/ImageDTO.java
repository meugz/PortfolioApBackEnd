package com.portfolioAP.tpfinal.dto;

public class ImageDTO {

    private String nombreImg;

    //constructores

    public ImageDTO(){

    }

    public ImageDTO(String nombreImg) {
        this.nombreImg = nombreImg;
    }


    //getter y setter
    public String getNombreImg() {
        return nombreImg;
    }

    public void setNombreImg(String nombreImg) {
        this.nombreImg = nombreImg;
    }
}
