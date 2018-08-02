package com.example.lenovo2.sayilaraklimda;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    int count;
    Button btn;
    SharedPreferences sp;

    @Override
    protected void onPause() {
        SharedPreferences.Editor editor =sp.edit();
        editor.putInt("count anahtarı",count);
        editor.commit();
        super.onPause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=(Button) findViewById(R.id.button);
        sp= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        count=sp.getInt("count anahtarı",0);
        btn.setText(""+count);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count ++;
                btn.setText(""+count);
            }
        });
    }
}
