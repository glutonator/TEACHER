package app_logic;

import bd.Teacher;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import mapping.OcenyEntity;
import mapping.OcenyKoncoweEntity;

import java.net.URL;
import java.util.ResourceBundle;

public class updateDegreeFormController  implements Initializable {

    @FXML
    private Label label;

    @FXML
    private Label label_temat;

    @FXML
    private Label label1;

    @FXML
    private Label label_waga;

    @FXML
    private Label label2;

    @FXML
    private TextField text_field2;

    @FXML
    private Label label3;

    @FXML
    private TextField text_field3;

    @FXML
    private Button button_ok;

    @FXML
    private Button button_cancel;

    private OcenyEntity ocenyEntity_tmp;

    public void setOcenyEntity_tmp(OcenyEntity ocenyEntity_tmp) {
        this.ocenyEntity_tmp = ocenyEntity_tmp;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void setLabel(Label label, String text) {
        label.setText(text);
    }

    public void setAllLabels(OcenyEntity ocenyEntity) {
        setLabel(label_temat,ocenyEntity.getTypyOcenByIdTypuOceny().getTemat());
        setLabel(label_waga,String.valueOf(ocenyEntity.getTypyOcenByIdTypuOceny().getWaga()));
        setTextFields(String.valueOf(ocenyEntity.getWartosc()),ocenyEntity.getKomentarz());
    }

    public void onClickOk () {
       Teacher.getInstance().updateDegree(ocenyEntity_tmp.getIdOceny() ,"oooo");
    }
    public void onClickCancel () {

    }
    public void setTextFields(String str1, String str2) {
        text_field2.setText(str1);
        text_field3.setText(str2);
    }

}
