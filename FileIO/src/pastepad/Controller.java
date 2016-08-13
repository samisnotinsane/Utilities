package pastepad;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML private TextArea txtContent;
    @FXML private Button btnCopy, btnPaste, btnSave;


    public void onClickCopy() {
        System.out.println("onClickCopy() clicked");
    }

    public void onClickPaste() {
        System.out.println("onClickPaste() clicked");
//        txtContent.setText(Main.getClipboardText());
    }

    public void onClickSave() {
        System.out.println("onClickSave() clicked");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Main.refreshTextArea(txtContent);

        btnCopy = new Button();
        btnPaste = new Button();
        btnSave = new Button();
    }
}
