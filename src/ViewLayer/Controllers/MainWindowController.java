package ViewLayer.Controllers;

import Beans.ObjectCreator;
import Controllers.Controller;
import Servises.Factory.ObjectCreatorFab;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Comparator;


public class MainWindowController {
    @FXML
    private VBox vBoxRadioGroupClassNames;
    @FXML
    private ChoiceBox choiceBoxFilter;
    @FXML
    private VBox vBoxObjectFields;
    @FXML
    private TabPane tabPaneObjects;

    private ArrayList<ListView<ObjectCreator>> objectsLists;
    private ToggleGroup radioGroup;
    private Controller controller;
    private ControlsManager controlsManager;


    @FXML
    public void initialize() {
        controller = new Controller();
        controlsManager = new ControlsManager();
        radioGroup = new ToggleGroup();
        radioGroup.selectedToggleProperty().addListener((ov, old_toggle, new_toggle) -> {
            controlsManager.clearControls(vBoxObjectFields);
            if (radioGroup.getSelectedToggle() != null) {
                int indexSelected = radioGroup.getToggles().indexOf(radioGroup.getSelectedToggle());
                var factory = controller.getObjectFactory();
                ObjectCreator newObj = factory.get(indexSelected).Create();
                ArrayList<ArrayList<ObjectCreator>> allObjectsLists = controller.getAllObjectsLists();
                // controlsManager.createControls(vBoxObjectFields, newObj, allObjectsLists);
                try {
                    controlsManager.setDataInControls(vBoxObjectFields, newObj, allObjectsLists);
                } catch (IllegalAccessException e) {
                    //e.printStackTrace();
                    showAlert("Error", "some problems with tjis program", "try again please");
                }
            }
        });
        for (ObjectCreatorFab item : controller.getObjectFactory()
        ) {
            String className = item.getClass().getName();
            RadioButton newRadioButton = new RadioButton(className);
            newRadioButton.setToggleGroup(radioGroup);
            vBoxRadioGroupClassNames.getChildren().add(newRadioButton);
        }
        createTabs();
    }

    public void showAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public void createTabs() {
        objectsLists = new ArrayList<ListView<ObjectCreator>>();
        for (ObjectCreatorFab item : controller.getObjectFactory()
        ) {
            Tab tab = new Tab();
            tab.setText(item.toString());
            ArrayList<ObjectCreator> newList = controller.addList();
            ListView<ObjectCreator> newListView = new ListView();
            objectsLists.add(newListView);
            tab.setContent(newListView);
            newListView.getSelectionModel().selectedItemProperty().addListener(
                    (observable, oldValue, newValue) -> {
                        try {
                            int listIndex = tabPaneObjects.getSelectionModel().getSelectedIndex();
                            if (listIndex != -1) {
                                int index = objectsLists.get(listIndex).getSelectionModel().getSelectedIndex();
                                if (index != -1) {
                                    ObjectCreator obj = controller.getObjectByIndexes(listIndex, index);
                                    ArrayList<ArrayList<ObjectCreator>> allObjectsLists = controller.getAllObjectsLists();
                                    controlsManager.setDataInControls(vBoxObjectFields, obj, allObjectsLists);
                                }
                            }
                        } catch (IllegalAccessException e) {
                            //e.printStackTrace();
                            showAlert("Error", "some problems with tjis program", "try again please");
                        }
                    });
            tabPaneObjects.getTabs().add(tab);
            tabPaneObjects.getSelectionModel().select(tab);
        }
        tabPaneObjects.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Tab>() {
                    @Override
                    public void changed(ObservableValue<? extends Tab> ov, Tab t, Tab t1) {
                        updateTab();
                        fillComparators();
                    }
                }
        );
    }

    public void fillComparators() {
        int index = tabPaneObjects.getSelectionModel().getSelectedIndex();
        ArrayList<Comparator> comparators = controller.getComparatorFactory().get(index);
        ObservableList<Comparator> list = FXCollections.observableArrayList(comparators);
        choiceBoxFilter.setItems(list);
    }

    public void updateTab() {
        int index = tabPaneObjects.getSelectionModel().getSelectedIndex();
        ObservableList<ObjectCreator> list = FXCollections.observableArrayList(controller.getCurrObjectsListByIndex(index));
        objectsLists.get(index).setItems(list);
    }

    @FXML
    private void clickSort(ActionEvent event) {
        int listIndex = tabPaneObjects.getSelectionModel().getSelectedIndex();
        int comparatorIndex = choiceBoxFilter.getSelectionModel().getSelectedIndex();
        ArrayList<ObjectCreator> sortedList = controller.GetSortedListOFCurrObjects(listIndex, comparatorIndex);

        int index = tabPaneObjects.getSelectionModel().getSelectedIndex();
        ObservableList<ObjectCreator> list = FXCollections.observableArrayList(sortedList);
        objectsLists.get(index).setItems(list);
    }

    @FXML
    private void clickCreate(ActionEvent event) throws IllegalAccessException, ClassNotFoundException {
        int indexSelected = radioGroup.getToggles().indexOf(radioGroup.getSelectedToggle());
        var factory = controller.getObjectFactory();
        ObjectCreator newObj = factory.get(indexSelected).Create();
        ArrayList<ArrayList<ObjectCreator>> allObjectsLists = controller.getAllObjectsLists();
        ObjectCreator newObj1 = controlsManager.getDataFromControls(newObj, allObjectsLists);
        controller.AddObject(indexSelected, newObj1);
        updateTab();
        controlsManager.clearControls(vBoxObjectFields);
    }

    @FXML
    private void clickUpdate(ActionEvent event) throws ClassNotFoundException, IllegalAccessException {
        int listIndex = tabPaneObjects.getSelectionModel().getSelectedIndex();
        int index = objectsLists.get(listIndex).getSelectionModel().getSelectedIndex();
        ObjectCreator edtObj = controller.getObjectByIndexes(listIndex, index);
        ArrayList<ArrayList<ObjectCreator>> allObjectsLists = controller.getAllObjectsLists();
        ObjectCreator newObj1 = controlsManager.getDataFromControls(edtObj, allObjectsLists);
        updateTab();
        controlsManager.clearControls(vBoxObjectFields);
    }

    @FXML
    private void clickDelete(ActionEvent event) {
        int listIndex = tabPaneObjects.getSelectionModel().getSelectedIndex();
        int objIndex = objectsLists.get(listIndex).getSelectionModel().getSelectedIndex();
        controller.DeleteObject(listIndex, objIndex);
        updateTab();
        controlsManager.clearControls(vBoxObjectFields);
    }

    @FXML
    private void OpenFile(ActionEvent event) {
        controller.ReadFromSource("file.xml");
        int i = 0;
        for (ArrayList<ObjectCreator> listItem : controller.getAllObjectsLists()
        ) {
            ObservableList<ObjectCreator> list = FXCollections.observableArrayList(listItem);
            objectsLists.get(i).setItems(list);
            i++;
        }
        updateTab();
    }

    @FXML
    private void SaveToFile(ActionEvent event) {
        controller.WriteToSource("file.xml");
    }

    @FXML
    private void clickSearch(ActionEvent event) {
    }


}
