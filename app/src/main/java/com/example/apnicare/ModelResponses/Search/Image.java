package com.example.apnicare.ModelResponses.Search;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("original_path")
    @Expose
    private String originalPath;
    @SerializedName("thumbnail_path")
    @Expose
    private String thumbnailPath;
    @SerializedName("small_path")
    @Expose
    private String smallPath;
    @SerializedName("medium_path")
    @Expose
    private String mediumPath;
    @SerializedName("large_path")
    @Expose
    private String largePath;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginalPath() {
        return originalPath;
    }

    public void setOriginalPath(String originalPath) {
        this.originalPath = originalPath;
    }

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
    }

    public String getSmallPath() {
        return smallPath;
    }

    public void setSmallPath(String smallPath) {
        this.smallPath = smallPath;
    }

    public String getMediumPath() {
        return mediumPath;
    }

    public void setMediumPath(String mediumPath) {
        this.mediumPath = mediumPath;
    }

    public String getLargePath() {
        return largePath;
    }

    public void setLargePath(String largePath) {
        this.largePath = largePath;
    }
}
