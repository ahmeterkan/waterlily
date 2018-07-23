package com.ahmeterkan48.waterlily;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView list;

    String[] levels = new String[]{
            "Level 1", "Level 2", "Level 3", "Level 4", "Level 5"
    };
    Context contex = this;
    Button play;
    TextView skor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.levels);
        skor=(TextView) findViewById(R.id.score);
        play = (Button) findViewById(R.id.btnPlay);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        final int lvl1 = preferences.getInt("lvl1", 0);
        final int lvl2 = preferences.getInt("lvl2", 0);
        final int lvl3 = preferences.getInt("lvl3", 0);
        final int lvl4 = preferences.getInt("lvl4", 0);
        final int score=preferences.getInt("score",0);
        skor.setText("Score: "+score);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                contex, R.layout.list_level, levels);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (levels[i] == "Level 1") {

                    Intent intent = new Intent(getApplicationContext(), FirstLevel.class);
                    startActivity(intent);
                } else if (levels[i] == "Level 2" && lvl1 > 0) {

                    Intent intent = new Intent(getApplicationContext(), SecondLevel.class);
                    startActivity(intent);
                } else if (levels[i] == "Level 3" && lvl2 > 0) {

                    Intent intent = new Intent(getApplicationContext(), ThirdLevel.class);
                    startActivity(intent);
                } else if (levels[i] == "Level 4" && lvl3 > 0) {

                    Intent intent = new Intent(getApplicationContext(), FourthLevel.class);
                    startActivity(intent);
                } else if (levels[i] == "Level 5" && lvl4 > 0) {

                    Intent intent = new Intent(getApplicationContext(), FifthLevel.class);
                    startActivity(intent);
                }
            }
        });


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Play.class);
                startActivity(intent);
            }
        });


    }
}
