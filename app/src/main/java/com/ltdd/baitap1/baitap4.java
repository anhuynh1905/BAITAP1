package com.ltdd.baitap1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.util.Arrays;

public class baitap4 extends AppCompatActivity {

    Button back;
    Button OK;
    TextView input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_baitap4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        back=(Button)findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(baitap4.this, MainActivity.class));
            }
        });

        back=(Button)findViewById(R.id.button_OK);

        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                input = (TextView) findViewById(R.id.array);
                String conv_int=input.getText().toString();

                int[] arr = Arrays.stream(conv_int.split(","))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                Log.d("so nguyen: ", Arrays.toString(arr));
            }
        });




    }
}