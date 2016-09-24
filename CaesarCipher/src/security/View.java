package security;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class View extends Application {

    private static final String RESULT_PROMPT_TEXT = "Input text or select file, then click encrypt/decrypt.";

    private Button btnEncrypt = new Button("Encrypt");
    private Button btnDecrypt = new Button("Decrypt");
    private Button btnFilePicker = new Button("Open File");
    private TextArea txtEncrypt = new TextArea();
    private TextArea txtDecrypt = new TextArea();
    private Label lblEncrypt = new Label("Input:");
    private Label lblDecrypt = new Label("Result:");

    private Cipher cyp = null;
    private String cipherText;

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new Group());
        stage.setTitle("Text encryption/decryption tool");

        final Label label = new Label("Text encryption/decryption tool");
        label.setFont(new Font("Arial", 20));
        txtDecrypt.setEditable(false);
        txtDecrypt.setWrapText(true);
        txtDecrypt.setPromptText(RESULT_PROMPT_TEXT);
        txtEncrypt.setWrapText(true);

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
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open file to encrypt/decrypt");
                File selectedFile = fileChooser.showOpenDialog(null);
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("Text Files", "*.txt"));
                if (selectedFile != null) {
                    File openedFile = selectedFile.getAbsoluteFile();
                    String fileText = "";
                    try {
                        fileText = Utility.readFileContents(openedFile);
                        System.out.println(fileText);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    showTextInInputArea(fileText);
                    System.out.println("File selected: " + selectedFile.getName());

                }
                else {
                    // File selection cancelled
                    System.out.println(".");
                }
            }
        });
        btnDecrypt.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println("decrypting...");
                if(cyp == null) {
                    System.out.println("No input text to decrypt!");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("No encrypted text was found for decryption! Please enter some text " +
                    "or choose a file to decrypt, then click 'Encrypt'");
                    alert.showAndWait();
                } else {
                    showTextInOutputArea(cyp.decrypt());
                }
            }
        });
        btnEncrypt.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println("encrypting...");
                cyp = new Cipher(Cipher.CAESAR_TECHNIQUE);
                cipherText = cyp.encrypt(getTextFromInputArea());
                showTextInOutputArea(cipherText);
            }
        });

        stage.setScene(scene);
        stage.show();
    }

    private void showTextInInputArea(String text) {
        txtEncrypt.setText(text);
    }

    private String getTextFromInputArea() {
        return txtEncrypt.getText();
    }

    private void showTextInOutputArea(String text) {
        txtDecrypt.setText(text);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
