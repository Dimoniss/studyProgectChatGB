package controllers;

import java.io.IOException;
import java.util.Objects;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class StartPageController {


    @FXML
    void openChat(ActionEvent event) throws IOException {
        Parent root;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("chat_window.fxml")));
            Stage stage = new Stage();
            stage.setTitle("My New Stage Title");
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);

            stage.setScene(new Scene(root, 600, 400));

            stage.addEventHandler(KeyEvent.KEY_RELEASED, (KeyEvent keyEvent) -> {
            if (KeyCode.ESCAPE == keyEvent.getCode()) {
                stage.close();
            }

        });

            stage.showAndWait();

            // Hide this current window
//            ((Node)(event.getSource())).getScene().getWindow().hide();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {



    }
}
