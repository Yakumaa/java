package Lab5;

import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.*;
import java.sql.*;
import static javafx.application.Application.launch;

public class JavafxForm extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception{
        // Form components
        Label usernameLabel = new Label("Username:");
        Label passwordLabel = new Label("Password:");
        Label genderLabel = new Label("Gender");
        Label courseLabel = new Label("Course");
        Label countryLabel = new Label("Country");
        TextField textField = new TextField();
        PasswordField passwordField = new PasswordField();
        RadioButton maleButton = new RadioButton("Male");
        RadioButton femaleButton = new RadioButton("Female");
        ToggleGroup toggleGroup = new ToggleGroup();
        maleButton.setToggleGroup(toggleGroup);
        femaleButton.setToggleGroup(toggleGroup);
        CheckBox javaCheckBox = new CheckBox("Java");
        CheckBox cppCheckBox = new CheckBox("C++");
        CheckBox pythonCheckBox = new CheckBox("Python");
        // Dropdown: Choicebox
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll("Nepal", "India", "Other");
        Button button = new Button("Submit");
        // Grid layout
        GridPane gridPane = new GridPane();
        gridPane.add(usernameLabel, 0, 0);
        gridPane.add(textField, 1, 0);
        gridPane.add(passwordLabel, 0, 1);
        gridPane.add(passwordField, 1, 1);
        gridPane.add(genderLabel, 0, 2);
        gridPane.add(maleButton, 1, 2);
        gridPane.add(new Label(), 0, 3);
        gridPane.add(femaleButton, 1, 3);
        gridPane.add(courseLabel, 0, 4);
        gridPane.add(javaCheckBox, 1, 4);
        gridPane.add(cppCheckBox, 1, 5);
        gridPane.add(pythonCheckBox, 1, 6);
        gridPane.add(countryLabel, 0, 7);
        gridPane.add(choiceBox, 1, 7);
        gridPane.add(button, 1, 8);
        // Button event handling
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                // Extract form field data
                String username = textField.getText();
                String password = passwordField.getText();
                String gender = maleButton.isSelected() ? "Male" : "Female";
                
                // Get selected courses
                StringBuilder courses = new StringBuilder();
                if (javaCheckBox.isSelected()) courses.append("Java, ");
                if (cppCheckBox.isSelected()) courses.append("C++, ");
                if (pythonCheckBox.isSelected()) courses.append("Python, ");
                if (courses.length() > 0) courses.setLength(courses.length() - 2); // Remove trailing comma
                
                // Get selected country
                String country = choiceBox.getValue();
                // Insert data into database
                if (insertDataIntoDatabase(username, password, gender, courses.toString(), country)) {
                    System.out.println("Registration successful!");
                } else {
                    System.out.println("Registration failed.");
                }
            }
        });
        // Scene setup
        Scene scene = new Scene(gridPane, 400, 400);
        stage.setTitle("Registration Form");
        stage.setScene(scene);
        stage.show();
    }
    // Method to insert form data into the database
    private boolean insertDataIntoDatabase(String username, String password, String gender, String courses, String country) {
        boolean isSuccess = false;
        String jdbcURL = "jdbc:mysql://localhost:3306/java";
        String dbUsername = "root";
        String dbPassword = "";
        String sql = "INSERT INTO tbl_lab (id,username, password, gender, course, country) VALUES (?,?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(jdbcURL, dbUsername, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, "1123");
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, gender);
            preparedStatement.setString(5, courses);
            preparedStatement.setString(6, country);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                isSuccess = true; // Data inserted successfully
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
