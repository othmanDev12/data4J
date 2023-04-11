package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {


    //C:\Users\omoud\Downloads\addresses.csv

    public static void main(String[] args) throws IOException {
        readCsv("C:\\Users\\omoud\\Downloads\\cities.csv");
    }

    public static void readCsv(String fileName) throws IOException {
        List<Map<String, String>> data = new ArrayList<>();
        String[] headers = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (headers == null) {
                    headers = values;

                } else if (values.length == headers.length) {
                    Map<String, String> record = new LinkedHashMap<>();
                    for (int i = 0; i < headers.length; i++) {
                        record.put(headers[i], values[i]);
                    }
                    data.add(record);
                }
            }
        }

        // Calculate the maximum length of each column
        int[] columnLengths = new int[headers.length];
        for (String header : headers) {
            columnLengths[getIndex(headers, header)] = header.length();
        }
        for (Map<String, String> record : data) {
            for (String key : record.keySet()) {
                int index = getIndex(headers, key);
                int length = record.get(key).length();
                if (length > columnLengths[index]) {
                    columnLengths[index] = length;
                }
            }
        }

        // Print the table header
        for (int i = 0; i < headers.length; i++) {
            System.out.printf("| %-" + columnLengths[i] + "s ", headers[i]);
        }
        System.out.println("|");

        // Print the table separator
        for (int i = 0; i < headers.length; i++) {
            System.out.print("+");
            for (int j = 0; j < columnLengths[i] + 2; j++) {
                System.out.print("-");
            }
        }
        System.out.println("+");

        // Print the table rows
        for (Map<String, String> record : data) {
            for (int i = 0; i < headers.length; i++) {
                String value = record.get(headers[i]);
                System.out.printf("| %-" + columnLengths[i] + "s ", value);
            }
            System.out.println("|");
        }
    }


    public static void readCsv(String fileName , String[] columns) throws IOException {
        List<Map<String, String>> data = new ArrayList<>();
        String[] headers = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (headers == null) {
                    headers = values;
                } else {
                    if (columns == null) {
                        columns = headers;
                    }
                    int[] columnIndices = getColumnIndices(headers, columns);
                    if (values.length == headers.length) {
                        Map<String, String> record = new LinkedHashMap<>();
                        for (int i : columnIndices) {
                            record.put(headers[i], values[i]);
                        }
                        data.add(record);
                    }
                }
            }
        }

        // Calculate the maximum length of each column
        int[] columnLengths = new int[headers.length];
        for (String header : headers) {
            columnLengths[getIndex(headers, header)] = header.length();
        }
        for (Map<String, String> record : data) {
            for (String key : record.keySet()) {
                int index = getIndex(headers, key);
                int length = record.get(key).length();
                if (length > columnLengths[index]) {
                    columnLengths[index] = length;
                }
            }
        }

        // Print the table header
        for (int i = 0; i < headers.length; i++) {
            System.out.printf("| %-" + columnLengths[i] + "s ", headers[i]);
        }
        System.out.println("|");

        // Print the table separator
        for (int i = 0; i < headers.length; i++) {
            System.out.print("+");
            for (int j = 0; j < columnLengths[i] + 2; j++) {
                System.out.print("-");
            }
        }
        System.out.println("+");

        // Print the table rows
        for (Map<String, String> record : data) {
            for (int i = 0; i < headers.length; i++) {
                String value = record.get(headers[i]);
                System.out.printf("| %-" + columnLengths[i] + "s ", value);
            }
            System.out.println("|");
        }
    }

    private static int[] getColumnIndices(String[] headers, String[] columns) {
        if (columns == null) {
            int[] indices = new int[headers.length];
            for (int i = 0; i < headers.length; i++) {
                indices[i] = i;
            }
            return indices;
        } else {
            int[] indices = new int[columns.length];
            for (int i = 0; i < columns.length; i++) {
                indices[i] = getIndex(headers, columns[i]);
            }
            return indices;
        }
    }

    private static int getIndex(String[] array, String value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }
}

