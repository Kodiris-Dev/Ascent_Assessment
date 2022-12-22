package com.example.full_stack_assessment.Data;

import android.graphics.Bitmap;

public class IconsProperties {
    private Boolean isUrl;
    private String imageUrl;
    private Integer imageResource;

    public Boolean getUrl() {
        return isUrl;
    }

    public void setUrl(Boolean url) {
        isUrl = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getImageResource() {
        return imageResource;
    }

    public void setImageResource(Integer imageResource) {
        this.imageResource = imageResource;
    }
}
