package com.example.appcalculator;

import java.util.ArrayList;

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

        while (containsDivOrMulti()) {

            for (int i = 1; i < auxOperations.toArray().length; i = i + 2) {

                double resultOperation;

                switch (auxOperations.get(i).toString()) {

                    case Strings.PERCENT:

                        resultOperation = (Double.parseDouble(operations.get(i - 1).toString()) * Double.parseDouble(operations.get(i + 1).toString()))/100;

                        auxOperations.set(i - 1, resultOperation);
                        auxOperations.remove(i);
                        auxOperations.remove(i);

                        break;

                    case Strings.DIVISION:

                        resultOperation = (Double.parseDouble(auxOperations.get(i - 1).toString()) * Double.parseDouble(auxOperations.get(i + 1).toString()))/100;

                        auxOperations.set(i - 1, resultOperation);
                        auxOperations.remove(i);
                        auxOperations.remove(i);

                        break;

                    case Strings.MULTIPLICATY:

                        resultOperation = (Double.parseDouble(auxOperations.get(i - 1).toString()) * Double.parseDouble(auxOperations.get(i + 1).toString()));

                        auxOperations.set(i - 1, resultOperation);
                        auxOperations.remove(i);
                        auxOperations.remove(i);

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

        return result;

    }

    private boolean containsDivOrMulti() {
        return auxOperations.contains(Strings.DIVISION) ||
                auxOperations.contains(Strings.MULTIPLICATY) ||
                auxOperations.contains(Strings.PERCENT);
    }


    public void addData(Object data){
        operations.add(data);
    }

}
