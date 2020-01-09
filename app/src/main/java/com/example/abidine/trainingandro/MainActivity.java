package com.example.abidine.trainingandro;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("voulez-vous quitter??")
                .setCancelable(false)
                .setPositiveButton("Oui?", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("Non ", null)
                .show();
    }

    public void login(View view)
    {

        TextView v1;
        v1 = (TextView) findViewById(R.id.textView);
        EditText t1,t2;//t1 =username  t2 =pass
        String name= "";
        String pass="";
        String namea= "user";
        String passa="123";
        t1=(EditText)findViewById(R.id.editText);
        t2=(EditText)findViewById(R.id.editText2);
        name=t1.getText().toString();
        pass=t2.getText().toString();
        name = name.toLowerCase();
        if(name.equals(namea) && pass.equals(passa))
        {   t2.setText("");

            //v1.setText("welcome"+ namea);
            //System.out.println("welcome" + namea);
           //setContentView(R.layout.game);
           // Intent intent= new Intent(this,Game.class);

            //Intent intent=new Intent(MainActivity.this,Game.class);
            Toast.makeText(MainActivity.this," Welcome "+" "+ namea,Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, Game.class);
            i.putExtra(Intent.EXTRA_TEXT, namea);
            startActivity(i);

            //MainActivity.this.finish();
        }

        else v1.setText("invalid login");
            t1.setText("");
            t2.setText("");

    }
}
