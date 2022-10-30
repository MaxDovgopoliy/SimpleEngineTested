import java.util.*;

public class Finder {
    private final List<String> peopleData;
    private final Map<String, ArrayList<Integer>> mapOfWords = new TreeMap<>();

    public Finder(List<String> peopleData) {
        this.peopleData = peopleData;
        fillingMap();
    }

    void fillingMap() {

        for (int i = 0; i < peopleData.size(); i++) {

            String[] personData = peopleData.get(i).toLowerCase().split(" ");

            for (String data : personData) {
                if (!mapOfWords.containsKey(data)) {
                    mapOfWords.put(data, new ArrayList<>(Arrays.asList(i)));
                } else {
                    mapOfWords.get(data).add(i);
                }
            }
        }
    }

    public Map<String, ArrayList<Integer>> getMapOfWords() {
        return mapOfWords;
    }
}
