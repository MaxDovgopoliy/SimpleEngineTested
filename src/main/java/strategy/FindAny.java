package strategy;

import java.util.*;

public class FindAny implements FindStrategy {
    Scanner scanner = new Scanner(System.in);
    private Set<Integer> foundIndexes = new LinkedHashSet<>();

    @Override
    public Set<Integer> search(Map<String, ArrayList<Integer>> mapOfWords) {
        System.out.println("\nEnter a name or email to search all suitable people.");
        String key = scanner.nextLine();
        for (String word : key.split(" ")) {
            if (mapOfWords.containsKey(word.toLowerCase())) {
                foundIndexes.addAll(mapOfWords.get(word.toLowerCase()));
            }
        }
        return foundIndexes;
    }
}
