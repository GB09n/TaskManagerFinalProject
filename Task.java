/**
 * This class represents a task with a name, priority, and due date.
 */
import java.time.LocalDate;
public class Task {
    private String name;
    private int priority;
    private LocalDate dueDate;

    /**
     * Creates a new Task object.
     */
    public Task(String name, int priority, LocalDate dueDate) {
        this.name = name;
        this.priority = priority;
        this.dueDate = dueDate;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * Returns a string that shows the task's details.
     */
    @Override
    public String toString() {
        return name + " (Priority: " + priority + ", Due: " + dueDate + ")";
    }
}
