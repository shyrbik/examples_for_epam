package by.it.popkov.calc;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

abstract class Var implements Operation {

    private static Map<String, Var> valueMap = new HashMap<>();

    
    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(other + " + " + this + " impossible");
    }

    Var preAdd(Var other) throws CalcException {
        throw new CalcException(other + " + " + this + " impossible");
    }

    public Var add(Scalar other) throws CalcException {
        throw new CalcException(other + " + " + this + " impossible");
    }

    public Var add(Vector other) throws CalcException {
        throw new CalcException(other + " + " + this + " impossible");
    }

    public Var add(Matrix other) throws CalcException {
        throw new CalcException(other + " + " + this + " impossible");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(this + " - " + other + " impossible");
    }

    Var preSub(Var other) throws CalcException {
        throw new CalcException(other + " - " + this + " impossible");
    }

    public Var sub(Scalar other) throws CalcException {
        throw new CalcException(this + " - " + other + " impossible");
    }

    public Var sub(Vector other) throws CalcException {
        throw new CalcException(this + " - " + other + " impossible");
    }

    public Var sub(Matrix other) throws CalcException {
        throw new CalcException(this + " - " + other + " impossible");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(other + " * " + this + " impossible");
    }
    Var preMul(Var other) throws CalcException {
        throw new CalcException(other + " * " + this + " impossible");
    }

    public Var mul(Scalar other) throws CalcException {
        throw new CalcException(other + " * " + this + " impossible");
    }

    public Var mul(Vector other) throws CalcException {
        throw new CalcException(other + " * " + this + " impossible");
    }

    public Var mul(Matrix other) throws CalcException {
        throw new CalcException(other + " * " + this + " impossible");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(this + " / " + other + " impossible");
    }

    Var preDiv(Var other) throws CalcException {
        throw new CalcException(other + " / " + this + " impossible");
    }

    public Var div(Scalar other) throws CalcException {
        throw new CalcException(this + " / " + other + " impossible");
    }


    static Var newVar(String strVar) throws CalcException {
        if (strVar.matches(Patterns.SCALAR)) return new Scalar(strVar);
        else if (strVar.matches(Patterns.VECTOR)) return new Vector(strVar);
        else if (strVar.matches(Patterns.MATRIX)) return new Matrix(strVar);
        else if (strVar.matches(Patterns.LITTER)) return valueMap.get(strVar);
        else throw new CalcException("Неправильный ввод");
    }

    static void save(String value, Var value1) throws CalcException {
        valueMap.put(value, value1);
        CalcFile.writeValue(valueMap);
    }

    static void printvar() {
        String values = valueMap.toString();
        System.out.println(values);
//        Log.writeLog(values);

    }

    static void sortvar() {
        final String sortedValue = new TreeMap<>(valueMap).toString();
        System.out.println(sortedValue);
//        Log.writeLog(sortedValue);

    }
}
