package com.example.bachor.tysiac;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewGame extends AppCompatActivity {

    Button btnStart, btnBack;

    EditText nazwaG1, nazwaG2, nazwaG3, nazwaG4;


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

    }

    private byte iluGraczy() {
        byte wynik=0;

            if(nazwaG1.getText().toString()!="")
                wynik++;
            if(nazwaG2.getText().toString()!="")
                wynik++;
            if(nazwaG3.getText().toString()!="")
                wynik++;
            if(nazwaG4.getText().toString()!="")
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

    private void Start(byte gracze) {
        switch (gracze){
            case 0:
            {showMessage("Błąd", "Minimalna ilość graczy to: 2");}
            case 1:
            {showMessage("Błąd", "Minimalna ilość graczy to: 2");}
            case 2:
            {showMessage("Błąd", "Minimalna ilość graczy to: 2");}
            case 3:
            {}
            case 4:
            {}
            default:
            {}

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
