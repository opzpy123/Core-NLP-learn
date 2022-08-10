package com.opzpy123.nlp.dto;

public class EmotionDto {
    private Integer sentimentInt;
    private String sentimentName;
    private String content;

    public EmotionDto() {
    }

    public EmotionDto(Integer sentimentInt, String sentimentName, String content) {
        this.sentimentInt = sentimentInt;
        this.sentimentName = sentimentName;
        this.content = content;
    }

    public Integer getSentimentInt() {
        return sentimentInt;
    }

    public void setSentimentInt(Integer sentimentInt) {
        this.sentimentInt = sentimentInt;
    }

    public String getSentimentName() {
        return sentimentName;
    }

    public void setSentimentName(String sentimentName) {
        this.sentimentName = sentimentName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
