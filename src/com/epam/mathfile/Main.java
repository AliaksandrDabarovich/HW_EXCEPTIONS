package com.epam.mathfile;

import com.epam.mathfile.services.FileService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();

        try {
            lines = FileService.readFile("C:\\Users\\Aliaksandr_Dabarovic\\text.txt");
        } catch (IOException e) {
            System.out.println("Problem with initial file");
        }

        List<String> newLines = FileService.count(lines);

        try {
            FileService.writeToFile(newLines);
        } catch (IOException e) {
            System.out.println("Problem with destination file");
        }
    }
}
