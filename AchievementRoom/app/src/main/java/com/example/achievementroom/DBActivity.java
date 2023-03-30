package com.example.achievementroom;

import androidx.appcompat.app.AppCompatActivity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mydb.MyDB;

public class DBActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
    }
    public void showMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    public  void insertClick(View view){
        MyDB mydb = new MyDB(this);
        SQLiteDatabase sqdb = mydb.getWritableDatabase();

        EditText tag = findViewById(R.id.text_achievement);

        String insertQuery = "INSERT INTO " +  MyDB.TABLE_ACHIEVEMENTS +
                " (" + MyDB.ACHIEVEMENT_NAME +" ) VALUES ('"+
                tag.getText() +"')";

        sqdb.execSQL(insertQuery);

        sqdb.close();
        mydb.close();
        showMessage("Достижение записано!");
    }
}
