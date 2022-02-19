package com.epam.mathfile.refactor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NumberReader {
    private String filePath;

    public NumberReader(String filePath) {
        this.filePath = filePath;
    }

    public List<Data> take() throws NumberReaderException {
        FileInputStream fileInputStream;
        BufferedReader bufferedReader = null;
        List<String> lines = new ArrayList<>();
        List<Data> result = new ArrayList<>();
        String line;

        try {
            fileInputStream = new FileInputStream(filePath);
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }

            for (String textLine : lines) {
                Data newData = NumberParser.parse(textLine);
                result.add(newData);
            }

        } catch (FileNotFoundException e) {
            throw new NumberReaderException(e);
        } catch (IOException e) {
            throw new NumberReaderException(e);
        } catch (DataParserException e) {
            throw new NumberReaderException(e);
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    throw new NumberReaderException(e);
                }
            }
        }
        return result;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NumberReader)) return false;
        NumberReader that = (NumberReader) o;
        return Objects.equals(getFilePath(), that.getFilePath());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFilePath());
    }

    @Override
    public String toString() {
        return "NumberReader{" +
                "filePath='" + filePath + '\'' +
                '}';
    }
}
