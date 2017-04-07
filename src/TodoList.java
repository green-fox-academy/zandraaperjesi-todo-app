import java.util.ArrayList;
import java.util.List;

class TodoList {
  private List<Task> todos;

  TodoList() {
    todos = new ArrayList<>();
  }

  void add(Task taskTodo) {
    this.todos.add(taskTodo);
  }

  void delete(int index) {
    List<Task> buffer = new ArrayList<>();
    int deleted = 0;
    for(int i = 0; i < todos.size(); i++) {
      if (i != index - 1) {
        buffer.add(todos.get(i));
      }
      else {
        deleted = 1;
      }
    }
    todos = buffer;
    if (deleted == 0) {
      System.out.println("Unable to remove: index is out of bound");
    }
  }

  void list() {
    if (todos.size() == 0) {
      System.out.println("No todos for today! :)");
      return;
    }
    else {
      int i = 1;
      for (Task t : todos) {
        if (t.getState().equals("done")) {
          System.out.println(i + " - [x] " + t.getDescription() + " - is due in " + t.getDue() + " days.");
        } else {
          System.out.println(i + " - [ ] " + t.getDescription() + " - is due in " + t.getDue() + " days.");
        }
        i++;
      }
    }
  }

  List<String> toRawForm() {
    List<String> buffer = new ArrayList<>();
    for (Task task : todos) {
      buffer.add(task.getRawForm());
    }
    return buffer;
  }

  void doTask(int toMark) {
    this.todos.get(toMark - 1).markDone();
  }
}
