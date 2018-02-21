package app_logic;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

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
        List<String> list = new ArrayList<String>();
        list.add("Item A");
        list.add("Item B");
        list.add("Item C");
        ObservableList obList = FXCollections.observableList(list);
        //comboBoxSubjects.getItems().clear();
        comboBoxSubjects.setItems(obList);
    }
}
