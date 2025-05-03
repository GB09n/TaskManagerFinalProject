import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class tests if the Task object works correctly.
 */
public class TaskTest {

    @Test
    public void testTaskCreation() {
        Task task = new Task("Test Task", 2, LocalDate.of(2025, 4, 21));

        assertEquals("Test Task", task.getName());
        assertEquals(2, task.getPriority());
        assertEquals(LocalDate.of(2025, 4, 21), task.getDueDate());
    }
}
