package pastepad;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("pad.fxml"));
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setTitle("PastePad");
        primaryStage.setX(primaryScreenBounds.getMinX() + primaryScreenBounds.getWidth() - 200);
        primaryStage.setY(primaryScreenBounds.getMinY() + primaryScreenBounds.getHeight() - 3000);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    public static String getCurrentTimeAndDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy, HH:mm");
        Date date = new Date();
        return dateFormat.format(date);
    }

    // clears contents and sets time and date
    public static void refreshTextArea(TextArea txtArea) {
        txtArea.setWrapText(true);
        txtArea.setPromptText("Enter text here.");
        txtArea.setText("Created on: " + Main.getCurrentTimeAndDate().toString() + " \n");
        txtArea.positionCaret(txtArea.getLength());

    }

    // saves TextArea contents to a text file on desktop
    public static void savePadContents() {

    }

    public static String getClipboardText() {
        ClipboardContent clipboardContent = new ClipboardContent();
        return clipboardContent.getString();
    }

    public static void setClipboardText() {
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putString("Some text");
        clipboard.setContent(content);
    }

    public static void main(String[] args) {
        launch(args);
    }


    public static void saveText(String txtString) {


        // save text string to selected file
    }

}
