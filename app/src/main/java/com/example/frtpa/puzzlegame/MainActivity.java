package com.example.frtpa.puzzlegame;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Context;
import android.text.Html;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.Random;

public  class MainActivity extends AppCompatActivity {

    private static MyGridView mGridView;

    private static final int sutun = 3;
    private static final int boyutlandir = sutun * sutun;//puzzle boyutu belirlenir.

    private static int mColumnWidth, mColumnHeight;

    public static final String up = "up";
    public static final String down = "down";
    public static final String left = "left";
    public static final String right = "right";
    public static int value=0;
    private static String[] PList;//puzzle oyunun parçaları tutulur.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.color.Green1));
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#304FFE'>Puzzle Game </font>"));

        MobileAds.initialize(this, "ca-app-pub-5234220592799650~4710961627");


        Bundle action = getIntent().getExtras();
        value=action.getInt("sayi");
        //value = getIntent().getExtras().getInt("deger");
        start();//Gridview de başlagıçta sütunları olusturulur

        karistir();//başlangıçta puzzle parçaların yerleri degiştirir.

        setBoyutlandir();//puzzle oyununu boyutlandırıyor.
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            Intent intent=new Intent(getApplicationContext(),SelectPuzzleGame.class);
            NavUtils.navigateUpTo(this,intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void start() {
        mGridView = (MyGridView) findViewById(R.id.grid);
        mGridView.setNumColumns(sutun);

        PList = new String[boyutlandir];
        for (int i = 0; i < boyutlandir; i++) {
            PList[i] = String.valueOf(i);

        }
    }

    private void karistir() {
        int index;
        String temp;
        Random random = new Random();

        for (int i = PList.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);//0 le i+1' kadar rasgele sayı ürettir.
            temp = PList[index];
            PList[index] = PList[i];
            PList[i] = temp;

        }
    }

    public void setBoyutlandir() {
        ViewTreeObserver vto = mGridView.getViewTreeObserver();//dinleyici.puzzle üzerinde yaptıgımız degişikleri dinler
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    mGridView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                int displayWidth = mGridView.getMeasuredWidth();//ölçülen genişlik
                int displayHeight = mGridView.getMeasuredHeight();//ölçülen yükseklik

                int statusbarHeight = getStatusBarHeight(getApplicationContext());//durum çubugu yüksekligi
                int requiredHeight = displayHeight - statusbarHeight;//gerekli yükseklik

                mColumnWidth = displayWidth / sutun;//sütün genişligi
                mColumnHeight = requiredHeight / sutun;//sütun yüksekligi

                display(getApplicationContext());
            }
        });
    }

    private int getStatusBarHeight(Context context) {//durum çubuğu
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen",
                "android");

        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }

        return result;
    }

    private static void display(Context context) {
        ArrayList<Button> buttons = new ArrayList<>();
        Button button;
        if(value==1){
            for (int i = 0; i < PList.length; i++) {
                button = new Button(context);

                if (PList[i].equals("0"))
                    button.setBackgroundResource(R.drawable.bird_001);
                else if (PList[i].equals("1"))
                    button.setBackgroundResource(R.drawable.bird_002);
                else if (PList[i].equals("2"))
                    button.setBackgroundResource(R.drawable.bird_003);
                else if (PList[i].equals("3"))
                    button.setBackgroundResource(R.drawable.bird_004);
                else if (PList[i].equals("4"))
                    button.setBackgroundResource(R.drawable.bird_005);
                else if (PList[i].equals("5"))
                    button.setBackgroundResource(R.drawable.bird_006);
                else if (PList[i].equals("6"))
                    button.setBackgroundResource(R.drawable.bird_007);
                else if (PList[i].equals("7"))
                    button.setBackgroundResource(R.drawable.bird_008);
                else if (PList[i].equals("8"))
                    button.setBackgroundResource(R.drawable.bird_009);

                buttons.add(button);
            }
            mGridView.setAdapter(new ButtonOzellestirme(buttons, mColumnWidth, mColumnHeight));
        }

        if(value==2) {
            for (int i = 0; i < PList.length; i++) {
                button = new Button(context);
                if (PList[i].equals("0"))
                    button.setBackgroundResource(R.drawable.fox_001);
                else if (PList[i].equals("1"))
                    button.setBackgroundResource(R.drawable.fox_002);
                else if (PList[i].equals("2"))
                    button.setBackgroundResource(R.drawable.fox_003);
                else if (PList[i].equals("3"))
                    button.setBackgroundResource(R.drawable.fox_004);
                else if (PList[i].equals("4"))
                    button.setBackgroundResource(R.drawable.fox_005);
                else if (PList[i].equals("5"))
                    button.setBackgroundResource(R.drawable.fox_006);
                else if (PList[i].equals("6"))
                    button.setBackgroundResource(R.drawable.fox_007);
                else if (PList[i].equals("7"))
                    button.setBackgroundResource(R.drawable.fox_008);
                else if (PList[i].equals("8"))
                    button.setBackgroundResource(R.drawable.fox_009);

                buttons.add(button);
            }
            mGridView.setAdapter(new ButtonOzellestirme(buttons, mColumnWidth, mColumnHeight));
        }
            if(value==3) {
                for (int i = 0; i < PList.length; i++) {
                    button = new Button(context);
                    if (PList[i].equals("0"))
                        button.setBackgroundResource(R.drawable.elg_001);
                    else if (PList[i].equals("1"))
                        button.setBackgroundResource(R.drawable.elg_002);
                    else if (PList[i].equals("2"))
                        button.setBackgroundResource(R.drawable.elg_003);
                    else if (PList[i].equals("3"))
                        button.setBackgroundResource(R.drawable.elg_004);
                    else if (PList[i].equals("4"))
                        button.setBackgroundResource(R.drawable.elg_005);
                    else if (PList[i].equals("5"))
                        button.setBackgroundResource(R.drawable.elg_006);
                    else if (PList[i].equals("6"))
                        button.setBackgroundResource(R.drawable.elg_007);
                    else if (PList[i].equals("7"))
                        button.setBackgroundResource(R.drawable.elg_008);
                    else if (PList[i].equals("8"))
                        button.setBackgroundResource(R.drawable.elg_009);

                    buttons.add(button);
                }
                mGridView.setAdapter(new ButtonOzellestirme(buttons, mColumnWidth, mColumnHeight));
            }
                if(value==4) {
                    for (int i = 0; i < PList.length; i++) {
                        button = new Button(context);
                        if (PList[i].equals("0"))
                            button.setBackgroundResource(R.drawable.lin_001);
                        else if (PList[i].equals("1"))
                            button.setBackgroundResource(R.drawable.lin_002);
                        else if (PList[i].equals("2"))
                            button.setBackgroundResource(R.drawable.lin_003);
                        else if (PList[i].equals("3"))
                            button.setBackgroundResource(R.drawable.lin_004);
                        else if (PList[i].equals("4"))
                            button.setBackgroundResource(R.drawable.lin_005);
                        else if (PList[i].equals("5"))
                            button.setBackgroundResource(R.drawable.lin_006);
                        else if (PList[i].equals("6"))
                            button.setBackgroundResource(R.drawable.lin_007);
                        else if (PList[i].equals("7"))
                            button.setBackgroundResource(R.drawable.lin_008);
                        else if (PList[i].equals("8"))
                            button.setBackgroundResource(R.drawable.lin_009);

                        buttons.add(button);
                    }
                    mGridView.setAdapter(new ButtonOzellestirme(buttons, mColumnWidth, mColumnHeight));
                }
                    if(value==5) {
                        for (int i = 0; i < PList.length; i++) {
                            button = new Button(context);
                            if (PList[i].equals("0"))
                                button.setBackgroundResource(R.drawable.lion_001);
                            else if (PList[i].equals("1"))
                                button.setBackgroundResource(R.drawable.lion_002);
                            else if (PList[i].equals("2"))
                                button.setBackgroundResource(R.drawable.lion_003);
                            else if (PList[i].equals("3"))
                                button.setBackgroundResource(R.drawable.lion_004);
                            else if (PList[i].equals("4"))
                                button.setBackgroundResource(R.drawable.lion_005);
                            else if (PList[i].equals("5"))
                                button.setBackgroundResource(R.drawable.lion_006);
                            else if (PList[i].equals("6"))
                                button.setBackgroundResource(R.drawable.lion_007);
                            else if (PList[i].equals("7"))
                                button.setBackgroundResource(R.drawable.lion_008);
                            else if (PList[i].equals("8"))
                                button.setBackgroundResource(R.drawable.lion_009);

                            buttons.add(button);
                        }
                        mGridView.setAdapter(new ButtonOzellestirme(buttons, mColumnWidth, mColumnHeight));
                    }
                        if(value==6){
                            for (int i = 0; i < PList.length; i++) {
                                button = new Button(context);
                                if (PList[i].equals("0"))
                                    button.setBackgroundResource(R.drawable.sin_001);
                                else if (PList[i].equals("1"))
                                    button.setBackgroundResource(R.drawable.sin_002);
                                else if (PList[i].equals("2"))
                                    button.setBackgroundResource(R.drawable.sin_003);
                                else if (PList[i].equals("3"))
                                    button.setBackgroundResource(R.drawable.sin_004);
                                else if (PList[i].equals("4"))
                                    button.setBackgroundResource(R.drawable.sin_005);
                                else if (PList[i].equals("5"))
                                    button.setBackgroundResource(R.drawable.sin_006);
                                else if (PList[i].equals("6"))
                                    button.setBackgroundResource(R.drawable.sin_007);
                                else if (PList[i].equals("7"))
                                    button.setBackgroundResource(R.drawable.sin_008);
                                else if (PList[i].equals("8"))
                                    button.setBackgroundResource(R.drawable.sin_009);

                                buttons.add(button);
                            }
            mGridView.setAdapter(new ButtonOzellestirme(buttons, mColumnWidth, mColumnHeight));

        }


    }

    //puzzle'da resimlerin yerlerini  değiştirme
    private static void swap(Context context, int currentPosition, int swap) {
        String newPosition = PList[currentPosition + swap];
        PList[currentPosition + swap] = PList[currentPosition];
        PList[currentPosition] = newPosition;
        display(context);

        if (Sonuc()) {
            //Toast için bir nesne oluşturuyoruz
            Toast toast = Toast.makeText(context, "Kazandınız", Toast.LENGTH_LONG);
           //toast nesnesinin nerede gösterileceğine alt satırda karar veriyoruz
            toast.setGravity(Gravity.CENTER, 0, 0);
            //toast nesnesini ekranda gösteriyoruz.
            TextView tx=new TextView(context);
            tx.setBackgroundColor(Color.BLUE);
            tx.setTextColor(Color.BLACK);
            tx.setTextSize(20);

            Typeface typeface=Typeface.create("serif",Typeface.BOLD_ITALIC);
            tx.setTypeface(typeface);
            tx.setPadding(10,10,10,10);
            tx.setText("\"Successfull\"");
            toast.setView(tx);
            toast.show();
        }
;           // Toast.makeText(context, "Kazandınız!", Toast.LENGTH_LONG).show();
    }

    public static void resimleriTasi(Context context, String direction, int position) {

        // üst sol köşe resim
        if (position == 0) {

            if (direction.equals(right)) swap(context, position, 1);
            else if (direction.equals(down)) swap(context, position, sutun);
            else Toast.makeText(context, "Geçersiz hareket", Toast.LENGTH_SHORT).show();

            // üst merkez resim
        } else if (position > 0 && position < sutun - 1) {
            if (direction.equals(left)) swap(context, position, -1);
            else if (direction.equals(down)) swap(context, position, sutun);
            else if (direction.equals(right)) swap(context, position, 1);
            else Toast.makeText(context, "Geçersiz hareket", Toast.LENGTH_SHORT).show();

            //sağ üst köşe resim
        } else if (position == sutun - 1) {
            if (direction.equals(left)) swap(context, position, -1);
            else if (direction.equals(down)) swap(context, position, sutun);
            else Toast.makeText(context, "Geçersiz hareket", Toast.LENGTH_SHORT).show();

            // Lsol tarf resim
        } else if (position > sutun - 1 && position < boyutlandir - sutun &&
                position % sutun == 0) {
            if (direction.equals(up)) swap(context, position, -sutun);
            else if (direction.equals(right)) swap(context, position, 1);
            else if (direction.equals(down)) swap(context, position, sutun);
            else Toast.makeText(context, "Geçersiz hareket", Toast.LENGTH_SHORT).show();

            // Sağ taraf ve sağ alt köşe resmleri
        } else if (position == sutun * 2 - 1 || position == sutun * 3 - 1) {
            if (direction.equals(up)) swap(context, position, -sutun);
            else if (direction.equals(left)) swap(context, position, -1);
            else if (direction.equals(down)) {

                // Alttan ziyade aşağı doğru kaydırmak için sadece sağ taraftaki reimleri tolere eder-
                // sağ köşe resim.
                if (position <= boyutlandir - sutun - 1) swap(context, position,
                        sutun);
                else Toast.makeText(context, "Geçersiz hareket", Toast.LENGTH_SHORT).show();
            } else Toast.makeText(context, "Geçersiz hareket", Toast.LENGTH_SHORT).show();

            // Sol alt köşe resim
        } else if (position == boyutlandir - sutun) {
            if (direction.equals(up)) swap(context, position, -sutun);
            else if (direction.equals(right)) swap(context, position, 1);
            else Toast.makeText(context, "Geçersiz hareket", Toast.LENGTH_SHORT).show();

            //Alt merkez resim
        } else if (position < boyutlandir - 1 && position > boyutlandir - sutun) {
            if (direction.equals(up)) swap(context, position, -sutun);
            else if (direction.equals(left)) swap(context, position, -1);
            else if (direction.equals(right)) swap(context, position, 1);
            else Toast.makeText(context, "Geçersiz hareket", Toast.LENGTH_SHORT).show();

            // merkez resim
        } else {
            if (direction.equals(up)) swap(context, position, -sutun);
            else if (direction.equals(left)) swap(context, position, -1);
            else if (direction.equals(right)) swap(context, position, 1);
            else swap(context, position, sutun);
        }
    }

    private static boolean Sonuc() {
        boolean sonuc = false;

        for (int i = 0; i < PList.length; i++) {
            if (PList[i].equals(String.valueOf(i))) {
                sonuc = true;
            } else {
                sonuc = false;
                break;
            }
        }

        return sonuc;
    }
}

