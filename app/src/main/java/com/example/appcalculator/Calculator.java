package com.example.appcalculator;

import java.util.ArrayList;

public class Calculator {



    private String operation;

    private ArrayList<Object> operations = new ArrayList<>();

    private ArrayList<Object> auxOperations = operations;

    private final char SUM = '+';
    private final char SUBTRACT = '-';
    private final char  MULTIPLICATY = '*';
    private final char DIVISION = '/';


    public void concatValue(String value){

        operation += value;

    }

    public String getOperation() {

        return operation;
    }

    public void deleteValue(){

        operation = operation.substring(0,operation.length()-1);

    }

    public void addData(Object data){

            operations.add(data);

    }



}
