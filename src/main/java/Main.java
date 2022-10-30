import java.io.FileNotFoundException;
import strategy.FindContext;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Menu menu = new Menu(new FindContext());
        menu.start(args[1]);
    }
}
