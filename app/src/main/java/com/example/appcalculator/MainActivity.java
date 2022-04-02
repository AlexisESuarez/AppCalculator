package com.example.appcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    double num1 = 0.0f;
    double num2 = 0.0f;
    String operation = "";
    TextView textCalc;

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
    private Calculator calculator;
    private String auxNum = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textCalc = findViewById(R.id.etCalc);

        calculator = new Calculator();

    }

    public void addNumber(String number){

        if(calculator.getOperation().equals("")){
            textCalc.setText(number);
        }else {
            addText(number);
        }

        if(isNumber() || auxNum.contains(".")) {
            auxNum += number;
        } else {
            setAuxNum(number);
        }

        calculator.concatValue(number);
    }

    public void writeCero(View view){
        addNumber("0");
    }
    public void writeOne(View view){
       addNumber("1");
    }
    public void writeTwo(View view){
        addNumber("2");
    }
    public void writeThree(View view){
        addNumber("3");
    }
    public void writeFour(View view){
        addNumber("4");
    }
    public void writeFive(View view){ addNumber("5"); }
    public void writeSix(View view){
        addNumber("6");
    }
    public void writeSeven(View view){ addNumber("7"); }
    public void writeEight(View view){ addNumber("8"); }
    public void writeNine(View view){
        addNumber("9");
    }

    public void clear(View view){
        textCalc.setText("0");
        num1 = 0;
        num2 = 0;
        operation = "";
    }

    public boolean isNumber(){
        try {
            Double.parseDouble(auxNum);
            return true;
        }catch(NumberFormatException e) {
            return false;
        }
    }

    public void addOperation(String operation) {
        if(isNumber()){
            calculator.addData(Double.parseDouble(auxNum));
            setAuxNum(operation);
            calculator.addData(auxNum);
            addText(operation);
        }else{
            System.out.println("Error");
        }
    }

    public void divide(View view){ addOperation(Strings.DIVISION); }
    public void multiply(View view){ addOperation(Strings.MULTIPLICATY); }
    public void sum(View view){ addOperation(Strings.SUM); }
    public void subtract(View view){ addOperation(Strings.SUBTRACT); }


    public void setAuxNum(String operation){
        auxNum = operation;
    }

    public boolean isEmpty(){return num1 == 0f;}

    public void same(View view){
        /*num2 = Float.parseFloat(editTextTextMultiLine.getText().toString());
        if (operation.equals("/")){
            if (num2 == 0.0f){
                editTextTextMultiLine.setText("0");
                Toast.makeText(this, "OPERACION NO VALIDA", Toast.LENGTH_SHORT).show();
            }else {
                Double result = num1 / num2;
                editTextTextMultiLine.setText(result + "");
            }
        }else if (operation.equals("*")){
            float result = num1*num2;
            editTextTextMultiLine.setText(result + "");
        }else if (operation.equals("+")){
            float result = num1+num2;
            editTextTextMultiLine.setText(result + "");
        }else if (operation.equals("-")){
            float result = num1-num2;
            editTextTextMultiLine.setText(result + "");
        }*/

        num1 = 0.0f;
        num2 = 0.0f;
        operation = "";
    }

    public void addText(String data) {
        String op = textCalc.getText().toString() + data;
        textCalc.setText(op);
    }


}