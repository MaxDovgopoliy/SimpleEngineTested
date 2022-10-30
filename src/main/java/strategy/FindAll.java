package strategy;

import java.util.*;

public class FindAll implements FindStrategy {
    Scanner scanner = new Scanner(System.in);
    private Set<Integer> foundIndexes = new LinkedHashSet<>();
    private List<Integer> commonIndexes = new ArrayList<>();

    @Override
    public Set<Integer> search(Map<String, ArrayList<Integer>> mapOfWords) {
        System.out.println("\nEnter a name or email to search all suitable people.");
        String key = scanner.nextLine();
        for (String word : key.split(" ")) {
            if (mapOfWords.containsKey(word.toLowerCase())) {
                if (commonIndexes.isEmpty()) {
                    commonIndexes.addAll(mapOfWords.get(word.toLowerCase()));
                } else {
                    commonIndexes.retainAll(mapOfWords.get(word.toLowerCase()));
                }
            }
        }
        foundIndexes = Set.copyOf(commonIndexes);
        return foundIndexes;
    }
}
