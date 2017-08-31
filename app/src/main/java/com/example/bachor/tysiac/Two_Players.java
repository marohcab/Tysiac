package com.example.bachor.tysiac;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Two_Players extends AppCompatActivity {

    Button btnBomb_1;
    Button btnBomb_2;
    TextView points_1,points_2,txt_bomb_1,txt_bomb_2;
    String test_string = "test";
    int test_int = 1;
    int bomb_Player_1 = 0;
    int bomb_Player_2 = 0;
    Button btnTest;
    EditText edit_test;
    TextView txt_test;
    int dupa2=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two__players);
        TextView points1 = (TextView) findViewById(R.id.points_1);
        TextView points2 = (TextView) findViewById(R.id.points_2);
        TextView txt_bomb_1 = (TextView) findViewById(R.id.text_Bomb_1);
        TextView txt_bomb_2 = (TextView) findViewById(R.id.text_Bomb_2);
        points1.setText(Integer.toString(test_int));
        points2.setText(Integer.toString(test_int));
        btnBomb_1 = (Button) findViewById(R.id.button_Bomb_1);
        btnBomb_2 = (Button) findViewById(R.id.button_Bomb_2);
        btnTest = (Button)findViewById(R.id.button_test);
        txt_test = (TextView)findViewById(R.id.text_test);
        edit_test = (EditText)findViewById(R.id.editText_test);
        Bomb_1();
        Bomb_2();
        dupa();
    }

    private void Bomb_1() {
        btnBomb_1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                       bomb_Player_1++;
                        if(bomb_Player_1>0){
                        txt_bomb_1.setText(Integer.toString(bomb_Player_1));
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
                        if(bomb_Player_2>0){
                            txt_bomb_2.setText(Integer.toString(bomb_Player_2));

                        }
                    }
                }
        );
    }
    private void dupa(){
        btnTest.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dupa2++;
                        txt_test.setText(String.valueOf(dupa2));
                    }
                }
        );
    }
}

