package com.example.achievementroom;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MenuActivity extends AppCompatActivity {

    static int exit=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        if(exit==0){
            showMessage("Вход выполнен");
            exit++;
        }
    }

    public void showMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void information(View view){
        EditText edit = this.findViewById(R.id.text2);
        if (edit.getText().toString().equals("")) edit.setText("Автор проекта: Миненкова Надежда ВПР43");
        else edit.setText("");
    }

    public void startChoices(View view){
        Intent intent = new Intent(this, ChoicesActivity.class);
        startActivity(intent);
    }

    public void startAchievements(View view){
        Intent intent = new Intent(this, DBActivity.class);
        startActivity(intent);
    }

    public void AllAchievements(View view){
        Intent intent = new Intent(this, AllAchievementsActivity.class);
        startActivity(intent);
    }

    public void Request(View view){
        postData("Котики - лучшие питомцы");
    }

    private void postData(String text) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://login1.requestcatcher.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);

        model ourModel = new model(text);

        Call<model> call = retrofitAPI.createPost(ourModel);

        call.enqueue(new Callback<model>() {
            @Override
            public void onResponse(Call<model> call, Response<model> response) {
                model responseFromAPI = response.body();
                String responseString = "Response Code : " + response.code()
                        + "\nlogin : " + responseFromAPI.getText() ;
            }

            @Override
            public void onFailure(Call<model> call, Throwable t) {
            }
        });
    }

}
