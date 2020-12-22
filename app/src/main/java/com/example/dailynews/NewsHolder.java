package com.example.dailynews;

public class NewsHolder {
    String newsImage,NewsHeadline,NewsLines;

    public NewsHolder(){

    }

    public NewsHolder(String newsImage, String newsHeadline, String newsLines) {
        this.newsImage = newsImage;
        NewsHeadline = newsHeadline;
        NewsLines = newsLines;
    }

    public String getNewsImage() {
        return newsImage;
    }

    public void setNewsImage(String newsImage) {
        this.newsImage = newsImage;
    }

    public String getNewsHeadline() {
        return NewsHeadline;
    }

    public void setNewsHeadline(String newsHeadline) {
        NewsHeadline = newsHeadline;
    }

    public String getNewsLines() {
        return NewsLines;
    }

    public void setNewsLines(String newsLines) {
        NewsLines = newsLines;
    }
}
