package com.epam.mathfile.services;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    public static List<String> readFile(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();

        FileInputStream fileInputStream = new FileInputStream(filePath);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }

        return lines;
    }

    public static List<String> count(List<String> lines) {
        List<String> newLines = new ArrayList<>();
        for (String line : lines) {
            Integer result = null;

            String[] elements = line.split(" ");

            switch (elements[elements.length - 1]) {
                case "+":
                    result = Integer.valueOf(elements[0]) + Integer.valueOf(elements[1]);
                    break;
                case "-":
                    result = Integer.valueOf(elements[0]) - Integer.valueOf(elements[1]);
                    break;
                case "*":
                    result = Integer.valueOf(elements[0]) * Integer.valueOf(elements[1]);
                    break;
                case "/":
                    result = Integer.valueOf(elements[0]) / Integer.valueOf(elements[1]);
                    break;
                default:
                    System.out.println("Incorrect data in file");
                    break;
            }
            newLines.add(elements[0] + " " + elements[2] + " " + elements[1] + " = " + result.toString());
        }
        return newLines;
    }

    public static void writeToFile(List<String> newLines) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Aliaksandr_Dabarovic\\text2.txt", true);
        for (String line : newLines) {
            fileOutputStream.write(line.getBytes());
            fileOutputStream.write(10);
        }
    }
}
