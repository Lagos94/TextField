import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/*By Juan Lagos
* CSC 201
* Professor Tanes Kanchanawanchai
* Assignment 16 Chapter 16
* TextField
* Due Date: 11/12/17*/

public class TxtFld extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane pane = new GridPane();
        TextField text = new TextField("JavaFX");
        Label lblTf = new Label("Text Field:", text);
        lblTf.setContentDisplay(ContentDisplay.RIGHT);
        HBox hBoxTop = new HBox(lblTf);
        hBoxTop.setPadding(new Insets(2));
        hBoxTop.setAlignment(Pos.CENTER);
        pane.add(hBoxTop, 0, 0);

        ToggleGroup options = new ToggleGroup();
        RadioButton shiftLeft = new RadioButton();
        Label Left = new Label("Left", shiftLeft);
        shiftLeft.setToggleGroup(options);
        shiftLeft.setOnAction(e -> text.setAlignment(Pos.CENTER_LEFT));
        shiftLeft.setSelected(true);
        RadioButton shiftRight = new RadioButton();
        Label Right = new Label("Right", shiftRight);
        shiftRight.setOnAction(e-> text.setAlignment(Pos.CENTER_RIGHT));
        shiftRight.setToggleGroup(options);
        RadioButton shiftCenter = new RadioButton();
        Label Center = new Label("Center", shiftCenter);
        shiftCenter.setOnAction(e-> text.setAlignment(Pos.CENTER));
        shiftCenter.setToggleGroup(options);

        TextField tfColumnSize = new TextField();
        tfColumnSize.setPrefColumnCount(3);
        tfColumnSize.setText("12");
        tfColumnSize.setOnAction(e->text.setPrefColumnCount(Integer.parseInt(tfColumnSize.getText())));
        Label ColumnSize = new Label("Column Size", tfColumnSize);
        ColumnSize.setContentDisplay(ContentDisplay.RIGHT);

        HBox container = new HBox(Left, Center, Right, ColumnSize);
        container.setSpacing(15);
        container.setPadding(new Insets(10, 10, 7, 10));
        pane.add(container, 0, 1);

        primaryStage.setScene(new Scene(pane));
        primaryStage.setTitle("Test the TextField!");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}