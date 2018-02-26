package app_logic;

import javafx.beans.property.ReadOnlyLongWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import mapping.OcenyEntity;
import mapping.OcenyKoncoweEntity;
import mapping.RealizacjeEntity;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DegreesFormController implements Initializable {

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Button button1;

    @FXML
    private TableView<?> tableViewDegrees;

    @FXML
    private TableColumn<OcenyEntity, String> tableViewDegrees_1;

    @FXML
    private TableColumn<OcenyEntity, Number> tableViewDegrees_2;

    @FXML
    private TableColumn<OcenyEntity, Number> tableViewDegrees_3;

    @FXML
    private TableColumn<OcenyEntity, String> tableViewDegrees_4;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setLabel(Label label, String text) {
        label.setText(text);
    }

    public void setAllLabels(OcenyKoncoweEntity ocenyKoncoweEntity) {
        setLabel(label1,ocenyKoncoweEntity.getStudenciByIdStudenta().getNrAlbumu());
        setLabel(label2,ocenyKoncoweEntity.getStudenciByIdStudenta().getNazwisko());
        setLabel(label3,ocenyKoncoweEntity.getStudenciByIdStudenta().getImie());
    }

    public void setTableViewDegree(ArrayList<OcenyEntity> final_degree) {

        ObservableList obList2 = FXCollections.observableList(final_degree);

        tableViewDegrees.setItems(obList2);
        tableViewDegrees_1.setCellValueFactory(cellData  -> new ReadOnlyStringWrapper(cellData.getValue().getTypyOcenByIdTypuOceny().getTemat()));
        tableViewDegrees_2.setCellValueFactory(cellData  -> new ReadOnlyLongWrapper(cellData.getValue().getTypyOcenByIdTypuOceny().getWaga()));
        tableViewDegrees_3.setCellValueFactory(cellData  -> new ReadOnlyLongWrapper(cellData.getValue().getWartosc()));
        tableViewDegrees_4.setCellValueFactory(cellData  -> new ReadOnlyStringWrapper(cellData.getValue().getKomentarz()));

    }
}
