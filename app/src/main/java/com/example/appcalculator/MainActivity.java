package com.example.appcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView textCalc;
    private Calculator calculator;
    private TextView tvResult;
    private HorizontalScrollView scroll;
    private String auxNum = "";


    List<Calculator> history = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textCalc = findViewById(R.id.etCalc);
        tvResult = findViewById(R.id.tvOperation);
        scroll = findViewById(R.id.scroll);

        calculator = new Calculator();

    }

    public void addNumber(String number){

        if(isEmpty()){
            textCalc.setText(number);
        }else {
            addIUText(number);
        }

        if(isNumber() || containsPoint() || (!calculator.getLastOperation().toString().equals(Strings.SUBTRACT) && auxNum.equals(Strings.SUBTRACT))) {
            auxNum += number;
        } else {
            setAuxNum(number);
        }

        calculator.concatValue(number);
    }

    public void writeZero(View view){ addNumber("0"); }
    public void writeOne(View view){ addNumber("1"); }
    public void writeTwo(View view){ addNumber("2"); }
    public void writeThree(View view){ addNumber("3"); }
    public void writeFour(View view){ addNumber("4"); }
    public void writeFive(View view){ addNumber("5"); }
    public void writeSix(View view){ addNumber("6"); }
    public void writeSeven(View view){ addNumber("7"); }
    public void writeEight(View view){ addNumber("8"); }
    public void writeNine(View view){ addNumber("9"); }

    public void writePoint(View view) {
        if(isNumber() && !containsPoint()) {
            addIUText(".");
            auxNum += ".";
            calculator.concatValue(".");
        }
    }

    public void clear(View view){
        textCalc.setText("0");
        tvResult.setText(R.string.init_op);
        setAuxNum("");
        calculator = new Calculator();
    }

    public void deleteLast(View view) {

        if(!isEmpty()) {

            auxNum = (isNumber() || containsPoint() || auxNum.equals(Strings.SUBTRACT)) ? auxNum.substring(0, auxNum.length() - 1) : (String) calculator.deleteLastOperation();
            calculator.deleteValue();
            textCalc.setText(textCalc.getText().toString().substring(0, textCalc.getText().toString().length() - 1));

        }

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
            calculator.addData(auxNum);
            setAuxNum(operation);
            calculator.addData(auxNum);
            calculator.concatValue(operation);
            addIUText(operation);
        }else{
            System.out.println("Error");
        }
    }

    public void divide(View view){ addOperation(Strings.DIVISION); }
    public void multiply(View view){ addOperation(Strings.MULTIPLICATY); }
    public void sum(View view){ addOperation(Strings.SUM); }
    public void percent(View view){ addOperation(Strings.PERCENT); }

    public void subtract(View view){
        if (isNumber()) {
            addOperation(Strings.SUBTRACT);
        } else if(auxNum.equals(Strings.DIVISION) || auxNum.equals(Strings.SUM) || auxNum.equals(Strings.MULTIPLICATY) ||auxNum.equals(Strings.PERCENT) || isEmpty()) {
            addNumber(Strings.SUBTRACT);
        }
    }

    public void setAuxNum(String operation){
        auxNum = operation;
    }

    public boolean isEmpty(){

        // System.out.println(calculator.getOperations().size());

        System.out.println(auxNum);
        System.out.println(calculator.getOperation());

        return auxNum.equalsIgnoreCase("") && calculator.getOperation().equalsIgnoreCase("");
    }

    public void addIUText(String data) {
        String op = textCalc.getText().toString() + data;
        textCalc.setText(op);
    }

    private void calcResult(String number) {

        try {
            calculator.addData(number);

            String operation = calculator.getOperation() + " =";
            tvResult.setText(operation);

            String result = calculator.calcOperation().toString();

            textCalc.setText(result);

            history.add(calculator);
            auxNum = result;

            calculator = new Calculator();
            calculator.concatValue(auxNum);

        } catch (Exception e) {
            Toast.makeText(this, "Ha ocurrido un error inesperado", Toast.LENGTH_LONG).show();
        }
    }

    public void showResult(View view) {
        if(!isEmpty()) {
            if (isNumber()){
                calcResult(auxNum);
            }else if(isOperation()) {
                calcResult("0");
            } else {
                Toast.makeText(this, "El ultimo número ingresado esta mal.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public boolean containsPoint() { return auxNum.contains("."); }

    private boolean isOperation() {

        switch(auxNum) {
            case Strings.SUM:
            case Strings.MULTIPLICATY:
            case Strings.DIVISION:
                return true;

            case Strings.SUBTRACT:
                return calculator.getLastOperation().equals(Strings.SUBTRACT);

            default:
                return false;
        }

    }


}