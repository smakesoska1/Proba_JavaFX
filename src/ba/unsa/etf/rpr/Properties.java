package ba.unsa.etf.rpr;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Properties {

    public Button btnCancel;
    public TextField fildIme;
    public TextField fildPrezime;
   

    public void actionClose(ActionEvent actionEvent) {
        Stage stage=(Stage)btnCancel.getScene().getWindow();
        stage.close();

    }

    public void actionSubmit(ActionEvent actionEvent) {
        if(!validiraj())
            return;
    }

        private boolean validiraj(){
        boolean sveIspravno=true;
            if(fildIme.getText().isEmpty()){
                Alert upozorenje=new Alert(Alert.AlertType.ERROR);
                upozorenje.setTitle("Ime ne moze biti prazno");
                upozorenje.showAndWait();
                fildIme.requestFocus();
                fildIme.getStyleClass().removeAll("poljeIspravno");
                fildIme.getStyleClass().add("poljeNeispravno");
                sveIspravno=false;

        } else{
                fildIme.getStyleClass().removeAll("poljeNeispravno");
                fildIme.getStyleClass().add("poljeIspravno");

            }
            if(fildPrezime.getText().isEmpty()){
                Alert upozorenje=new Alert(Alert.AlertType.ERROR);
                upozorenje.setTitle("Prezime ne moze biti prazno");
                upozorenje.showAndWait();
                fildPrezime.requestFocus();
                fildPrezime.getStyleClass().removeAll("poljeIspravno");
                fildPrezime.getStyleClass().add("poljeNeispravno");
                sveIspravno=false;

            }
            else{
                fildPrezime.getStyleClass().removeAll("poljeNeispravno");
                fildPrezime.getStyleClass().add("poljeIspravno");

            }
            return sveIspravno;

    }
}
