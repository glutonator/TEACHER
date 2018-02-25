package app_logic;

import bd.Teacher;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.*;
import mapping.RealizacjeEntity;

public class StudentsListController implements Initializable {

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    public StudentsListController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setLabel1() {
        label1.setText("jjjjjjjj");
    }

    public void setLabel(Label label, String text) {
        label.setText(text);
    }

    public void setAllLabels(RealizacjeEntity realizacjeEntity) {
        setLabel(label1,realizacjeEntity.getKodPrzedmiotu());
        setLabel(label2,String.valueOf(realizacjeEntity.getRok()));
        setLabel(label3,realizacjeEntity.getRodzajSemestru());
    }

    public void onClickButton() {
        Teacher.getInstance().listOcenyKoncowe();
    }
}
