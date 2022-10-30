import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import strategy.FindContext;

@RunWith(MockitoJUnitRunner.class)
public class MenuTest {
    @Mock
    FindContext findContext;
    

    @Test
    public void selectStrategyAny() throws FileNotFoundException {

        ByteArrayInputStream in =
                new ByteArrayInputStream("1\nANY\n0\n".getBytes());
        System.setIn(in);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);

        doNothing().when(findContext).setFindStrategy(any());
        doNothing().when(findContext).search(any());

        String[] args = new String[] {"file", "data.txt"};
        Menu menu = new Menu(findContext);
        menu.start(args[1]);

        verify(findContext).setFindStrategy(any());
        verify(findContext).search(any());

    }
    @Test
    public void selectStrategyNoneAndIncorrectCases() throws FileNotFoundException {

        ByteArrayInputStream in =
                new ByteArrayInputStream("6\n1\nNO\nNONE\n0\n".getBytes());
        System.setIn(in);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);

        doNothing().when(findContext).setFindStrategy(any());
        doNothing().when(findContext).search(any());

        String[] args = new String[] {"file", "data.txt"};
        Menu menu = new Menu(findContext);
        menu.start(args[1]);

        verify(findContext).setFindStrategy(any());
        verify(findContext).search(any());

    }

    @Test
    public void print() throws FileNotFoundException {

        ByteArrayInputStream in = new ByteArrayInputStream("2\n0\n0\n".getBytes());
        System.setIn(in);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);
        String expectedValue = "\n=== Menu ===\n" +
                "1. Find a person\n" +
                "2. Print all people\n" +
                "0. Exit\n" +
                "\n=== List of people ===\n" +
                "Dwight Joseph djo@gmail.com\n" +
                "Rene Webb webb@gmail.com\n" +
                "Katie Jacobs katie444@gmail.com\n" +
                "Erick Harrington harrington@gmail.com\n" +
                "\n=== Menu ===\n" +
                "1. Find a person\n" +
                "2. Print all people\n" +
                "0. Exit\n" +
                "Bye!\n";
        String[] args = new String[] {"file", "data.txt"};
        Main.main(args);


        assertEquals(expectedValue, byteArrayOutputStream.toString());

        System.setOut(System.out);
        System.setIn(System.in);
    }
}