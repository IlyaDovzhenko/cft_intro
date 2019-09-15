package main.java;

import java.util.List;

public interface IndexCalculation {

    /**
     * Returns the index of the maximum or minimum item in the collection
     *
     * @param direction Merge direction
     * @param data Merge elements
     * @return indexOfElement
     */
    int indexOfElement(String direction, List<String> data);
}
