import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
  private final static String DATA = "src/data.csv";
  private final static String REGEX = ";";
  private static TodoList myTodos;

  public static void main(String[] args) {
    myTodos = new TodoList();
    List<String> rawLines = readData();
    splitLines(rawLines);
    myTodos.list();
  }

  public static void splitLines(List<String> toSplit) {
    for (String line : toSplit) {
      String[] buffer = line.split(REGEX);
      myTodos.add(new Task(buffer[0], buffer[1]));
    }
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
