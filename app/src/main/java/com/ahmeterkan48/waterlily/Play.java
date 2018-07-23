package com.ahmeterkan48.waterlily;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class Play extends AppCompatActivity {
    public int counter;
    public int sayac = 5;
    TextView textView;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    ImageButton pic, minepic;
    Button restart, menu;
    Random r = new Random();
    int goster;
    int x, y;
    int hiz = 1000;
    long sure;
    Context contex = this;
    Handler handler = new Handler();
    int mayinSayac = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
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
        pic = (ImageButton) findViewById(R.id.imageButton2);
        minepic = (ImageButton) findViewById(R.id.imageButton3);

        restart.setVisibility(View.INVISIBLE);
        menu.setVisibility(View.INVISIBLE);
        minepic.setVisibility(View.INVISIBLE);
        pic.setVisibility(View.INVISIBLE);

        final AbsoluteLayout.LayoutParams params = (AbsoluteLayout.LayoutParams) pic.getLayoutParams();
        final AbsoluteLayout.LayoutParams params2 = (AbsoluteLayout.LayoutParams) minepic.getLayoutParams();

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Play.this, Play.class);
                startActivity(intent);
            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Play.this, MainActivity.class);
                startActivity(intent);
            }
        });

        new CountDownTimer(6000, 1000) {
            public void onTick(final long millisUntilFinished) {
                sayac--;
                if (sayac == 4) {
                } else if (sayac == 0) {
                    textView5.setText("BAŞLAAA");
                } else {
                    textView5.setText("!!" + sayac + "!!");

                }

            }

            public void onFinish() {
                textView3.setText((3 - mayinSayac) + "CAN");
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
                        goster = r.nextInt(13) + 1;
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
                                    mayinSayac++;
                                    textView3.setText((3 - mayinSayac) + " CAN");
                                }
                            });

                        }
                        if (mayinSayac == 3) {
                            textView3.setText("FINISH!!");
                            pic.setVisibility(View.INVISIBLE);
                            minepic.setVisibility(View.INVISIBLE);
                            restart.setVisibility(View.VISIBLE);
                            menu.setVisibility(View.VISIBLE);
                            handler.removeCallbacks(this);
                            int score=preferences.getInt("score",0);
                            if (score<counter) {
                                editor.putInt("score", counter);
                            }
                            editor.commit();
                        }
                        if (counter < 5 && counter > 0) {
                            hiz = 900;
                            params.height = 200;
                            params2.height = 200;
                            params.width = 200;
                            params2.width = 200;
                            pic.setLayoutParams(params);
                            minepic.setLayoutParams(params2);
                        } else if (counter > 5 && counter < 15) {
                            hiz = 850;
                            params.height = 190;
                            params2.height = 190;
                            params.width = 190;
                            params2.width = 190;
                            pic.setLayoutParams(params);
                            minepic.setLayoutParams(params2);

                        } else if (counter > 15 && counter < 25) {
                            hiz = 800;
                            params.height = 180;
                            params2.height = 180;
                            params.width = 180;
                            params2.width = 180;
                            pic.setLayoutParams(params);
                            minepic.setLayoutParams(params2);


                        } else if (counter > 25 && counter < 35) {
                            hiz = 750;
                            params.height = 170;
                            params2.height = 170;
                            params.width = 170;
                            params2.width = 170;
                            pic.setLayoutParams(params);
                            minepic.setLayoutParams(params2);


                        } else if (counter > 35 && counter < 45) {
                            hiz = 700;
                            params.height = 160;
                            params2.height = 160;
                            params.width = 160;
                            params2.width = 160;
                            pic.setLayoutParams(params);
                            minepic.setLayoutParams(params2);


                        } else if (counter > 45 && counter < 55) {
                            hiz = 650;
                            params.height = 150;
                            params2.height = 150;
                            params.width = 150;
                            params2.width = 150;
                            pic.setLayoutParams(params);
                            minepic.setLayoutParams(params2);
                        } else if (counter > 55 && counter < 65) {
                            hiz = 600;
                            params.height = 140;
                            params2.height = 140;
                            params.width = 140;
                            params2.width = 140;
                            pic.setLayoutParams(params);
                            minepic.setLayoutParams(params2);
                        } else if (counter > 65 && counter < 75) {
                            hiz = 550;
                            params.height = 130;
                            params2.height = 130;
                            params.width = 130;
                            params2.width = 130;
                            pic.setLayoutParams(params);
                            minepic.setLayoutParams(params2);
                        } else if (counter > 75 && counter < 85) {
                            hiz = 500;
                            params.height = 120;
                            params2.height = 120;
                            params.width = 120;
                            params2.width = 120;
                            pic.setLayoutParams(params);
                            minepic.setLayoutParams(params2);
                        } else if (counter > 85 && counter < 95) {
                            hiz = 450;
                            params.height = 110;
                            params2.height = 110;
                            params.width = 110;
                            params2.width = 110;
                            pic.setLayoutParams(params);
                            minepic.setLayoutParams(params2);
                        } else if (counter > 95 && counter < 105) {
                            hiz = 400;
                            params.height = 100;
                            params2.height = 100;
                            params.width = 100;
                            params2.width = 100;
                            pic.setLayoutParams(params);
                            minepic.setLayoutParams(params2);
                        } else if (counter > 105 && counter < 115) {
                            hiz = 350;
                            params.height = 90;
                            params2.height = 90;
                            params.width = 90;
                            params2.width = 90;
                            pic.setLayoutParams(params);
                            minepic.setLayoutParams(params2);
                        } else if (counter > 115 && counter < 125) {
                            hiz = 300;
                            params.height = 80;
                            params2.height = 80;
                            params.width = 80;
                            params2.width = 80;
                            pic.setLayoutParams(params);
                            minepic.setLayoutParams(params2);
                        }
                    }

                }, hiz);
                textView5.setVisibility(View.INVISIBLE);
                pic.setVisibility(View.VISIBLE);


            }

        }.start();
    }
}

