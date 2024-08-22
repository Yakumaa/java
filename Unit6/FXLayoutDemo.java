package Unit6;

import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.*;

public class FXLayoutDemo extends Application{
  public static void main(String[] args) {
    launch(args);
  }
  @Override
  public void start(Stage stage) throws Exception {
  //in javafx, stage is a main window, scene is a subwindow. controls are put in layout
  //ayout is added into scenae and scene is added into stage
  Button b1 = new Button("button1");
  Button b2 = new Button("button2");
  Button b3 = new Button("button3");
  Label l1 = new Label("result");
  //flowplane: added content from left to right and if there is no any space tehn places the content in next line
  FlowPane fp = new FlowPane();
  fp.setHgap(10);
  fp.getChildren().add(b1);
  fp.getChildren().add(b2);
  fp.getChildren().add(b3);
  fp.getChildren().add(l1);

  // //GridPane: added content in grid format
  // GridPane gp = new GridPane();
  // gp.add(b1, 0, 0);
  // gp.add(b2, 1, 0);
  // gp.add(b3, 2, 0);
  // gp.add(l1, 0, 1);

  // //BorderPane: added content in top, bottom, left, right and center
  // BorderPane bp = new BorderPane();
  // bp.setCenter(11);
  // bp.setLeft(b1);
  // bp.setRight(b2);
  // bp.setTop(b3);

  // //HBox: added content in horizontal format
  // HBox hb = new HBox();
  // hb.getChildren().addAll(b1, b2, b3, l1); 

  // //VBox: added content in vertical format
  // VBox vb = new VBox();
  // vb.getChildren().addAll(b1, b2, b3, l1);


  //handling action event
  b1.setOnAction(new EventHandler<ActionEvent>(){
    @Override
    public void handle(ActionEvent ae){
      l1.setText("button1 clicked");
    }
  });

  //add layout into scene
  Scene sc = new Scene(fp, 400, 400);   //change to gp, bp, hb, vb
  //add scene into stage
  stage.setTitle("layout demo");
  stage.setScene(sc);
  stage.show();
  }
}
