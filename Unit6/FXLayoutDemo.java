package Unit6;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
public class FXLayoutDemo extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) {
        // Buttons
        Button b1 = new Button("Button 1");
        Button b2 = new Button("Button 2");
        Button b3 = new Button("Button 3");
        Button b4 = new Button("Button 4");
        Label label = new Label("Result");
        FlowPane flowPane = new FlowPane();
        flowPane.setHgap(10);
        flowPane.setVgap(10);
        flowPane.getChildren().addAll(b1, b2, b3, b4, label);
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.add(b1, 0, 0);
        gridPane.add(b2, 0, 1);
        gridPane.add(b3, 1, 0);
        gridPane.add(b4, 1, 1);
        gridPane.add(label, 1, 2);
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(b1);
        borderPane.setBottom(b2);
        borderPane.setLeft(b3);
        borderPane.setRight(b4);
        borderPane.setCenter(label);
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(b1, b2, b3, b4, label);
        stackPane.setAlignment(b1, Pos.TOP_CENTER);
        stackPane.setAlignment(b2, Pos.BOTTOM_CENTER);
        stackPane.setAlignment(b3, Pos.CENTER_LEFT);
        stackPane.setAlignment(b4, Pos.CENTER_RIGHT);
        stackPane.setAlignment(label, Pos.CENTER);
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(b1, b2, b3, b4, label);
        hBox.setAlignment(Pos.CENTER);
        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(b1, b2, b3, b4, label);
        vBox.setAlignment(Pos.CENTER);
        // Use any one layout (Uncomment the respective layout scene):
        Scene scene = new Scene(flowPane, 400, 200);
        Scene scene = new Scene(gridPane, 400, 200);
        Scene scene = new Scene(borderPane, 400, 200);
        Scene scene = new Scene(stackPane, 400, 200);
        Scene scene = new Scene(hBox, 400, 200);
        Scene scene = new Scene(vBox, 400, 200);
        // Set the scene for the stage
        stage.setScene(scene);
        stage.setTitle("Layout Demo");
        stage.show();
    }
}
