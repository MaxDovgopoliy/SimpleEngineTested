import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import junit.framework.TestCase;
import org.junit.Test;

public class FinderTest extends TestCase {
    @Test
    public void testFillingMap() {
        List<String> listOfPeople = List.of("Dwight Joseph djo@gmail.com");
        Finder finder = new Finder(listOfPeople);

        Map<String, ArrayList<Integer>> resultMapOfWords = finder.getMapOfWords();

        assertTrue(resultMapOfWords.containsKey("Dwight".toLowerCase()));
        assertTrue(resultMapOfWords.containsKey("Joseph".toLowerCase()));
        assertTrue(resultMapOfWords.containsKey("djo@gmail.com".toLowerCase()));
    }
}