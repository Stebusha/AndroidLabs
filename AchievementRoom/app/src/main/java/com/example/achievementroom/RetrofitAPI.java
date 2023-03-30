package com.example.achievementroom;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitAPI {
    @POST("login1")
    Call<model> createPost(@Body model dataModel);
}
