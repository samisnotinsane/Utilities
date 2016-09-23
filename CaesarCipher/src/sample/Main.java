package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    private static final String RESULT_PROMPT_TEXT = "Input text or file to view results.";

    private Button btnEncrypt = new Button("Encrypt");
    private Button btnDecrypt = new Button("Decrypt");
    private Button btnFilePicker = new Button("Open File");
    private TextArea txtEncrypt = new TextArea();
    private TextArea txtDecrypt = new TextArea();
    private Label lblEncrypt = new Label("Input:");
    private Label lblDecrypt = new Label("Result:");

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new Group());
        stage.setTitle("Text encryption/decryption tool");

        final Label label = new Label("Text encryption/decryption tool");
        label.setFont(new Font("Arial", 20));
        txtDecrypt.setEditable(false);
        txtDecrypt.setPromptText(RESULT_PROMPT_TEXT);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 10, 0, 10));

        final HBox hbox = new HBox();
        final HBox innerHbox = new HBox();
        hbox.setSpacing(5);

        hbox.setPadding(new Insets(0, 0, 10, 0));
        innerHbox.setPadding(new Insets(0, 500, 0, 0));

        innerHbox.setAlignment(Pos.BASELINE_LEFT);
        hbox.setAlignment(Pos.BASELINE_RIGHT);

        innerHbox.getChildren().add(btnFilePicker);
        hbox.getChildren().addAll(innerHbox, btnDecrypt, btnEncrypt);

        vbox.getChildren().addAll(lblEncrypt, txtEncrypt, lblDecrypt, txtDecrypt, hbox);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);


        // Register an event handler for a node and a specific event type
        btnFilePicker.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println("File picker btn");
            }
        });

        btnDecrypt.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println("decrypting...");
            }
        });


        btnEncrypt.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println("encrypting...");
            }
        });





        stage.setScene(scene);
        stage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }
}
