import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import strategy.FindAll;
import strategy.FindAny;
import strategy.FindContext;
import strategy.FindNone;

public class Menu {
    private  List<String> listOfPersons;
    private  Map<String, ArrayList<Integer>> mapOfWords;
    private final FindContext findContext;

    public Menu(FindContext findContext){
        this.findContext = findContext;
    }

    public void start(String file) throws FileNotFoundException {
        Scanner filScanner = new Scanner(new File(file));
        listOfPersons = new ArrayList<>();
        while (filScanner.hasNextLine()) {
            listOfPersons.add(filScanner.nextLine());
        }

        Finder finder = new Finder(listOfPersons);
        finder.fillingMap();
        mapOfWords = finder.getMapOfWords();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            if (!this.menu(scanner)) {
                break;
            }
        }
        System.out.println("Bye!");

    }


    public boolean menu(Scanner scanner) {

        System.out.println("\n=== Menu ===\n" +
                "1. Find a person\n" +
                "2. Print all people\n" +
                "0. Exit");

        switch (scanner.nextInt()) {

            case 1:
                scanner.nextLine();
                selectStrategy(findContext,scanner);
                return true;
            case 2:
                scanner.nextLine();
                print();
                return true;
            case 0:
                return false;
            default:
                scanner.nextLine();
                System.out.println("\nIncorrect option! Try again.");
                return menu(scanner);
        }
    }

    public void selectStrategy(FindContext findContext, Scanner scanner) {
        System.out.println("Select a matching strategy: ALL, ANY, NONE");
        findContext.setListOfPeople(listOfPersons);
        String s = scanner.nextLine();
        switch (s) {
            case "ALL":
                findContext.setFindStrategy(new FindAll());
                findContext.search(mapOfWords);
                break;
            case "ANY":
                findContext.setFindStrategy(new FindAny());
                findContext.search(mapOfWords);
                break;
            case "NONE":
                findContext.setFindStrategy(new FindNone());
                findContext.search(mapOfWords);
                break;
            default:
                System.out.println("\nIncorrect option! Try again.");
                selectStrategy(findContext, scanner);
        }

    }

    public void print() {
        System.out.println("\n=== List of people ===");
        for (String s : listOfPersons) {
            System.out.println(s);
        }
    }
}
