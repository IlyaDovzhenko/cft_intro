package main.java;

import java.util.List;

public class IntegerIndexCalculation implements IndexCalculation {

    /**
     * Returns the index of the maximum or minimum integer item in the collection
     *
     * @param direction Merge direction
     * @param data Merge elements
     * @return indexOfElement
     */
    @Override
    public int indexOfElement(String direction, List<String> data) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int indexOfElement = 0;


        for (int i = 0; i < data.size(); i++) {
            int currentElement;
            // Checking numbers
            try {
                currentElement = Integer.parseInt(data.get(i));
            } catch (NumberFormatException ex) {
                return -1;
            }
            if ("asc".equals(direction)) {
                if (currentElement < min) {
                    min = currentElement;
                    indexOfElement = i;
                }
            } else {
                if (currentElement > max) {
                    max = currentElement;
                    indexOfElement = i;
                }
            }
        }
        return indexOfElement;
    }
}
