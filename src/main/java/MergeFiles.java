package main.java;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergeFiles {

    /**
     * Merge input files
     *
     * @param parameters Merge parameters
     * @param indexCalculation Object to calculate the desired index
     */
    static void merge(Parameters parameters, IndexCalculation indexCalculation) {

        List<Scanner> scanners = scannersList(parameters.getInputFiles());
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(parameters.getOutputFile()))) {

            List<String> numbers = new ArrayList<>();
            List<Boolean> flags = new ArrayList<>();
            for (int i = 0; ; i++) {
                for (int j = 0; j < scanners.size(); j++) {
                    Scanner scanner = scanners.get(j);
                    if (i == 0 && scanner.hasNextLine()) {
                        numbers.add(scanner.nextLine());
                        flags.add(true);
                    }
                    else if (scanner.hasNextLine() && !flags.get(j)) {
                        numbers.set(j, scanner.nextLine());
                        flags.set(j, true);
                    }
                    else if (!scanner.hasNextLine() && !flags.get(j)) {
                        scanners.remove(j);
                        numbers.remove(j);
                        flags.remove(j);
                        break;
                    }
                }
                if (numbers.isEmpty()) {
                    break;
                }
                int index = indexCalculation.indexOfElement(parameters.getDirection(), numbers);
                if (indexCalculation instanceof IntegerIndexCalculation && index == -1) {
                    for (int k = 0; k < numbers.size(); k++) {
                        try {
                            Integer.parseInt(numbers.get(k));
                        } catch (NumberFormatException ex) {
                            System.out.println("This is not a number! Message: " + ex.getMessage());
                            flags.set(k, false);
                        }
                    }
                } else {
                    writer.write(numbers.get(index) + "\n");
                    System.out.println(numbers.get(index));
                    flags.set(index, false);
                }



            }
        } catch (IOException ex) {
            ex.getMessage();
        } finally {
            for (Scanner scanner : scanners)
                scanner.close();
        }
    }

    /**
     * Create a list of scanners that will read input files
     *
     * @param list Input files paths
     * @return scanners
     */
    private static List<Scanner> scannersList(List<String> list) {
        List<Scanner> scanners = new ArrayList<>();
        for (String filePath : list) {
            try {
                Scanner scanner = new Scanner(new File(filePath));
                if (scanner.hasNextLine())
                    scanners.add(scanner);
            } catch (FileNotFoundException ex) {
                System.out.println("File does not exist: " + ex.getMessage());
            }

        }
        return scanners;
    }

}
