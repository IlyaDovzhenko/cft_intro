package main.java;

public class Application {
    public static void main(String[] args) {

        Parameters parameters = new Parameters(args);

        IndexCalculation indexCalculation;
        try {
            if (parameters.getInputType().equals("string")) {
                indexCalculation = new StringIndexCalculation();
            }
            else {
                indexCalculation = new IntegerIndexCalculation();
            }
            MergeFiles.merge(parameters, indexCalculation);
        } catch (NullPointerException ex) {
            System.out.println("Enter command line parameters!");
        }
    }
}
