public class Main {
  static TaskHandler taskhandler = new TaskHandler();
  public static void main(String[] args) {
    taskhandler.readData();
    taskhandler.splitLines();
    taskhandler.checkInput(args);
    taskhandler.writeData();
  }
}
