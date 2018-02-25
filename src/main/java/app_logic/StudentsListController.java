package app_logic;

import bd.Teacher;
import javafx.beans.property.ReadOnlyLongWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.control.*;
import mapping.OcenyKoncoweEntity;
import mapping.PrzedmiotyEntity;
import mapping.RealizacjeEntity;
import mapping.StudenciEntity;
import oracle.sql.NUMBER;

public class StudentsListController implements Initializable {

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Button button1;

    @FXML
    private TableView tableViewFinalDegree;

    @FXML
    private TableColumn<OcenyKoncoweEntity, String> tableViewFinalDegree_nr_index;

    @FXML
    private TableColumn<OcenyKoncoweEntity, String> tableViewFinalDegree_surname;

    @FXML
    private TableColumn<OcenyKoncoweEntity, String> tableViewFinalDegree_name;

    @FXML
    private TableColumn<OcenyKoncoweEntity, Number> tableViewFinalDegree_fdegree;



    public StudentsListController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
    }
    public void setTableViewFinalDegree(ArrayList<OcenyKoncoweEntity> final_degree) {
        for ( OcenyKoncoweEntity yyy: final_degree) {
            System.out.println(yyy);
        }
        ObservableList obList2 = FXCollections.observableList(final_degree);

        tableViewFinalDegree.setItems(obList2);
        tableViewFinalDegree_nr_index.setCellValueFactory(cellData  -> new ReadOnlyStringWrapper(cellData.getValue().getStudenciByIdStudenta().getNrAlbumu()));
        tableViewFinalDegree_surname.setCellValueFactory(cellData  -> new ReadOnlyStringWrapper(cellData.getValue().getStudenciByIdStudenta().getNazwisko()));
        tableViewFinalDegree_name.setCellValueFactory(cellData  -> new ReadOnlyStringWrapper(cellData.getValue().getStudenciByIdStudenta().getImie()));
        tableViewFinalDegree_fdegree.setCellValueFactory(cellData  -> new ReadOnlyLongWrapper(cellData.getValue().getOcenaKoncowa()));

    }

}
