package com.epam.mathfile.refactor;

import java.util.Objects;

public class Data {
    private Integer number1;
    private Integer number2;
    private Sign sign;

    private Integer result;

    public Data() {
    }

    public Data(Integer number1, Integer number2, Sign sign) {
        this.number1 = number1;
        this.number2 = number2;
        this.sign = sign;
    }

    public Integer getNumber1() {
        return number1;
    }

    public void setNumber1(Integer number1) {
        this.number1 = number1;
    }

    public Integer getNumber2() {
        return number2;
    }

    public void setNumber2(Integer number2) {
        this.number2 = number2;
    }

    public Sign getSign() {
        return sign;
    }

    public void setSign(Sign sign) {
        this.sign = sign;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Data)) return false;
        Data data = (Data) o;
        return Objects.equals(getNumber1(), data.getNumber1()) &&
                Objects.equals(getNumber2(), data.getNumber2()) &&
                getSign() == data.getSign() &&
                Objects.equals(getResult(), data.getResult());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber1(), getNumber2(), getSign(), getResult());
    }

    @Override
    public String toString() {
        return "Data{" +
                "number1=" + number1 +
                ", number2=" + number2 +
                ", sign=" + sign +
                ", result=" + result +
                '}';
    }
}
