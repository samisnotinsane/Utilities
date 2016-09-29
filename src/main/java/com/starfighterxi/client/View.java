package main.java.com.starfighterxi.client;

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
import javafx.stage.Stage;

public class View extends Application {

    TextArea txtViewMsg = null;
    TextArea txtSendMsg = null;
    Button btnSend = null;
    public static String contactName = "CONTACT_NAME_NOT_INIT";

    @Override
    public void start(Stage stage) throws Exception{
        Scene scene = new Scene(new Group());
        stage.setTitle("Messaging");

        // --- Top menu bar
        MenuBar menuBar = new MenuBar();

        // --- Menu options in the bar
        Menu menuFile = new Menu("File");
        MenuItem mnuExit = new MenuItem("Exit");
        mnuExit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                System.exit(0);
            }
        });
        menuFile.getItems().add(mnuExit);
        Menu menuEdit = new Menu("Edit");
        Menu menuView = new Menu("View");
        Menu menuHelp = new Menu("Help");
        MenuItem mnuAbout = new MenuItem("About");
        mnuAbout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showError("This feature is not yet available!");
            }
        });
        menuHelp.getItems().add(mnuAbout);
        menuBar.getMenus().addAll(menuFile, menuHelp);

        // contact name label
        final Label label = new Label(contactName);
        label.setFont(new Font("Arial", 15));

        // message view initialisation
        txtViewMsg = new TextArea();
        txtViewMsg.setPrefSize(400, 200);
        txtViewMsg.setEditable(false);

        // send message textbox and button initialisation
        txtSendMsg = new TextArea();
        txtSendMsg.setPrefSize(300, 100);
        txtSendMsg.setEditable(true);
        txtSendMsg.setPromptText("Enter text here...");

        btnSend = new Button("Send");
        btnSend.setPrefSize(100, 100);

        // send button event handler
        btnSend.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println("[DEBUG]: Handing send button");
                showError("This feature is not yet available!");
            }
        });

        // vertical alignment
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(0, 0, 0, 0));

//      horizontal alignment
        final HBox hbox = new HBox();
        hbox.setSpacing(5);
        hbox.setPadding(new Insets(0, 0, 10, 0));

        // send message area padding
        final HBox txtBox = new HBox();
        txtBox.setSpacing(2);
        txtBox.getChildren().add(txtSendMsg);

        // send button area padding
        final HBox btnBox = new HBox();
        btnBox.setSpacing(2);
        btnBox.getChildren().add(btnSend);

        hbox.getChildren().addAll(txtBox, btnBox);

//        innerHbox.setAlignment(Pos.BASELINE_LEFT);
//        hbox.setAlignment(Pos.BASELINE_RIGHT);
//
//        innerHbox.getChildren().add(btnFilePicker);
//        hbox.getChildren().addAll(innerHbox, btnDecrypt, btnEncrypt);

        vbox.getChildren().addAll(menuBar, label, txtViewMsg, hbox);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        stage.setScene(scene);
        stage.show();
    }

    public static void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
