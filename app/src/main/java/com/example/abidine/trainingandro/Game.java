package com.example.abidine.trainingandro;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Abidine on 26/03/2018.
 */

public class Game extends AppCompatActivity {
    public static final Random RANDOM = new Random();
    public int score=3;

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("voulez-Vous quitter le jeux ?")
                .setCancelable(false)
                .setPositiveButton("eheh?", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                       Game.this.finish();
                    }
                })
                .setNegativeButton("bdey ", null)
                .show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        String nom = getIntent().getStringExtra(Intent.EXTRA_TEXT);
        TextView t5=(TextView)findViewById((R.id.textView5)) ;
        t5.setText("Hell0 "+ " "+ nom);
        TextView t6=(TextView)findViewById((R.id.textView6)) ;
        t6.setText(" Score " + score);
    }

    public void StartGame(View view)
    {
        int value1=0;
        int value2=0;
        int som=0;
        TextView t1=(TextView)findViewById((R.id.textView)) ;
        value1=(int)RANDOM.nextInt(6) + 1;
        value2=(int) RANDOM.nextInt(6) + 1;


       if(value1==value2)
        {
            score=score+1;
            //Toast.makeText(this,score+ 1,Toast.LENGTH_LONG).show();
        }
        else
            {
                score--;
                //Toast.makeText(this,score -1,Toast.LENGTH_LONG).show();
            }
            if(score<0)
            {
                new AlertDialog.Builder(this)
                        .setMessage("Votre score est 0, JOUER ENCORE ?")
                        .setCancelable(false)
                        .setPositiveButton("Non?", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Game.this.finish();
                            }
                        })
                        .setNegativeButton("Oui ", null)
                        .show();
                score=3;
            }

        //som=value1+value2;


        int res1 = getResources().getIdentifier("a" + value1, "drawable", "com.example.abidine.trainingandro");
        int res2 = getResources().getIdentifier("a" + value2, "drawable", "com.example.abidine.trainingandro");
        ImageView v1,v2;
        v1=(ImageView) findViewById(R.id.imageView);
        v2=(ImageView) findViewById(R.id.imageView2);
        v1.setImageResource(res1);
        v2.setImageResource(res2);
        TextView t6=(TextView)findViewById((R.id.textView6)) ;
        t6.setText(" Score " + score);
       // t1.setText(som +"/12");


    }
}
