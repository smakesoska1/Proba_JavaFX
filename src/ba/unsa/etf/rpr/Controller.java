package ba.unsa.etf.rpr;

import com.sun.glass.ui.CommonDialogs;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

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
}
