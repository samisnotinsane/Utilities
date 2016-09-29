package main.java.com.sameen;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by sameen on 08/08/2016.
 * Uses http://fixer.io/ for exchange rates.
 */

public class Converter extends Application {

    Stage window;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Currency converter");

        //GridPane with 10px padding around edge
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Label - constrains use (child, column, row)
        Label primaryCurrencyLabel = new Label("GBP:");
        GridPane.setConstraints(primaryCurrencyLabel, 0, 0);

        // Input field
        TextField primaryCurrencyInput = new TextField();
        primaryCurrencyInput.setDisable(true);
        GridPane.setConstraints(primaryCurrencyInput, 1, 0);

        
        Label secondaryCurrencyLabel = new Label("EUR:");
        GridPane.setConstraints(secondaryCurrencyLabel, 0, 1);

        //Password Input
        TextField secondaryCurrencyInput = new TextField();
        secondaryCurrencyInput.setDisable(true);
        GridPane.setConstraints(secondaryCurrencyInput, 1, 1);

        // Button
        Button getRatesButton = new Button("Get rate");
        GridPane.setConstraints(getRatesButton, 1, 2);

        getRatesButton.setOnAction((event) -> {
            // Button was clicked, do something...
//            outputTextArea.appendText("Button Action\n");
            System.out.println("Get rates clicked!");

            Runnable downloadTask = () -> {
                System.out.println("Executing download thread.");
                // invoke download methods
                secondaryCurrencyInput.setText(DownloadTask.getEur());
            };
            Thread downloadThread1 = new Thread(downloadTask);
            downloadThread1.run();
        });

        //Add everything to grid
        grid.getChildren().addAll(primaryCurrencyLabel, primaryCurrencyInput, secondaryCurrencyLabel, secondaryCurrencyInput, getRatesButton);

        Scene scene = new Scene(grid, 240, 120);
        window.setScene(scene);
        window.show();

    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
