package com.example.bachor.tysiac;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewGame extends AppCompatActivity {

    Button btnStart, btnBack, button234;

    EditText nazwaG1, nazwaG2, nazwaG3, nazwaG4;


Intent intent;
    Intent czterech;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);
        nazwaG1 = (EditText)findViewById(R.id.edit_NazwaGracz1);
        nazwaG2 = (EditText)findViewById(R.id.edit_NazwaGracz2);
        nazwaG3 = (EditText)findViewById(R.id.edit_NazwaGracz3);
        nazwaG4 = (EditText)findViewById(R.id.edit_NazwaGracz4);
        btnStart = (Button)findViewById(R.id.button_Start);
        btnBack = (Button)findViewById(R.id.button_Back);
       // gracze2 = new Intent(this), Two_Players.class);
        Back();
        pressStart();
        czterech = new Intent(this, Two_Players.class);


    }



    private byte iluGraczy() {
        byte wynik=0;

            if(nazwaG1.length()!=0)
                wynik++;
            if(nazwaG2.length()!=0)
                wynik++;
            if(nazwaG3.length()!=0)
                wynik++;
            if(nazwaG4.length()!=0)
                wynik++;


        return wynik;

    }

    private void pressStart(){
        btnStart.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Start(iluGraczy());
                    }
                }
        );
    }
    private void Back() {
        btnBack.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                }
        );
    }

    private void Start(byte gracze) {
        switch (gracze){
            case 0:
                showMessage("Błąd", "Minimalna ilość graczy to: 0");
                break;
            case 1:
                showMessage("Błąd", "Minimalna ilość graczy to: 1");
                break;
            case 2:
                startActivity(czterech);
                break;
            case 3:
                showMessage("Błąd", "Minimalna ilość graczy to: 3");
                break;
            case 4:
                //showMessage("Błąd", "Minimalna ilość graczy to: 4");
                startActivity(czterech);
                break;
            default:
            showMessage("Błąd", "Cholera wie jaki");

        }



    }

    private void showMessage(String title, String message){
        AlertDialog.Builder builder  = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
