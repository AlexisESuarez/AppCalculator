package com.example.appcalculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private String operation;

    public ArrayList<Object> getOperations() {
        return operations;
    }

    private ArrayList<Object> operations = new ArrayList<>();

    private ArrayList<Object> auxOperations = operations;

    public Calculator() {
        this.operation = "";
    }

    public void concatValue(String value){
        operation += value;
    }

    public String getOperation() {
        return operation;
    }

    public void deleteValue(){

        if(operation.length() > 0) {
            operation = operation.substring(0,operation.length()-1);
        }

    }

    public Object getLastOperation() {

        if(operation.length() > 0) {
            return operations.get(operations.size() - 1);
        } else {
            return "";
        }
    }

    public Object deleteLastOperation() {

        if(operations.size() % 2 == 0 && operations.size() != 0) {

            Object op = operations.get(operations.size() - 2);
            operations.remove(operations.size() - 2);
            operations.remove(operations.size() - 1);
            // operation = operation.substring(0, operation.length() - op.toString().length());

            return op;

        }

        return null;

        /*Object op = (operations.size() % 2 == 1) ? operations.get(operations.size() - 2) : operations.get(operations.size() - 1);
        List<Object> auxOp = operations.subList(0, operations.size() - 1);

        operations.clear();
        operations.addAll(auxOp);

        operation = operation.substring(0, operation.length() - op.toString().length());

        return op;*/
    }

    public void addData(Object data){
        operations.add(data);
    }

}
