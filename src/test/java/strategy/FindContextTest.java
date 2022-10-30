package strategy;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FindContextTest {

    @Mock
    FindStrategy findStrategy;
    List<String> listOfPeople = List.of("Dwight Joseph djo@gmail.com", "Kristofer Galley");
    FindContext findContext = new FindContext();
    HashMap<String, ArrayList<Integer>> map = new HashMap<>();

    @Test
    public void FindContextSearchAndPrintWithCorrectData() {
        findContext.setFindStrategy(findStrategy);
        findContext.setListOfPeople(listOfPeople);

        when(findStrategy.search(map)).thenReturn(Set.of(1));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);
        String expectedValue = "\nFound people:\nKristofer Galley\n";

        findContext.search(map);

        verify(findStrategy).search(map);
        assertEquals(expectedValue,byteArrayOutputStream.toString());

        System.setOut(System.out);
    }

    @Test
    public  void FindContextSearchAndPrintWithIncorrectData() {
        findContext.setFindStrategy(findStrategy);
        findContext.setListOfPeople(listOfPeople);

        when(findStrategy.search(map)).thenReturn(Set.of());

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);
        String expectedValue = "No matching people found.\n";

        findContext.search(map);

        assertEquals(expectedValue,byteArrayOutputStream.toString());
        System.setOut(System.out);
    }
}