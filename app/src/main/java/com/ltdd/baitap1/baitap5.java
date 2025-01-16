package com.ltdd.baitap1;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;

public class baitap5 extends AppCompatActivity {

    Button back;
    EditText text_in;
    TextView text_out;
    Button Toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_baitap5);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        back=(Button)findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(baitap5.this, MainActivity.class));
            }
        });

        text_out = (TextView) findViewById(R.id.text_out);
        text_in = (EditText) findViewById(R.id.text_in);
        text_in.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                text_out.setText(text_in.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        back=(Button) findViewById(R.id.button_Toast);
        back.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String conv_int=text_out.getText().toString();

                double[] arr = Arrays.stream(conv_int.split(","))
                        .mapToDouble(Double::parseDouble)
                        .toArray();
                double[] result = checkPerfectSquare(arr);

                Toast toast = android.widget.Toast.makeText(baitap5.this, "cac so chinh phuong" + Arrays.toString(result), android.widget.Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }

    double[] checkPerfectSquare(double[] x)
    {
        double[] result = new double[x.length];
        int j=0;
        for (double v : x) {
            if (Math.sqrt(v) - Math.floor(Math.sqrt(v)) == 0 && (v > 1))
                result[j++] = v;
        }
        return result;
    }
}