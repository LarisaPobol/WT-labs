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
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

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
    @FXML
    private TextField textFieldSearch;

    private ArrayList<ListView<ObjectCreator>> objectsLists;
    private ToggleGroup radioGroup;
    private Controller controller;
    private ControlsManager controlsManager;

    /**
     * creates controls according selected class of object
     */
    private void createControls() {
        controlsManager.clearControls(vBoxObjectFields);
        if (radioGroup.getSelectedToggle() != null) {
            int indexSelected = radioGroup.getToggles().indexOf(radioGroup.getSelectedToggle());
            var factory = controller.getObjectFactory();
            ObjectCreator newObj = factory.get(indexSelected).Create();
            ArrayList<ArrayList<ObjectCreator>> allObjectsLists = controller.getAllObjectsLists();
            try {
                controlsManager.setDataInControls(vBoxObjectFields, newObj, allObjectsLists);
            } catch (IllegalAccessException e) {
                showAlert("Error", "some problems with tjis program", "try again please");
            }
        }
    }

    @FXML
    public void initialize() {
        controller = new Controller();
        controlsManager = new ControlsManager();
        radioGroup = new ToggleGroup();
        radioGroup.selectedToggleProperty().addListener((ov, old_toggle, new_toggle) -> {
            createControls();
        });
        var factory = controller.getObjectFactory();
        RadioButton[] radioGroupArray = controlsManager.createRadioGroup(factory, radioGroup);
        vBoxRadioGroupClassNames.getChildren().addAll(radioGroupArray);
        createTabs();
    }

    /**
     * shows alert with entered title, header and content
     * @param title
     * @param header
     * @param content
     */
    public void showAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    /**
     * creates tabs with listwiews that contain lists of objects
     */
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

    /**
     * fills choiceBox with coparators according to selected class
     */
    public void fillComparators() {
        int index = tabPaneObjects.getSelectionModel().getSelectedIndex();
        ArrayList<Comparator> comparators = controller.getComparatorFactory().get(index);
        ObservableList<Comparator> list = FXCollections.observableArrayList(comparators);
        choiceBoxFilter.setItems(list);
    }

    /**
     * update listwiev in selected tab
     */
    public void updateTab() {
        int index = tabPaneObjects.getSelectionModel().getSelectedIndex();
        ObservableList<ObjectCreator> list = FXCollections.observableArrayList(controller.getCurrObjectsListByIndex(index));
        objectsLists.get(index).setItems(list);
    }

    /**
     * fills choswn listview with sorted list of objects
     * @param event
     */
    @FXML
    private void clickSort(ActionEvent event) {
        int listIndex = tabPaneObjects.getSelectionModel().getSelectedIndex();
        int comparatorIndex = choiceBoxFilter.getSelectionModel().getSelectedIndex();
        if (comparatorIndex != -1) {
            ArrayList<ObjectCreator> sortedList = controller.GetSortedListOFCurrObjects(listIndex, comparatorIndex);
            int index = tabPaneObjects.getSelectionModel().getSelectedIndex();
            ObservableList<ObjectCreator> list = FXCollections.observableArrayList(sortedList);
            objectsLists.get(index).setItems(list);
        } else {
            showAlert("Warning", "no comparator selected", "choose comparator and try again");
        }
    }

    /**
     * creates new object using data from controls
     * updates listview with objects of chosen type
     * adds object to objects of chosen type
     * @param event
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     */
    @FXML
    private void clickCreate(ActionEvent event) throws IllegalAccessException, ClassNotFoundException {
        int indexSelected = radioGroup.getToggles().indexOf(radioGroup.getSelectedToggle());
        var factory = controller.getObjectFactory();
        if (indexSelected != -1) {
            ObjectCreator newObj = factory.get(indexSelected).Create();
            ArrayList<ArrayList<ObjectCreator>> allObjectsLists = controller.getAllObjectsLists();
            ObjectCreator newObj1 = controlsManager.getDataFromControls(newObj, allObjectsLists);
            controller.AddObject(indexSelected, newObj1);
            updateTab();
            controlsManager.clearControls(vBoxObjectFields);
            createControls();
            tabPaneObjects.getSelectionModel().select(indexSelected);
        } else {
            showAlert("Warning", "no type selected", "choose type of the object and try again");
        }
    }

    /**
     * update information about selected object using data from controls
     * updates listview with objects of chosen type
     * @param event
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     */
    @FXML
    private void clickUpdate(ActionEvent event) throws ClassNotFoundException, IllegalAccessException {
        int listIndex = tabPaneObjects.getSelectionModel().getSelectedIndex();
        int index = objectsLists.get(listIndex).getSelectionModel().getSelectedIndex();
        if ((listIndex != -1) && (index != -1)) {
            ObjectCreator edtObj = controller.getObjectByIndexes(listIndex, index);
            ArrayList<ArrayList<ObjectCreator>> allObjectsLists = controller.getAllObjectsLists();
            ObjectCreator newObj1 = controlsManager.getDataFromControls(edtObj, allObjectsLists);
            updateTab();
            controlsManager.clearControls(vBoxObjectFields);
        } else {
            showAlert("Warning", "no object selected", "choose object and try again");
        }
    }

    /**
     * deletes selected selected object from lists of current objects
     * updates listview with objects of chosen type
     * @param event
     * @throws IllegalAccessException
     */
    @FXML
    private void clickDelete(ActionEvent event) throws IllegalAccessException {
        int listIndex = tabPaneObjects.getSelectionModel().getSelectedIndex();
        int objIndex = objectsLists.get(listIndex).getSelectionModel().getSelectedIndex();
        if ((listIndex != -1) && (objIndex != -1)) {
            controller.DeleteObject(listIndex, objIndex);
            updateTab();
            controlsManager.clearControls(vBoxObjectFields);
        } else {
            showAlert("Warning", "no object selected", "choose object and try again");
        }
    }

    /**
     * opens file
     * updates listviews with objects
     * @param event
     */
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

    /**
     * saves data to file using controller
     * @param event
     */
    @FXML
    private void SaveToFile(ActionEvent event) {
        controller.WriteToSource("file.xml");
    }

    /**
     * searches for object that equals to enetered in textField string
     * @param event
     * @throws IllegalAccessException
     */
    @FXML
    private void clickSearch(ActionEvent event) throws IllegalAccessException {
        int indexSelected = radioGroup.getToggles().indexOf(radioGroup.getSelectedToggle());
        String strToFind = textFieldSearch.getText();
        int indexFounded = controller.search(indexSelected, strToFind);
        if (indexFounded != -1) {
            ObjectCreator obj = controller.getObjectByIndexes(indexSelected, indexFounded);
            ArrayList<ArrayList<ObjectCreator>> allObjectsLists = controller.getAllObjectsLists();
            int listIndex = controller.getListIndexByObject(obj);
            controlsManager.setDataInControls(vBoxObjectFields, obj, allObjectsLists);
            tabPaneObjects.getSelectionModel().select(listIndex);
            objectsLists.get(listIndex).getSelectionModel().select(indexFounded);
        } else {
            showAlert("Error!", "No result", "Such object does not exist");
        }
    }
}
