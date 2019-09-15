package main.java;

public class Application {
    public static void main(String[] args) {

        Parameters parameters = new Parameters(args);
        System.out.println("Direction: " + parameters.getDirection());
        System.out.println("Data type: " + parameters.getInputType());
        System.out.println("Output file: " + parameters.getOutputFile());
        for (String filePath : parameters.getInputFiles()) {
            System.out.println("Input files: " + filePath);
        }

        IndexCalculation indexCalculation;
        if (parameters.getInputType().equals("string")) {
            indexCalculation = new StringIndexCalculation();
        }
        else {
            indexCalculation = new IntegerIndexCalculation();
        }
        MergeFiles.merge(parameters, indexCalculation);
    }
}
