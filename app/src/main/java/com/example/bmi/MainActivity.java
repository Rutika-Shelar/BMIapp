package com.example.bmi;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    EditText etHeight, etWeight;
    Button btnCalculate;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etHeight = findViewById(R.id.etHeight);
        etWeight = findViewById(R.id.etWeight);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);

        btnCalculate.setOnClickListener(v -> {
            String heightStr = etHeight.getText().toString();
            String weightStr = etWeight.getText().toString();

            if(heightStr.isEmpty() || weightStr.isEmpty()) {
                Toast.makeText(this, "Please enter both fields", Toast.LENGTH_SHORT).show();
                return;
            }

            float heightInches = Float.parseFloat(heightStr);
            float weight = Float.parseFloat(weightStr);


            float heightMeters = heightInches * 0.0254f;

            float bmi = weight / (heightMeters * heightMeters);

            String category;
            if(bmi < 18.5) {
                category = "Underweight";
            } else if(bmi < 24.9) {
                category = "Normal weight";
            } else if(bmi < 29.9) {
                category = "Overweight";
            } else {
                category = "Obese";
            }

            tvResult.setText(String.format("BMI: %.1f\nCategory: %s", bmi, category));
        });
    }
}
