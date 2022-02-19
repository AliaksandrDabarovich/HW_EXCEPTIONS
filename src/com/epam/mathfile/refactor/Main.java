package com.epam.mathfile.refactor;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String file = "C:\\Users\\Aliaksandr_Dabarovic\\text.txt";
        String file2 = "C:\\Users\\Aliaksandr_Dabarovic\\text2.txt";


        NumberReader numberReader;
        NumberCalculator calculator;
        NumberWriter writer;

        List<Data> fileData;

        try {
            numberReader = new NumberReader(file);
            fileData = numberReader.take();

            calculator = new NumberCalculator(fileData);
            fileData = calculator.calc();

            writer = new NumberWriter(file2, fileData);
            writer.save();

        } catch (NumberReaderException | NumberWriterException e) {
            System.out.println(e.getMessage());
        }
    }
}
