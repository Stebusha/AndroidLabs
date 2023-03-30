package com.example.achievementroom;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mydb.MyDB;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.findViewById(R.id.button_inf).setOnClickListener(this::click);

        MyDB myDB = new MyDB(this);
        SQLiteDatabase sqLiteDatabase = myDB.getWritableDatabase();
        sqLiteDatabase.close();
        myDB.close();
    }

    public void click(View view) {
        EditText edit = this.findViewById(R.id.text2);
        if (edit.getText().toString().equals("")) edit.setText("Автор проекта: Миненкова Надежда ВПР43");
        else edit.setText("");
    }

    public void startNewPage(View view){
        Intent intent = new Intent(this, MenuActivity.class);
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage("Вы действительно хотите войти?")
                .setCancelable(false).setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(intent);
                    }
                });
        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
    }
}