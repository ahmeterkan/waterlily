package com.ahmeterkan48.waterlily;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class FourthLevel extends AppCompatActivity {
    public int counter;
    public int sayac = 5;
    TextView textView;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    ImageButton pic, minepic;
    Button restart, nxtLVL, menu;
    Random r = new Random();
    int goster;
    int x, y;
    int hiz = 1000;
    long sure;
    Handler handler = new Handler();
    int yildiz ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_level);
        final SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        final SharedPreferences.Editor editor = preferences.edit();
        AbsoluteLayout rl = (AbsoluteLayout) findViewById(R.id.level1);
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView5 = (TextView) findViewById(R.id.textView5);
        restart = (Button) findViewById(R.id.button);
        menu = (Button) findViewById(R.id.anaMenu);
        nxtLVL = (Button) findViewById(R.id.nextLevel);
        pic = (ImageButton) findViewById(R.id.imageButton2);
        minepic = (ImageButton) findViewById(R.id.imageButton3);

        restart.setVisibility(View.INVISIBLE);
        menu.setVisibility(View.INVISIBLE);
        nxtLVL.setVisibility(View.INVISIBLE);
        minepic.setVisibility(View.INVISIBLE);
        pic.setVisibility(View.INVISIBLE);

        final AbsoluteLayout.LayoutParams params = (AbsoluteLayout.LayoutParams) pic.getLayoutParams();
        final AbsoluteLayout.LayoutParams params2 = (AbsoluteLayout.LayoutParams) minepic.getLayoutParams();

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(FourthLevel.this, FourthLevel.class);
                startActivity(intent);
            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(FourthLevel.this, MainActivity.class);
                startActivity(intent);
            }
        });
        nxtLVL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(FourthLevel.this, FifthLevel.class);
                startActivity(intent);
            }
        });
        new CountDownTimer(6000, 1000) {
            public void onTick(final long millisUntilFinished) {
                sayac--;
                if (sayac == 4) {
                    textView5.setText("Level 4");
                } else if (sayac == 0) {
                    textView5.setText("BAŞLAAA");
                } else {
                    textView5.setText("!!" + sayac + "!!");

                }

            }

            public void onFinish() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        x = r.nextInt(700) + 0;
                        y = r.nextInt(1000) + 100;
                        pic.setX(x);
                        pic.setY(y);
                        minepic.setX(x);
                        minepic.setY(y);
                        handler.postDelayed(this, hiz);
                        goster = r.nextInt(15) + 1;
                        if (goster > 2) {
                            minepic.setVisibility(View.INVISIBLE);
                            pic.setVisibility(View.VISIBLE);
                            pic.setEnabled(true);
                            pic.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    counter++;
                                    textView.setText("Puan:" + counter);
                                    pic.setEnabled(false);
                                }
                            });
                        } else {
                            pic.setVisibility(View.INVISIBLE);
                            minepic.setVisibility(View.VISIBLE);
                            minepic.setEnabled(true);

                            minepic.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    counter--;
                                    textView.setText("Puan:" + counter);
                                    minepic.setEnabled(false);

                                }
                            });
                        }
                        if (sure == 1) {
                            handler.removeCallbacks(this);

                        }
                    }

                }, hiz);
                textView5.setVisibility(View.INVISIBLE);
                pic.setVisibility(View.VISIBLE);


                new CountDownTimer(60000, 1000) {
                    public void onTick(final long millisUntilFinished) {

                        textView2.setText("Süre:" + millisUntilFinished / 1000);
                        sure = (millisUntilFinished / 1000);
                        if (counter > 5 && counter < 20) {
                            hiz = 900;
                            params.height = 200;
                            params2.height = 200;
                            params.width = 200;
                            params2.width = 200;
                            pic.setLayoutParams(params);
                            minepic.setLayoutParams(params2);

                        } else if (counter > 20 && counter < 35) {
                            hiz = 800;
                            params.height = 190;
                            params2.height = 190;
                            params.width = 190;
                            params2.width = 190;
                            pic.setLayoutParams(params);
                            minepic.setLayoutParams(params2);

                        } else if (counter > 35 && counter < 50) {
                            hiz = 700;
                            params.height = 180;
                            params2.height = 180;
                            params.width = 180;
                            params2.width = 180;
                            pic.setLayoutParams(params);
                            minepic.setLayoutParams(params2);


                        } else if (counter > 50) {
                            hiz = 600;
                            params.height = 180;
                            params2.height = 180;
                            params.width = 180;
                            params2.width = 180;
                            minepic.setLayoutParams(params2);
                            pic.setLayoutParams(params);

                        }
                    }

                    public void onFinish() {

                        textView3.setText("FINISH!!");
                        textView2.setText("Süre: 0");
                        pic.setVisibility(View.INVISIBLE);
                        minepic.setVisibility(View.INVISIBLE);
                        restart.setVisibility(View.VISIBLE);
                        menu.setVisibility(View.VISIBLE);
                        if (counter > 50) {
                            textView4.setText("3 YILDIZ");
                            yildiz=3;
                            nxtLVL.setVisibility(View.VISIBLE);

                        } else if (counter > 25) {
                            textView4.setText("2 YILDIZ");
                            yildiz=2;


                            nxtLVL.setVisibility(View.VISIBLE);

                        } else if (counter > 5) {
                            yildiz=1;


                            nxtLVL.setVisibility(View.VISIBLE);
                            textView4.setText("1 YILDIZ");

                        } else {
                            yildiz=0;


                            textView4.setText("Game Over");

                        }
                        if (yildiz > preferences.getInt("lvl4", 0)) {
                            editor.putInt("lvl4", yildiz);

                            editor.commit();
                        }

                    }
                }.start();
            }
        }.start();

    }

}
