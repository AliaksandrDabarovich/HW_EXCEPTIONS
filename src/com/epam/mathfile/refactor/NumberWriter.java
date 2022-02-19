package com.epam.mathfile.refactor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class NumberWriter {
    private String path;
    private List<Data> list;

    public NumberWriter(String path, List<Data> list) {
        this.path = path;
        this.list = list;
    }

    public void save() throws NumberWriterException {
        byte[] space = " ".getBytes();

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path, true);
            for (Data data : list) {
                fileOutputStream.write(data.getNumber1().toString().getBytes());
                fileOutputStream.write(space);
                switch (data.getSign()) {
                    case PLUS:
                        fileOutputStream.write("+".getBytes());
                        break;
                    case MINUS:
                        fileOutputStream.write("-".getBytes());
                        break;
                    case MULTIPLICATION:
                        fileOutputStream.write("*".getBytes());
                        break;
                    case DIVISION:
                        fileOutputStream.write("/".getBytes());
                        break;
                    default:
                        break;
                }
                fileOutputStream.write(space);
                fileOutputStream.write(data.getNumber2().toString().getBytes());
                fileOutputStream.write(space);
                fileOutputStream.write("=".getBytes());
                fileOutputStream.write(space);
                fileOutputStream.write(data.getResult().toString().getBytes());
                fileOutputStream.write(10);
            }
        } catch(FileNotFoundException e) {
            throw new NumberWriterException(e);
        } catch(IOException e) {
            throw new NumberWriterException(e);
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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
        if (!(o instanceof NumberWriter)) return false;
        NumberWriter writer = (NumberWriter) o;
        return Objects.equals(getPath(), writer.getPath()) &&
                Objects.equals(getList(), writer.getList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPath(), getList());
    }

    @Override
    public String toString() {
        return "NumberWriter{" +
                "path='" + path + '\'' +
                ", list=" + list +
                '}';
    }
}
