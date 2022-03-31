package com.example.appcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    float num1 = 0.0f;
    float num2 = 0.0f;
    String operation = "";
    TextView editTextTextMultiLine;


    private ImageButton bAc;
    private ImageButton bRestar;
    private ImageButton bDividir;
    private ImageButton bMultiplicar;
    private ImageButton bPorcentaje;
    private ImageButton bIgual;
    private ImageButton bBorrar;
    private ImageButton bPunto;
    private ImageButton bFn;
    private ImageButton b0;
    private ImageButton b1;
    private ImageButton b2;
    private ImageButton b3;
    private ImageButton b4;
    private ImageButton b5;
    private ImageButton b6;
    private ImageButton b7;
    private ImageButton b8;
    private ImageButton b9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTextMultiLine = findViewById(R.id.editTextTextMultiLine);
    }

    public void writeOne(View view){
        num1 = Float.parseFloat(editTextTextMultiLine.getText().toString());
        if (num1 == 0.0f){
            editTextTextMultiLine.setText("1");
        }else{
            editTextTextMultiLine.setText(editTextTextMultiLine.getText() + "1");
        }
    }
    public void writeTwo(View view){
        num1 = Float.parseFloat(editTextTextMultiLine.getText().toString());
        if (num1 == 0.0f){
            editTextTextMultiLine.setText("2");
        }else{
            editTextTextMultiLine.setText(editTextTextMultiLine.getText() + "2");
        }
    }
    public void writeThree(View view){
        num1 = Float.parseFloat(editTextTextMultiLine.getText().toString());
        if (num1 == 0.0f){
            editTextTextMultiLine.setText("3");
        }else{
            editTextTextMultiLine.setText(editTextTextMultiLine.getText() + "3");
        }
    }
    public void writeFour(View view){
        num1 = Float.parseFloat(editTextTextMultiLine.getText().toString());
        if (num1 == 0.0f){
            editTextTextMultiLine.setText("4");
        }else{
            editTextTextMultiLine.setText(editTextTextMultiLine.getText() + "4");
        }
    }
    public void writeFive(View view){
        num1 = Float.parseFloat(editTextTextMultiLine.getText().toString());
        if (num1 == 0.0f){
            editTextTextMultiLine.setText("5");
        }else{
            editTextTextMultiLine.setText(editTextTextMultiLine.getText() + "5");
        }
    }
    public void writeSix(View view){
        num1 = Float.parseFloat(editTextTextMultiLine.getText().toString());
        if (num1 == 0.0f){
            editTextTextMultiLine.setText("6");
        }else{
            editTextTextMultiLine.setText(editTextTextMultiLine.getText() + "6");
        }
    }
    public void writeSeven(View view){
        num1 = Float.parseFloat(editTextTextMultiLine.getText().toString());
        if (num1 == 0.0f){
            editTextTextMultiLine.setText("7");
        }else{
            editTextTextMultiLine.setText(editTextTextMultiLine.getText() + "7");
        }
    }
    public void writeEigth(View view){
        num1 = Float.parseFloat(editTextTextMultiLine.getText().toString());
        if (num1 == 0.0f){
            editTextTextMultiLine.setText("8");
        }else{
            editTextTextMultiLine.setText(editTextTextMultiLine.getText() + "8");
        }
    }
    public void writeNine(View view){
        num1 = Float.parseFloat(editTextTextMultiLine.getText().toString());
        if (num1 == 0.0f){
            editTextTextMultiLine.setText("9");
        }else{
            editTextTextMultiLine.setText(editTextTextMultiLine.getText() + "9");
        }
    }

    public void clear(View view){
        editTextTextMultiLine.setText("0");
        num1 = 0.0f;
        num2 = 0.0f;
        operation = "";
    }

}