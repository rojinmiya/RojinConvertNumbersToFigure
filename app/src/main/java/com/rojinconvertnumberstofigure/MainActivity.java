package com.rojinconvertnumberstofigure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText etNumber;
    private Button btnConvert;
    private TextView tvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumber = findViewById(R.id.etNumber);
        btnConvert = findViewById(R.id.btnConvert);
        tvOutput = findViewById(R.id.tvOutput);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    String numberz = etNumber.getText().toString();
                    try {
                        final int number = Integer.parseInt(numberz);
                        String returnz = RojinConvert.convertNumbersInFigure(number);
                        tvOutput.setText(returnz);
                    } catch (NumberFormatException e) {

                    }

                }
            }
        });


    }
    private boolean validate() {
        if (TextUtils.isEmpty(etNumber.getText().toString())) {
            etNumber.setError("Please enter numbers.");
            etNumber.requestFocus();
            return false;

        }
        return true;
    }
}

