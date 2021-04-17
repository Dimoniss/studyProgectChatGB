package controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ChatWindowController {

    private String messages = "";

    @FXML
    private AnchorPane ap_chat_window;

    @FXML
    private TextField tf_enter_message;

    @FXML
    private TextArea ta_display_chat;

    @FXML
    private Button btn_send_message, btn_exit;


    @FXML
    void exit(ActionEvent event) {
        Stage stage = (Stage) btn_exit.getScene().getWindow();
        stage.close();
    }

    @FXML
    void sendMessageEnter(KeyEvent event){
        if (event.getCode() == KeyCode.ENTER) {
            sendText();
        }

    }

    @FXML
    void sendMessage(ActionEvent event) {
        sendText();

    }

    private void sendText() {

        if (!tf_enter_message.getText().trim().equals("")) {
            ta_display_chat.appendText("\n");
            ta_display_chat.appendText(tf_enter_message.getText().trim());
            tf_enter_message.clear();
        }


    }

    @FXML
    void initialize() {


    }
}
