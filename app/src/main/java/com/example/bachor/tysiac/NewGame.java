package com.example.bachor.tysiac;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewGame extends AppCompatActivity {

    Button btnStart, btnBack;
    EditText editG1, editG2, editG3, editG4;
    DatabaseHelper myDb;
    Intent czterech, trzech, dwoch;
    byte ile=0,g1u=0,g2u=0,g3u=0,g4u=0;
    public String gracz1, gracz2, gracz3, gracz4;
    DataBase dane;
    String[] nazwaGracza;
    EditText[] editGracze;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);
        myDb = new DatabaseHelper(this);
        dane = new DataBase(this);
        nazwaGracza = new String[4];

        editG1 = (EditText)findViewById(R.id.edit_NazwaGracz1);
        editG2 = (EditText)findViewById(R.id.edit_NazwaGracz2);
        editG3 = (EditText)findViewById(R.id.edit_NazwaGracz3);
        editG4 = (EditText)findViewById(R.id.edit_NazwaGracz4);

        btnStart = (Button)findViewById(R.id.button_Start);
        btnBack = (Button)findViewById(R.id.button_Back);

        dwoch = new Intent();
        dwoch.setClass(getApplicationContext(), Two_Players.class);
        trzech = new Intent();
        trzech.setClass(getApplicationContext(), ThreePlayers.class);
        czterech = new Intent();
        czterech.setClass(getApplicationContext(), FourPlayers.class);

        Back();
        pressStart();
    }



    private void pressStart(){
        btnStart.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Start();
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

    private void Start() {
                nazwaGracza[0]=editG1.getText().toString();
                nazwaGracza[1]=editG2.getText().toString();
                nazwaGracza[2]=editG3.getText().toString();
                nazwaGracza[3]=editG4.getText().toString();
                //byte iluGraczy=LiczGraczy(nazwaGracza);
                // byte iluGraczy =2;
                byte iluGraczy = policzIch(nazwaGracza);
                posortuj(nazwaGracza);

                switch(iluGraczy){
                    case 0:
                        showMessage("Błąd", "Minimalna ilość graczy to: 2");
                        break;
                    case 1:
                        showMessage("Błąd", "Minimalna ilość graczy to: 2");
                        break;
                    case 2:
                        boolean isInserted = dane.insertData(iluGraczy, "", 1, "", "", nazwaGracza[0], 0, 0, nazwaGracza[1], 0, 0, nazwaGracza[2], 0, 0, nazwaGracza[3], 0, 0);
                        if(isInserted){
                            Toast.makeText(NewGame.this, "Let the battle... BEGIN!", Toast.LENGTH_LONG).show();
                            startActivity(dwoch);
                        } else {
                            Toast.makeText(NewGame.this, "Coś nie działa...", Toast.LENGTH_LONG).show();
                        }
                        break;
                    case 3:
                        boolean isInserted2 = dane.insertData(iluGraczy, "", 1, "", "", nazwaGracza[0], 0, 0, nazwaGracza[1], 0, 0, nazwaGracza[2], 0, 0, nazwaGracza[3], 0, 0);
                        if(isInserted2){
                            Toast.makeText(NewGame.this, "Let the battle... BEGIN!", Toast.LENGTH_LONG).show();
                            startActivity(trzech);
                        } else {
                            Toast.makeText(NewGame.this, "Coś nie działa...", Toast.LENGTH_LONG).show();
                        }
                        break;
                    case 4:
                        boolean isInserted3 = dane.insertData(iluGraczy, "", 1, "", "", nazwaGracza[0], 0, 0, nazwaGracza[1], 0, 0, nazwaGracza[2], 0, 0, nazwaGracza[3], 0, 0);
                        if(isInserted3){
                            Toast.makeText(NewGame.this, "Let the battle... BEGIN!", Toast.LENGTH_LONG).show();
                            startActivity(czterech);
                        } else {
                            Toast.makeText(NewGame.this, "Coś nie działa...", Toast.LENGTH_LONG).show();
                        }
                        break;
                    default:
                        showMessage("Błąd", "Cholera wie jaki");
                        break;
                }


               // boolean isInserted = myDb.insertData("",0,0,"",gracz1,0,gracz2,0,"",0,"",0,0,0,0,0);









    }






    private void showMessage(String title, String message){
        AlertDialog.Builder builder  = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    private void showMessage2(String message, String butt1, String butt2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message).setPositiveButton(butt1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
    }







    private static void sortuj(String[] gracze){
        String temp;
        for (int i=gracze.length - 1; i != 0; i--){
            for(int j=gracze.length-1; j != 0; j--){
                if(gracze[i].length()==0){
                    temp = gracze[j-1];
                    gracze[j-1]=gracze[j];
                    gracze[j]=temp;
                }
            }
        }

    }

    private byte LiczGraczy(String[] gracze) {
        byte wynik=0;
        for(int i=0; i<gracze.length; i++){
            if(gracze[i].length()!=0){
                wynik++;}

        }
        return wynik;

    }

    private static byte policzIch(String[] dupa){
        byte dupa2=0;
        for(int i=0; i<dupa.length; i++){
            if(dupa[i].length()!=0){
                dupa2++;
            }
        }
        return dupa2;
    }

    private static void posortuj(String[] gracze){
        for(int i=0; i<gracze.length; i++){
            for(int j=0; j<gracze.length-1; j++){
                String temp="";
                if(gracze[j].length()==0){
                    temp=gracze[j+1];
                    gracze[j+1]=gracze[j];
                    gracze[j]=temp;
                }

            }
        }
    }
}
