package com.example.frtpa.puzzlegame;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import static android.graphics.Color.CYAN;

public class SelectPuzzleGame extends AppCompatActivity {
    int rakam;
    ImageButton btn1, btn2, btn3, btn4, btn5, btn6;
   // private AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_puzzle_game);
        //reklamiYukle();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.color.lBlue));


        btn1 = findViewById(R.id.imageButton);
        btn1.setPadding(20,20,20,20);
        btn2 = findViewById(R.id.imageButton1);
        btn3 = findViewById(R.id.imageButton2);
        btn4 = findViewById(R.id.imageButton3);
        btn5 = findViewById(R.id.imageButton4);
        btn6 = findViewById(R.id.imageButton5);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rakam = 1;
                Bundle b = new Bundle();
                b.putInt("sayi", rakam);
                Intent action = new Intent(SelectPuzzleGame.this, MainActivity.class);
                action.putExtras(b);
                startActivity(action);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rakam = 2;
                Bundle b = new Bundle();
                b.putInt("sayi", rakam);
                Intent action = new Intent(SelectPuzzleGame.this, MainActivity.class);
                action.putExtras(b);
                startActivity(action);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rakam = 3;
                Bundle b = new Bundle();
                b.putInt("sayi", rakam);
                Intent action = new Intent(SelectPuzzleGame.this, MainActivity.class);
                action.putExtras(b);
                startActivity(action);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rakam = 4;
                Bundle b = new Bundle();
                b.putInt("sayi", rakam);
                Intent action = new Intent(SelectPuzzleGame.this, MainActivity.class);
                action.putExtras(b);
                startActivity(action);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rakam = 5;
                Bundle b = new Bundle();
                b.putInt("sayi", rakam);
                Intent action = new Intent(SelectPuzzleGame.this, MainActivity.class);
                action.putExtras(b);
                startActivity(action);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rakam = 6;
                Bundle b = new Bundle();
                b.putInt("sayi", rakam);
                Intent action = new Intent(SelectPuzzleGame.this, MainActivity.class);
                action.putExtras(b);
                startActivity(action);
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
           Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            NavUtils.navigateUpTo(this,intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void reklamiYukle() {
        AdView adView = (AdView) this.findViewById(R.id.adView);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId(getString(R.string.reklam_kimligi2));
        adView.addView(adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

}
