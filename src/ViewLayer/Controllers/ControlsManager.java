package viewLayer.controllers;

import beans.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * class that deals with controllers in view layer
 */
public class ControlsManager {

    private ArrayList<Class> classArray;

    private ArrayList<Control> controls;

    public ControlsManager() {
        this.controls = new ArrayList<Control>();
        classArray = new ArrayList<Class>(
                Arrays.asList(BonusCard.class, Catalog.class, Customer.class, Item.class, RegularCustomer.class, ShoppingCart.class)
        );
    }

    /**
     * creates array of radioButtons from ArrayList
     * @param array ArrayList of elements for radiobuttons
     * @param toggleGroup toggleGroup for radiobuttons
     * @return
     */
    public RadioButton[]  createRadioGroup (List array, ToggleGroup toggleGroup) {
        RadioButton[] radioArray = new RadioButton[array.size()];
        int i = 0;
        for (var item : array
        ) {
            String className = item.toString();
            RadioButton newRadioButton = new RadioButton(className);
            newRadioButton.setToggleGroup(toggleGroup);
            radioArray[i] = newRadioButton;
            i++;
        }
        return  radioArray;
    }

    /**
     * sets fields of object of entered class
     * gets information from controls
     * @param startIndex index of first control to get information
     * @param objClass class of object
     * @param obj object to set fields
     * @param allObjects all current objects
     * @return index of last used control
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     */
    public int  fillObject(int startIndex, Class objClass, ObjectCreator obj, ArrayList<ArrayList<ObjectCreator>> allObjects) throws IllegalAccessException, ClassNotFoundException {
    Field[] objFields = objClass.getDeclaredFields();
    int k = 0;
    int i = startIndex;

    for (k = 0; k < objFields.length; k++) {
        objFields[k].setAccessible(true);
        int classIndex = classArray.lastIndexOf(objFields[k].getType());
        if (classIndex == -1) {
            Object objFieldValue = ((TextInputControl) (controls.get(i))).getText();
            Object clazz = objFields[k].getType();
            Object o1 =  clazz  instanceof  Integer;

           switch (objFields[k].getType().getTypeName()) {
                case "java.lang.Integer": {
                    Integer intVal = Integer.parseInt(objFieldValue.toString());
                    try {
                        objFields[k].set(obj, intVal);
                    } catch (NumberFormatException ex) {
                        objFields[k].set(obj,0);
                    }
                    break;
                }
                case "java.lang.Float": {
                    try {
                        Float floatVal = Float.parseFloat(objFieldValue.toString());
                        objFields[k].set(obj, floatVal);
                    } catch (NumberFormatException ex) {
                        objFields[k].set(obj, 0.0);
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
        i+=2;
    }
    return i;
}

    /**
     * set data in object from controls
     * @param obj
     * @param allObjects
     * @return
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     */
    public ObjectCreator getDataFromControls(ObjectCreator obj, ArrayList<ArrayList<ObjectCreator>> allObjects) throws ClassNotFoundException, IllegalAccessException {
        Class objClass = obj.getClass();
        int startIndex = fillObject(1,objClass, obj, allObjects);
        Class superClass = obj.getClass().getSuperclass();
        if (superClass != ObjectCreator.class) {
        fillObject(startIndex,superClass, obj, allObjects);
        }
        return obj;
    }

    /**
     * creates controls according to class of entered object
     * @param objClass
     * @param obj
     * @param allObjects
     * @throws IllegalAccessException
     */
    public void  createControls (Class objClass, ObjectCreator obj, ArrayList<ArrayList<ObjectCreator>> allObjects) throws IllegalAccessException {
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
    }

    /**
     * sets data in controls from object's fields
     * @param vBoxobjectFields
     * @param obj
     * @param allObjects
     * @throws IllegalAccessException
     */
    public void setDataInControls(VBox vBoxobjectFields, ObjectCreator obj, ArrayList<ArrayList<ObjectCreator>> allObjects) throws  IllegalAccessException {
        clearControls(vBoxobjectFields);
        Class objClass = obj.getClass();
        createControls(objClass, obj, allObjects);
        Class superClass = obj.getClass().getSuperclass();
        createControls(superClass, obj, allObjects);
        vBoxobjectFields.getChildren().addAll(controls);
    }

    /**
     * deletes all controls
     * @param vBoxobjectFields vBox to clear
     */
    public void clearControls(VBox vBoxobjectFields) {
        vBoxobjectFields.getChildren().removeAll(controls);
        controls.clear();
    }

}
