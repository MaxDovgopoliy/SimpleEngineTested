package strategy;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public interface FindStrategy {
    Set<Integer> search(Map<String, ArrayList<Integer>> wordOfPersons);
}
