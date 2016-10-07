package com.dic.kimxeang.customlistview;

/**
 * Created by Kim Xeang on 9/19/2016.
 */

public class ListModel {
    private String CompanyName="";
    private String Image="";
    private String Url="";

    public String getCompanyName() {
        return this.CompanyName;
    }

    public void setCompanyName(String companyName) {
        this.CompanyName = companyName;
    }

    public String getUrl() {
        return this.Url;
    }

    public void setUrl(String url) {
        this.Url = url;
    }

    public String getImage() {
        return  this.Image;
    }

    public void setImage(String image) {
        this.Image = image;
    }
}

