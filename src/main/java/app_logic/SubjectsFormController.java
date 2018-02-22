package app_logic;


import bd.Teacher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import mapping.PrzedmiotyEntity;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SubjectsFormController implements Initializable {

    @FXML
    private ComboBox comboBoxSubjects;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addToComboBox();
    }

    public void addToComboBox() {
        List subject_list=Teacher.getInstance().listPrzedmioty();
        List<String> list = new ArrayList<String>();
        for (Object tmp :subject_list) {
            //System.out.println(tmp.);
//            System.out.println(((PrzedmiotyEntity) tmp).getNazwa());
        }
        //subject_list.forEach((Object ttt) -> System.out.println(ttt.getClass().getKodPrzedmiotu()));
        //subject_list.forEach((subject.) -> list.add(subject));
        list.add("Item A");
        list.add("Item B");
        list.add("Item C");

        //ObservableList obList = FXCollections.observableList(list);
        ObservableList obList = FXCollections.observableList(subject_list);
        //comboBoxSubjects.getItems().clear();
        //comboBoxSubjects.setItems(obList.);
    }
}
