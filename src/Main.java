import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
  private final static String DATA = "src/data.csv";

  public static void main(String[] args) {
    TodoList myTodos = new TodoList();
    List<String> rawLines = readData();
    System.out.println(rawLines.get(1));
  }

  private static List<String> readData() {
    List<String> readLines = new ArrayList<>();
    Path path = Paths.get(DATA);
    try {
      readLines = Files.readAllLines(path);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return readLines;
  }
}
