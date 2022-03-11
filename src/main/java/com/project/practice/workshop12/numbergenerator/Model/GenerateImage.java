package com.project.practice.workshop12.numbergenerator.Model;

public class GenerateImage {
    private int imgNumber;
    private String imgUrl;

    
    public GenerateImage(int imgNumber, String imgUrl) {
        this.imgNumber = imgNumber;
        this.imgUrl = imgUrl;
    }

    public int getImgNumber() {
        return imgNumber;
    }
    public void setImgNumber(int imgNumber) {
        this.imgNumber = imgNumber;
    }
    public String getImgUrl() {
        return imgUrl;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    
}
