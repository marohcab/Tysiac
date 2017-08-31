package com.example.bachor.tysiac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnNew;
    Button btnContinue;
    Button btnLoad;
    Intent nowaGra;
    Intent players_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNew = (Button)findViewById(R.id.button_NewGame);
        btnContinue = (Button)findViewById(R.id.button_ContinueGame);
        btnLoad = (Button)findViewById(R.id.button_LoadGame);
        nowaGra = new Intent(getApplicationContext(), NewGame.class);
        New();
        Continue();
        Load();
    }

    private void New(){
        btnNew.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(nowaGra);
                    }
                }
        );
    }

    private void Continue(){
        btnContinue.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                }
        );
    }

    private void Load(){
        btnLoad.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                }
        );
    }
}
