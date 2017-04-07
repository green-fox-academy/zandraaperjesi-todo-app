import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class TaskHandler {
  private final static String DATA = "src/data.csv";
  private final static String REGEX = ";";
  private  TodoList myTodos;
  private  List<String> rawLines;
  private long millisToDue;
  private final static long MILLIS_IN_DAY = 86400000;

  TaskHandler() {
    this.myTodos = new TodoList();
    millisToDue = this.countMillis();
  }

  void checkInput(String[] arguments) {
    if (arguments.length == 0) {
      System.out.print("Java Todo application\n =======================\n Command line arguments:\n -l   Lists all the tasks\n -a   Adds a new task\n -r   Removes an task\n -c   Completes an task");
    }
    else if (arguments.length == 1 && arguments[0].equals("-l")) {
      myTodos.list();
    }
    else if (arguments.length == 3 && arguments[0].equals("-a")) {
      myTodos.add(new Task("notdone", arguments[1], Integer.valueOf(arguments[2]) * millisToDue));
    }
    else if (arguments.length == 1 && arguments[0].equals("-a")) {
      System.out.println("Unable to add: no task provided");
    }
    else if (arguments.length == 2 && arguments[0].equals("-r")) {
      try {
        myTodos.delete(Integer.valueOf(arguments[1]));
      } catch (IndexOutOfBoundsException e) {
        System.out.println("Unable to remove: index is out of bound");
      } catch (NumberFormatException e) {
        System.out.println("Unable to remove: index is not a number");
      }
    }
    else if (arguments.length == 1 && arguments[0].equals("-r")) {
      System.out.println("Unable to remove: no index provided");
    }
    else if (arguments.length == 2 && arguments[0].equals("-c")) {
      try {
        myTodos.doTask(Integer.valueOf(arguments[1]));
      } catch (IndexOutOfBoundsException e) {
        System.out.println("Unable to check: index is out of bound");
      } catch (NumberFormatException e) {
        System.out.println("Unable to remove: index is not a number");
      }
    }
    else if (arguments.length == 1 && arguments[0].equals("-c")) {
      System.out.println("Unable to remove: no index provided");
    }
    else {
      System.out.println("Unsupported argument");
    }
  }

  void splitLines() {
    for (String line : rawLines) {
      String[] buffer = line.split(REGEX);
      myTodos.add(new Task(buffer[0], buffer[1], Long.valueOf(buffer[2])));
    }
  }

  void readData() {
    Path path = Paths.get(DATA);
    try {
      rawLines = Files.readAllLines(path);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  void writeData() {
    Path path = Paths.get(DATA);
    try {
      Files.write(path, myTodos.toRawForm());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private long countMillis() {
    return System.currentTimeMillis() + MILLIS_IN_DAY;
  }
}
