package com.scu.zdhzzz.gd.dto;

public class MessageDto {

    private String time;

    private String content;

    public MessageDto(String time, String content) {
        this.time = time;
        this.content = content;
    }

    public MessageDto() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
