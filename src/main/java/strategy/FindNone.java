package strategy;

import java.util.*;

public class FindNone implements FindStrategy {

    Scanner scanner = new Scanner(System.in);
    private Set<Integer> foundIndexes = new LinkedHashSet<>();
    private Set<Integer> allIndexes = new LinkedHashSet<>();
    private List<Integer> commonIndexes = new ArrayList<>();

    @Override
    public Set<Integer> search(Map<String, ArrayList<Integer>> mapOfWords) {
        System.out.println("\nEnter a name or email to search all suitable people.");
        String key = scanner.nextLine();
        for (ArrayList<Integer> values : mapOfWords.values()) {
            allIndexes.addAll(values);
        }
        for (String word : key.split(" ")) {
            if (mapOfWords.containsKey(word.toLowerCase())) {
                foundIndexes.addAll(mapOfWords.get(word.toLowerCase()));
            }
        }
        allIndexes.removeAll(foundIndexes);
        return allIndexes;
    }
}
