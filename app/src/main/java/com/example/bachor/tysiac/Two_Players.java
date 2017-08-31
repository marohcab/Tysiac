package com.example.bachor.tysiac;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Two_Players extends AppCompatActivity {

    Button btnBomb_1, btnBomb_2, btnBack;
    TextView txtPoints_1, txtPoints_2, txtBomb_1, txtBomb_2,txtName_1,txtName_2,txtLicytacja,txtRunda;

    /*  Zmienne tymczasowe */
    String bomba = "Bomba zużyta";
    int punktyP1 = 0;
    int punktyP2 = 0;
    int bomb_Player_1 = 0;
    int bomb_Player_2 = 0;
    int punktyStawka = 100;
    int runda = 0;
    String nameP1 = "Gracz 1";
    String nameP2 = "Gracz 2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two__players);
        //Declaration
        txtPoints_1 = (TextView) findViewById(R.id.text_TwoPlayers_Points1);
        txtPoints_2 = (TextView) findViewById(R.id.text_TwoPlayers_Points2);
        txtBomb_1 = (TextView) findViewById(R.id.text_TwoPlayers_Bomb1);
        txtBomb_2 = (TextView) findViewById(R.id.text_TwoPlayers_Bomb2);
        txtName_1 = (TextView) findViewById(R.id.text_TwoPlayers_Name1);
        txtName_2 = (TextView) findViewById(R.id.text_TwoPlayers_Name2);
        txtLicytacja = (TextView) findViewById(R.id.text_TwoPlayers_Licytacja);
        txtRunda = (TextView) findViewById(R.id.text_TwoPlayers_Runda);
        btnBomb_1 = (Button) findViewById(R.id.button_TwoPlayers_Bomb1);
        btnBomb_2 = (Button) findViewById(R.id.button_TwoPlayers_Bomb2);
        btnBack = (Button) findViewById(R.id.button_TwoPlayers_Back);
        //Update Data
        txtPoints_1.setText(Integer.toString(punktyP1));
        txtPoints_2.setText(Integer.toString(punktyP2));
        txtName_1.setText(nameP1);
        txtName_2.setText(nameP2);
        txtLicytacja.setText(Integer.toString(punktyStawka));
        txtRunda.setText(Integer.toString(runda));

        Bomb_1();
        Bomb_2();
        Back();
    }

    private void Bomb_1() {
        btnBomb_1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showMessageP1("Czy na pewno chcesz użyć bomby?", "Yup!", "Nope!");
                    }
                }
        );


    }

    private void Bomb_2() {
        btnBomb_2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showMessageP2("Czy na pewno chcesz użyć bomby?", "Yup!", "Nope!");
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

    private void showMessageP1(String message, String butt1, String butt2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message).setPositiveButton(butt1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Two_Players.this, "BOOOOOM!", Toast.LENGTH_LONG).show();
                bomb_Player_1++;
                txtBomb_1.setText(bomba);
                if (bomb_Player_1 > 1) {
                    punktyP1 -= punktyStawka;
                    txtPoints_1.setText(Integer.toString(punktyP1));
                }
            }
        }).setNegativeButton(butt2, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.show();
    }
    private void showMessageP2(String message, String butt1, String butt2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message).setPositiveButton(butt1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Two_Players.this, "BOOOOOM!", Toast.LENGTH_LONG).show();
                bomb_Player_2++;
                txtBomb_2.setText(bomba);
                if (bomb_Player_2 > 1) {
                    punktyP2 -= punktyStawka;
                    txtPoints_2.setText(Integer.toString(punktyP2));
                }
            }
        }).setNegativeButton(butt2, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.show();
    }

}



