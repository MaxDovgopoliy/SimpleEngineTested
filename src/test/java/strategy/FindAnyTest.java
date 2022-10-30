package strategy;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

public class FindAnyTest {

    @Test
    public void search() {
        Map<String, ArrayList<Integer>> dataMap= new HashMap<>();
        dataMap.put("bob", new ArrayList<>(List.of(1,2)));
        dataMap.put("lash", new ArrayList<>(List.of(1)));
        dataMap.put("darn", new ArrayList<>(List.of(2)));
        ByteArrayInputStream in =
                new ByteArrayInputStream("bob\n".getBytes());
        System.setIn(in);
        FindAny findAny= new FindAny();
        Set<Integer> searchedResult = findAny.search(dataMap);
        assertTrue(searchedResult.containsAll(List.of(1,2)));
    }
}