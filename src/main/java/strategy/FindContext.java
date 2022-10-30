package strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindContext {
    List<String> listOfPeople;
    private FindStrategy findStrategy;
    private Set<Integer> foundIndexes;

    public FindContext() {
    }

    public void setFindStrategy(FindStrategy findStrategy) {
        this.findStrategy = findStrategy;
    }

    public void setListOfPeople(List<String> listOfPeople) {
        this.listOfPeople = listOfPeople;
    }

    public void search(Map<String, ArrayList<Integer>> map) {
        foundIndexes = findStrategy.search(map);
        print();
    }

    public void print() {
        if (foundIndexes.isEmpty()) {
            System.out.println("No matching people found.");
        } else {
            System.out.println("\nFound people:");
            for (Integer i : foundIndexes) {
                System.out.println(listOfPeople.get(i));
            }
        }
    }
}
