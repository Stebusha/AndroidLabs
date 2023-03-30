package com.example.achievementroom;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public class model {
    private String text;

    public model(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
