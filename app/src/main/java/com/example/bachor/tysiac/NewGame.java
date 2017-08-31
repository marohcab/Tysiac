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
    EditText nazwaG1, nazwaG2, nazwaG3, nazwaG4;
    DatabaseHelper myDb;
    Intent czterech, trzech, dwoch;
    byte ile=0,g1u=0,g2u=0,g3u=0,g4u=0;
    String gracz1, gracz2, gracz3, gracz4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);
        myDb = new DatabaseHelper(this);

        nazwaG1 = (EditText)findViewById(R.id.edit_NazwaGracz1);
        nazwaG2 = (EditText)findViewById(R.id.edit_NazwaGracz2);
        nazwaG3 = (EditText)findViewById(R.id.edit_NazwaGracz3);
        nazwaG4 = (EditText)findViewById(R.id.edit_NazwaGracz4);

        btnStart = (Button)findViewById(R.id.button_Start);
        btnBack = (Button)findViewById(R.id.button_Back);

        dwoch = new Intent(this, Two_Players.class);
        trzech = new Intent(this, ThreePlayers.class);
        czterech = new Intent(this, FourPlayers.class);

        Back();
        pressStart();
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
                startActivity(dwoch);
                break;
            case 1:
                showMessage("Błąd", "Minimalna ilość graczy to: 2");
                break;
            case 2:
                while(ile==0){
                    if(nazwaG1.length()!=0){
                        gracz1=nazwaG1.getText().toString();
                        g1u=1;
                        ile=1;
                    }
                    if(nazwaG2.length()!=0){
                        gracz1=nazwaG2.getText().toString();
                        g2u=1;
                        ile=1;
                    }
                    if(nazwaG3.length()!=0){
                        gracz1=nazwaG3.getText().toString();
                        g2u=1;
                        ile=1;
                    }
                    if(nazwaG4.length()!=0){
                        gracz1=nazwaG4.getText().toString();
                        g2u=1;
                        ile=1;
                    }
                }
                while (ile == 1) {
                    if((nazwaG1.length()!=0)||(g1u==0)){
                        gracz2=nazwaG1.getText().toString();
                        ile=2;
                    }
                    if((nazwaG2.length()!=0)||(g2u==0)){
                        gracz2=nazwaG2.getText().toString();
                        ile=2;
                    }
                    if((nazwaG3.length()!=0)||(g3u==0)){
                        gracz2=nazwaG3.getText().toString();
                        ile=2;
                    }
                    if((nazwaG4.length()!=0)||(g4u==0)){
                        gracz2=nazwaG4.getText().toString();
                        ile=2;
                    }
                }
                boolean isInserted = myDb.insertData("",0,0,"",gracz1,0,gracz2,0,"",0,"",0,0,0,0,0);
                if(isInserted==true){
                    Toast.makeText(NewGame.this, "Let the battle... BEGIN!", Toast.LENGTH_LONG).show();
                    startActivity(dwoch);
                }
                else
                {
                    Toast.makeText(NewGame.this, "Coś nie działa...", Toast.LENGTH_LONG).show();
                }
                break;
            case 3:
                while(ile==0){
                    if(nazwaG1.length()!=0){
                        gracz1=nazwaG1.getText().toString();
                        g1u=1;
                        ile=1;
                    }
                    if(nazwaG2.length()!=0){
                        gracz1=nazwaG2.getText().toString();
                        g2u=1;
                        ile=1;
                    }
                    if(nazwaG3.length()!=0){
                        gracz1=nazwaG3.getText().toString();
                        g3u=1;
                        ile=1;
                    }
                    if(nazwaG4.length()!=0){
                        gracz1=nazwaG4.getText().toString();
                        g4u=1;
                        ile=1;
                    }
                }
                while (ile == 1) {
                    if((nazwaG1.length()!=0)||(g1u==0)){
                        gracz2=nazwaG1.getText().toString();
                        g1u=1;
                        ile=2;
                    }
                    if((nazwaG2.length()!=0)||(g2u==0)){
                        gracz2=nazwaG2.getText().toString();
                        g2u=1;
                        ile=2;
                    }
                    if((nazwaG3.length()!=0)||(g3u==0)){
                        gracz2=nazwaG3.getText().toString();
                        g3u=1;
                        ile=2;
                    }
                    if((nazwaG4.length()!=0)||(g4u==0)){
                        gracz2=nazwaG4.getText().toString();
                        g4u=1;
                        ile=2;
                    }
                }
                while (ile == 2) {
                    if((nazwaG1.length()!=0)||(g1u==0)){
                        gracz3=nazwaG1.getText().toString();
                        g1u=1;
                        ile=3;
                    }
                    if((nazwaG2.length()!=0)||(g2u==0)){
                        gracz3=nazwaG2.getText().toString();
                        g2u=1;
                        ile=3;
                    }
                    if((nazwaG3.length()!=0)||(g3u==0)){
                        gracz3=nazwaG3.getText().toString();
                        g3u=1;
                        ile=3;
                    }
                    if((nazwaG4.length()!=0)||(g4u==0)){
                        gracz3=nazwaG4.getText().toString();
                        g4u=1;
                        ile=3;
                    }
                }
                boolean isInserted2 = myDb.insertData("",0,0,"",gracz1,0,gracz2,0,gracz3,0,"",0,0,0,0,0);
                if(isInserted2==true){
                    Toast.makeText(NewGame.this, "Let the battle... BEGIN!", Toast.LENGTH_LONG).show();
                    startActivity(trzech);
                }
                else
                {
                    Toast.makeText(NewGame.this, "Coś nie działa...", Toast.LENGTH_LONG).show();
                }
                break;
            case 4:
                while(ile==0){
                    if(nazwaG1.length()!=0){
                        gracz1=nazwaG1.getText().toString();
                        g1u=1;
                        ile=1;
                    }
                    if(nazwaG2.length()!=0){
                        gracz1=nazwaG2.getText().toString();
                        g2u=1;
                        ile=1;
                    }
                    if(nazwaG3.length()!=0){
                        gracz1=nazwaG3.getText().toString();
                        g3u=1;
                        ile=1;
                    }
                    if(nazwaG4.length()!=0){
                        gracz1=nazwaG4.getText().toString();
                        g4u=1;
                        ile=1;
                    }
                }
                while (ile == 1) {
                    if((nazwaG1.length()!=0)||(g1u==0)){
                        gracz2=nazwaG1.getText().toString();
                        g1u=1;
                        ile=2;
                    }
                    if((nazwaG2.length()!=0)||(g2u==0)){
                        gracz2=nazwaG2.getText().toString();
                        g2u=1;
                        ile=2;
                    }
                    if((nazwaG3.length()!=0)||(g3u==0)){
                        gracz2=nazwaG3.getText().toString();
                        g3u=1;
                        ile=2;
                    }
                    if((nazwaG4.length()!=0)||(g4u==0)){
                        gracz2=nazwaG4.getText().toString();
                        g4u=1;
                        ile=2;
                    }
                }
                while (ile == 2) {
                    if((nazwaG1.length()!=0)||(g1u==0)){
                        gracz3=nazwaG1.getText().toString();
                        g1u=1;
                        ile=3;
                    }
                    if((nazwaG2.length()!=0)||(g2u==0)){
                        gracz3=nazwaG2.getText().toString();
                        g2u=1;
                        ile=3;
                    }
                    if((nazwaG3.length()!=0)||(g3u==0)){
                        gracz3=nazwaG3.getText().toString();
                        g3u=1;
                        ile=3;
                    }
                    if((nazwaG4.length()!=0)||(g4u==0)){
                        gracz3=nazwaG4.getText().toString();
                        g4u=1;
                        ile=3;
                    }
                }
                while (ile == 3) {
                    if((nazwaG1.length()!=0)||(g1u==0)){
                        gracz4=nazwaG1.getText().toString();
                        g1u=1;
                        ile=4;
                    }
                    if((nazwaG2.length()!=0)||(g2u==0)){
                        gracz4=nazwaG2.getText().toString();
                        g2u=1;
                        ile=4;
                    }
                    if((nazwaG3.length()!=0)||(g3u==0)){
                        gracz4=nazwaG3.getText().toString();
                        g3u=1;
                        ile=4;
                    }
                    if((nazwaG4.length()!=0)||(g4u==0)){
                        gracz4=nazwaG4.getText().toString();
                        g4u=1;
                        ile=4;
                    }
                }
                boolean isInserted3 = myDb.insertData("",0,0,"",gracz1,0,gracz2,0,gracz3,0,gracz4,0,0,0,0,0);
                if(isInserted3==true){
                    Toast.makeText(NewGame.this, "Let the battle... BEGIN!", Toast.LENGTH_LONG).show();
                    startActivity(czterech);
                }
                else
                {
                    Toast.makeText(NewGame.this, "Coś nie działa...", Toast.LENGTH_LONG).show();
                }
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

    private void showMessage2(String message, String butt1, String butt2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message).setPositiveButton(butt1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
    }
}
