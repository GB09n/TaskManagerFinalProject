/**
 * Program description: Final Project - JavaFX Task Manager Application for Data Structures and Algorithms class.
 * This program helps users manage tasks with priorities and due dates using a GUI interface.
 * 
 * @author Gokcen Becermen
 * @version 1.0
 * @since 1.0
 *
 * OS: Windows 10
 * IDE: Eclipse 2023-12
 * 
 * Copyright: This is my own original work 
 * based on specifications issued by our instructor.
 * 
 * Academic Honesty: I attest that this is my original work.
 * I have not used unauthorized source code, either modified or
 * unmodified, nor used generative AI as a final draft. 
 * I have not given other fellow student(s) access to my program.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.*;

/**
 * This is the main class that launches the Task Manager application with a GUI.
 * It sets up the user interface and shows the window.
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Task Manager - JavaFX");

        // Input fields for task name, priority, and due date
        TextField nameField = new TextField();
        nameField.setPromptText("Enter task name");

        ComboBox<Integer> priorityBox = new ComboBox<>();
        priorityBox.getItems().addAll(1, 2, 3, 4, 5);
        priorityBox.setPromptText("Priority");

        DatePicker duePicker = new DatePicker();
        duePicker.setPromptText("Due date");

        // Get the GUI layout from TaskManagerApp
        TaskManagerApp app = new TaskManagerApp();
        VBox root = app.getUI(nameField, priorityBox, duePicker);

        // Show the GUI
        Scene scene = new Scene(root, 450, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
