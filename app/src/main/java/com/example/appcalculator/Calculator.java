package com.example.appcalculator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Calculator {

    private String operation;

    public ArrayList<Object> getOperations() {
        return operations;
    }

    private ArrayList<Object> operations = new ArrayList<>();

    private ArrayList<Object> auxOperations;

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

    public Double calcOperation() {

        double result = 0;
        auxOperations = operations;

        while (containsDivOrMult()) {
            for (int i = 1; i < auxOperations.toArray().length; i = i + 2) {

                double resultOperation;

                switch (auxOperations.get(i).toString()) {
                    case Strings.DIVISION:

                        resultOperation = (Double.parseDouble(auxOperations.get(i - 1).toString()) / Double.parseDouble(auxOperations.get(i + 1).toString()));

                        // Iterator iterator = auxOperations.iterator();

                        auxOperations.set(i - 1, resultOperation);
                        auxOperations.remove(i);
                        auxOperations.remove(i);

                    /* auxOperations.set(i - 1, resultOperation);
                    auxOperations.set(i + 1, resultOperation);
                    auxOperations.set(i, "+"); */

                        break;

                    case Strings.MULTIPLICATY:

                        resultOperation = (Double.parseDouble(auxOperations.get(i - 1).toString()) * Double.parseDouble(auxOperations.get(i + 1).toString()));

                        auxOperations.set(i - 1, resultOperation);
                        auxOperations.remove(i);
                        auxOperations.remove(i);

                        /* auxOperations.set(i - 1, resultOperation);
                        auxOperations.set(i + 1, resultOperation);
                        auxOperations.set(i, "+"); */

                        break;

                }
            }
        }

        result = Double.parseDouble(auxOperations.get(0).toString());

        for (int i = 2; i < auxOperations.size(); i = i + 2) {
            switch (auxOperations.get(i - 1).toString()) {
                case Strings.SUBTRACT:
                    result -= Double.parseDouble(auxOperations.get(i).toString());
                    break;

                case Strings.SUM:
                    result += Double.parseDouble(auxOperations.get(i).toString());
                    break;
            }
        }

        /* for (int i = 1; i < auxOperations.toArray().length; i = i+2) {

            switch (auxOperations.get(i).toString()) {
                case Strings.SUBTRACT:

                    result += Double.parseDouble(auxOperations.get(i - 1).toString()) - Double.parseDouble(auxOperations.get(i + 1).toString());
                    break;

                case Strings.SUM:

                    result += Double.parseDouble(auxOperations.get(i - 1).toString()) + Double.parseDouble(auxOperations.get(i + 1).toString());
                    break;
            }
        } */

        return result;

    }

    private boolean containsDivOrMult() {
        return auxOperations.contains(Strings.DIVISION) ||
                auxOperations.contains(Strings.MULTIPLICATY);
    }


    public void addData(Object data){
        operations.add(data);
    }
}
