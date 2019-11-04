package ViewLayer.Controllers;

import Beans.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

public class ControlsManager {

    private ArrayList<Class> classArray;

    private ArrayList<Control> controls;

    public ControlsManager() {
        this.controls = new ArrayList<Control>();
        classArray = new ArrayList<Class>(
                Arrays.asList(BonusCard.class, Catalog.class, Customer.class, Item.class, RegularCustomer.class, ShoppingCart.class)
        );
    }

    public ObjectCreator getDataFromControls(ObjectCreator obj, ArrayList<ArrayList<ObjectCreator>> allObjects) throws ClassNotFoundException, IllegalAccessException {
        Class objClass = obj.getClass();
        Field[] objFields = objClass.getDeclaredFields();
        int k = 0;
        for (int i = 1; i < controls.size(); i += 2) {
            objFields[k].setAccessible(true);
            int classIndex = classArray.lastIndexOf(objFields[k].getType());
            if (classIndex == -1) {
                Object objFieldValue = ((TextInputControl) (controls.get(i))).getText();
                switch (objFields[k].getType().getTypeName()) {
                    case "java.lang.Integer": {
                        Integer intVal = Integer.parseInt(objFieldValue.toString());
                        try {
                            objFields[k].set(obj, intVal);
                        } catch (NumberFormatException ex) {
                            objFields[k].set(obj, null);
                        }
                        break;
                    }
                    case "java.lang.Float": {
                        Float floatVal = Float.parseFloat(objFieldValue.toString());
                        try {
                            objFields[k].set(obj, floatVal);
                        } catch (NumberFormatException ex) {
                            objFields[k].set(obj, null);
                        }
                        break;
                    }
                    default: {
                        Type fieldType = objFields[k].getType();
                        Class fieldClass = Class.forName(fieldType.getTypeName());
                        objFields[k].set(obj, (fieldClass.cast(objFieldValue)));
                    }
                }
            } else {
                int objIndex = ((ChoiceBox) (controls.get(i))).getSelectionModel().getSelectedIndex();
                if (objIndex != -1) {
                    objFields[k].set(obj, allObjects.get(classIndex).get(objIndex));
                } else {
                    objFields[k].set(obj, null);
                }
            }
            k++;
        }
        return obj;
    }

    public void setDataInControls(VBox vBoxobjectFields, ObjectCreator obj, ArrayList<ArrayList<ObjectCreator>> allObjects) throws  IllegalAccessException {
        clearControls(vBoxobjectFields);
        Class objClass = obj.getClass();
        Field[] objFields = objClass.getDeclaredFields();
        int k = 0;
        for (Field field : objFields
        ) {
            objFields[k].setAccessible(true);
            int classIndex = classArray.lastIndexOf(field.getType());
            if (classIndex == -1) {
                Label newLabel = new Label(field.getName());
                controls.add(newLabel);
                TextField newTextField = new TextField();
                controls.add(newTextField);
                if (objFields[k].get(obj) != null) {
                    newTextField.setText(objFields[k].get(obj).toString());
                }
            } else {
                Type type = field.getType();
                Label newLabel = new Label(field.getName());
                controls.add(newLabel);
                ChoiceBox newChoiseBox = new ChoiceBox();
                ObservableList<ObjectCreator> list = FXCollections.observableArrayList();
                list.addAll(allObjects.get(classIndex));
                newChoiseBox.setItems(list);
                int objIndex = allObjects.get(classIndex).indexOf(objFields[k].get(obj));
                if (objIndex != -1) {
                    newChoiseBox.setValue(allObjects.get(classIndex).get(objIndex));
                }
                controls.add(newChoiseBox);
            }
            k++;
        }
        vBoxobjectFields.getChildren().addAll(controls);
    }

    public void clearControls(VBox vBoxobjectFields) {
        vBoxobjectFields.getChildren().removeAll(controls);
        controls.clear();
    }

}