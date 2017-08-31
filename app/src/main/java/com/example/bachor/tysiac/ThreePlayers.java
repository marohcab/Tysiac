package com.example.bachor.tysiac;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThreePlayers extends AppCompatActivity {

    DatabaseHelper myDb;
    Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_players);
        myDb = new DatabaseHelper(this);
        btn3 = (Button)findViewById(R.id.button3);
        ViewAll();

    }

    public void ViewAll(){
        btn3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Cursor res = myDb.getAllData();
                        if(res.getCount() == 0){
                            // show message
                            showMessage("Error", "Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while(res.moveToNext()){
                            buffer.append("ID :" + res.getString(0) + "\n");
                            buffer.append("Data :" + res.getString(1) + "\n");
                            buffer.append("Ilosc :" + res.getString(2) + "\n");
                            buffer.append("Runda :" + res.getString(3) + "\n");
                            buffer.append("Kolej :" + res.getString(4) + "\n");
                            buffer.append("nazwa gracz1 :" + res.getString(5) + "\n");
                            buffer.append("punkty gracz1 :" + res.getString(6) + "\n");
                            buffer.append("nazwa gracz2 :" + res.getString(7) + "\n");
                            buffer.append("punkty gracz2 :" + res.getString(8) + "\n");
                            buffer.append("nazwa gracz3 :" + res.getString(9) + "\n");
                            buffer.append("punkty gracz3 :" + res.getString(10) + "\n");
                            buffer.append("nazwa gracz4 :" + res.getString(11) + "\n");
                            buffer.append("punkty gracz4 :" + res.getString(12) + "\n");
                            buffer.append("bomba gracz1 :" + res.getString(13) + "\n");
                            buffer.append("bomba gracz1 :" + res.getString(14) + "\n");
                            buffer.append("bomba gracz1 :" + res.getString(15) + "\n");
                            buffer.append("bomba gracz1 :" + res.getString(16) + "\n\n");
                        }

                        //show all data
                        showMessage("Data", buffer.toString());
                    }


                }
        );
    }

    public void showMessage(String title, String message){
        AlertDialog.Builder builder  = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
