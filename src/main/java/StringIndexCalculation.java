package main.java;

import java.util.List;

public class StringIndexCalculation implements IndexCalculation {

    /**
     * Returns the index of the maximum or minimum String item in the collection
     *
     * @param direction Merge direction
     * @param data Merge elements
     * @return indexOfElement
     */
    @Override
    public int indexOfElement(String direction, List<String> data) {
        String compareString = null;
        int indexOfElement = 0;
        for (int i = 0; i < data.size(); i++) {
            String currentElement = data.get(i);
            if (i == 0) {
                compareString = currentElement;
            }
            if ("asc".equals(direction)) {
                if (compareString.compareTo(currentElement) > 0) {
                    compareString = currentElement;
                    indexOfElement = i;
                }
            } else {
                if (compareString.compareTo(currentElement) < 0) {
                    compareString = currentElement;
                    indexOfElement = i;
                }
            }
        }
        return indexOfElement;
    }
}
