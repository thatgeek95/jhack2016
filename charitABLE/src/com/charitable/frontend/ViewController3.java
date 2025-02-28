package com.charitable.frontend;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.charitable.backend.Charity;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewController3 implements Initializable{

    @FXML TextArea name;
    @FXML TextArea percentused;
    @FXML TextArea _location;
    @FXML TextArea distance;
    @FXML TextArea percent;
    
    @FXML
	private ListView<Charity> results_list;
	protected ListProperty<Charity> listProperty = new SimpleListProperty<>();

	//Double moneytodollar = Double.parseDouble(results_list.getSelectionModel().getSelectedItem().getGrantPaid()) / Double.parseDouble(results_list.getSelectionModel().getSelectedItem().getFuncExp());
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	results_list.itemsProperty().bind(listProperty);
    	listProperty.set(FXCollections.observableArrayList(Main.final_charities));
    	results_list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Charity>() {
			public void changed(ObservableValue<? extends Charity> observable, Charity old, Charity newOne) {
				int selectedIndex = results_list.getSelectionModel().getSelectedIndex();
				name.setText(results_list.getSelectionModel().getSelectedItem().getName());
				//percentused.setText(Double.toString(moneytodollar));
				_location.setText(results_list.getSelectionModel().getSelectedItem().getZip());
				distance.setText(Double.toString(results_list.getSelectionModel().getSelectedItem().getDistance()));
				percent.setText(Double.toString(results_list.getSelectionModel().getSelectedItem().getRank()));
			}
		});
		results_list.getSelectionModel().select(0);
	}


}
