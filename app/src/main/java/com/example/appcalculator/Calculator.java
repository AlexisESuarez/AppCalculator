package com.example.appcalculator;

import java.util.ArrayList;
import java.util.List;

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

        for (int i = 1; i < auxOperations.toArray().length; i = i + 2) {

            double resultOperation;
            ArrayList<Object> delete = new ArrayList<>();

            switch (auxOperations.get(i).toString()) {
                case Strings.DIVISION:

                    resultOperation = Double.parseDouble(operations.get(i - 1).toString()) / Double.parseDouble(operations.get(i + 1).toString());

                    delete.add(auxOperations.get(i - 1));
                    delete.add(auxOperations.get(i + 1));
                    delete.add(auxOperations.get(i));

                    auxOperations.removeAll(delete);
                    auxOperations.add(i - 1, resultOperation);

                    delete.clear();

                    break;

                case Strings.MULTIPLICATY:
                    resultOperation = Double.parseDouble(operations.get(i - 1).toString()) * Double.parseDouble(operations.get(i + 1).toString());

                    delete.add(auxOperations.get(i - 1));
                    delete.add(auxOperations.get(i + 1));
                    delete.add(auxOperations.get(i));

                    auxOperations.removeAll(delete);
                    auxOperations.add(i - 1, resultOperation);

                    delete.clear();

                    break;
                case Strings.PERCENT:
                    resultOperation = Double.parseDouble(operations.get(i - 1).toString()) % Double.parseDouble(operations.get(i + 1).toString());

                    delete.add(auxOperations.get(i - 1));
                    delete.add(auxOperations.get(i + 1));
                    delete.add(auxOperations.get(i));

                    auxOperations.removeAll(delete);
                    auxOperations.add(i - 1, resultOperation);

                    delete.clear();

                    break;

            }
        }
        for (int i = 1; i < operations.toArray().length; i = i+2) {


            switch (auxOperations.get(i).toString()) {
                case Strings.SUBTRACT:

                    result += Double.parseDouble(operations.get(i - 1).toString()) - Double.parseDouble(operations.get(i + 1).toString());
                    break;

                case Strings.SUM:

                    result += Double.parseDouble(operations.get(i - 1).toString()) + Double.parseDouble(operations.get(i + 1).toString());
                    break;
            }
        }

        return result;

    }

    public void addData(Object data){
        operations.add(data);
    }

}
