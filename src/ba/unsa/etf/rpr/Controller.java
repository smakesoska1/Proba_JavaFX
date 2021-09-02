package ba.unsa.etf.rpr;

import com.sun.glass.ui.CommonDialogs;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class Controller {
    public TextArea textArea;

    public void akcijaKraj(ActionEvent actionEvent) {
        System.exit(0);

    }

    public void actionOpen(ActionEvent actionEvent) {
        FileChooser izbornik=new FileChooser();
        izbornik.setTitle("Izberite datoteku");
        izbornik.getExtensionFilters().add(new FileChooser.ExtensionFilter("Tekstualna datoteka","*.txt"));
        File izabrani=izbornik.showOpenDialog(textArea.getScene().getWindow());
        try {
            String tekst= new String(Files.readAllBytes(izabrani.toPath()));
            textArea.setText(tekst);
        } catch (IOException e) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Doslo je do greske prilikom citanja"+izabrani.getName());
            alert.setContentText(e.getMessage());
            alert.setTitle("Ne mogu da otvorim datoteku");
            alert.showAndWait();
        }
    }

    public void openNewWindow(ActionEvent actionEvent) throws IOException {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/properties.fxml"));
        stage.setTitle("Properties");
        stage.setScene(new Scene(root, 600, 550));
        stage.setResizable(false);
        stage.show();
    }
}
