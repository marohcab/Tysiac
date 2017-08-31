package com.example.bachor.tysiac;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Two_Players extends AppCompatActivity {

    Button btnBomb_1,btnBomb_2,btnBack;
    TextView txtPoints_1,txtPoints_2,txtBomb_1,txtBomb_2;

    /*  Zmienne tymczasowe */
    String bomba= "Bomba zużyta";
    int punktyP1 = 0;
    int punktyP2 = 0;
    int bomb_Player_1 = 0;
    int bomb_Player_2 = 0;
    int punktyStawka = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two__players);
        //Declaration
        txtPoints_1 = (TextView) findViewById(R.id.points_1);
        txtPoints_2 = (TextView) findViewById(R.id.points_2);
        txtBomb_1 = (TextView) findViewById(R.id.text_Bomb_1);
        txtBomb_2 = (TextView) findViewById(R.id.text_Bomb_2);
        btnBomb_1 = (Button) findViewById(R.id.button_Bomb_1);
        btnBomb_2 = (Button) findViewById(R.id.button_Bomb_2);
        btnBack = (Button)findViewById(R.id.button_TwoPlayers_Back);
        //Update Data
        txtPoints_1.setText(Integer.toString(punktyP1));
        txtPoints_2.setText(Integer.toString(punktyP2));

        Bomb_1();
        Bomb_2();
        Back();
    }

    private void Bomb_1() {
        btnBomb_1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                       bomb_Player_1++;

                        txtBomb_1.setText(bomba);
                        if(bomb_Player_1>1){
                        punktyP1-=punktyStawka;
                        txtPoints_1.setText(Integer.toString(punktyP1));
                       }
                    }
                }
        );
    }
    private void Bomb_2() {
        btnBomb_2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        bomb_Player_2++;
                            txtBomb_2.setText(bomba);
                        if(bomb_Player_2>1){
                            punktyP2-=punktyStawka;
                            txtPoints_2.setText(Integer.toString(punktyP2));
                        }
                    }
                }
        );
    }
    private void Back(){
        btnBack.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                }
        );
    }
}

