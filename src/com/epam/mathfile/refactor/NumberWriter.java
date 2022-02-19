package com.epam.mathfile.refactor;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
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
        String space = " ";
        FileOutputStream fileOutputStream = null;
        BufferedWriter bufferedWriter = null;

        try {
            fileOutputStream = new FileOutputStream(path, true);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            for (Data data : list) {
                bufferedWriter.write(data.getNumber1().toString());
                switch (data.getSign()) {
                    case PLUS:
                        bufferedWriter.write(" + ");
                        break;
                    case MINUS:
                        bufferedWriter.write(" - ");
                        break;
                    case MULTIPLICATION:
                        bufferedWriter.write(" * ");
                        break;
                    case DIVISION:
                        bufferedWriter.write(" / ");
                        break;
                    default:
                        break;
                }
                bufferedWriter.write(data.getNumber2().toString() + " = " + data.getResult().toString());
                bufferedWriter.newLine();
            }
        } catch(FileNotFoundException e) {
            throw new NumberWriterException(e);
        } catch(IOException e) {
            throw new NumberWriterException(e);
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    throw new NumberWriterException(e);
                }
            }
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
