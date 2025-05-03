/**
 * This class creates the user interface for the Task Manager.
 * It handles adding, completing, deleting, and resetting tasks.
 */import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.collections.*;
import javafx.geometry.Insets;
import java.time.LocalDate;

public class TaskManagerApp {
    private ObservableList<HBox> activeTasks = FXCollections.observableArrayList();
    private ObservableList<HBox> completedTasks = FXCollections.observableArrayList();

    /**
     * This method creates the full GUI layout and handles user actions.
     */
    public VBox getUI(TextField nameField, ComboBox<Integer> priorityBox, DatePicker duePicker) {
        // Buttons
        Button addButton = new Button("Add Task");
        Button deleteButton = new Button("Delete Task");
        Button resetButton = new Button("Reset All");

        // ListViews to show tasks
        ListView<HBox> activeListView = new ListView<>(activeTasks);
        ListView<HBox> completedListView = new ListView<>(completedTasks);

        // Add task button logic
        addButton.setOnAction(e -> {
            String name = nameField.getText();
            Integer priority = priorityBox.getValue();
            LocalDate dueDate = duePicker.getValue();

            // Input checks
            if (name == null || name.trim().isEmpty()) {
                showAlert("Task name is required.");
                return;
            }
            if (priority == null) {
                showAlert("Please select a priority.");
                return;
            }
            if (dueDate == null) {
                showAlert("Please pick a due date.");
                return;
            }

            Task task = new Task(name, priority, dueDate);
            Text taskText = new Text(task.toString());

            // Highlight past due dates in red
            if (dueDate.isBefore(LocalDate.now())) {
                taskText.setFill(Color.RED);
            }

            // Complete button
            Button completeButton = new Button("Complete");
            HBox taskBox = new HBox(10, taskText, completeButton);
            taskBox.setPadding(new Insets(5));

            // Move to completed
            completeButton.setOnAction(event -> {
                activeTasks.remove(taskBox);
                completedTasks.add(new HBox(new Text("✅ " + task.toString())));
            });

            activeTasks.add(taskBox);

            // Clear inputs
            nameField.clear();
            priorityBox.setValue(null);
            duePicker.setValue(null);
        });

        // Delete selected task
        deleteButton.setOnAction(e -> {
            HBox selected = activeListView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                activeTasks.remove(selected);
            } else {
                showAlert("Please select a task to delete.");
            }
        });

        // Reset all tasks
        resetButton.setOnAction(e -> {
            activeTasks.clear();
            completedTasks.clear();
        });

        // Layout for inputs and buttons
        HBox buttonRow = new HBox(10, addButton, deleteButton, resetButton);
        VBox inputSection = new VBox(10, nameField, priorityBox, duePicker, buttonRow);
        inputSection.setPadding(new Insets(10));
        inputSection.setStyle("-fx-background-color: lightblue;");

        // Full layout
        VBox layout = new VBox(15,
                inputSection,
                new Label("📝 Active Tasks:"), activeListView,
                new Label("✅ Completed Tasks:"), completedListView
        );
        layout.setPadding(new Insets(10));

        return layout;
    }

    /**
     * Shows a warning alert with a message.
     */
    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Input Error");
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
