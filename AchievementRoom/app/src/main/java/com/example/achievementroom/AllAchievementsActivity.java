package com.example.achievementroom;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import com.example.mydb.MyDB;

public class AllAchievementsActivity extends AppCompatActivity {
    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_achievements_activity);

        MyDB mydb = new MyDB(this);
        SQLiteDatabase sqdb = mydb.getWritableDatabase();

        TextView achievement = findViewById(R.id.textView);

        String insertQuery =  "SELECT " + MyDB.ACHIEVEMENT_NAME + " FROM " + MyDB.TABLE_ACHIEVEMENTS+" ;";

        Cursor otvet = sqdb.rawQuery(insertQuery, null);
        String result = "";
        while (otvet.moveToNext()) {
            result += otvet.getString(otvet.getColumnIndex(MyDB.ACHIEVEMENT_NAME)) + '\n';
        }

        achievement.setText(result);

        sqdb.close();
        mydb.close();
    }
}
