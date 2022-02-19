package com.epam.mathfile.refactor;

import java.util.List;
import java.util.Objects;

public class NumberCalculator {
    private List<Data> list;

    public NumberCalculator(List<Data> list) {
        this.list = list;
    }

    public List<Data> calc() {
        for (Data data : list) {
            switch (data.getSign()) {
                case PLUS:
                    data.setResult(data.getNumber1() + data.getNumber2());
                    break;
                case MINUS:
                    data.setResult(data.getNumber1() - data.getNumber2());
                    break;
                case MULTIPLICATION:
                    data.setResult(data.getNumber1() * data.getNumber2());
                    break;
                case DIVISION:
                    data.setResult(data.getNumber1() / data.getNumber2());
                    break;
                default:
                    break;
            }
        }
        return list;
    }

    public List<Data> getList() {
        return list;
    }

    public void setList(List<Data> list) {
        this.list = list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NumberCalculator)) return false;
        NumberCalculator that = (NumberCalculator) o;
        return Objects.equals(getList(), that.getList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getList());
    }

    @Override
    public String toString() {
        return "NumberCalculator{" +
                "list=" + list +
                '}';
    }
}
