package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
	private Cart cart;
	
	@FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;
    
    @FXML
    private Label costLabel;
    
    @FXML
    private Button placeOrder;
	
	@FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;
    
    @FXML
    private TableColumn<Media, Float> colMediaCost;
    
    @FXML
    void placeOrderPressed(ActionEvent event) {
    	cart.place();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order created");
        alert.setHeaderText(null);
        alert.showAndWait();
    }
    
    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        costLabel.setText(cart.totalCost() + " $");
    }
    
    @FXML
    void btnPlayPressed(ActionEvent event) throws PlayerException {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        Alert alert;
        ((Playable)media).play();
		alert = new Alert(Alert.AlertType.NONE);
		alert.setTitle("Playing");
		alert.setHeaderText(null);
		alert.getDialogPane().getButtonTypes().add(ButtonType.OK);
		alert.showAndWait();
        
    }

    public CartScreenController(Cart cart) {
    	super();
    	this.cart = cart;
    }

    @FXML
    private void initialize() {
    	colMediaTitle.setCellValueFactory(
    			new PropertyValueFactory<Media, String>("title"));
    	colMediacategory.setCellValueFactory(
    			new PropertyValueFactory<Media, String>("category"));
    	colMediaCost.setCellValueFactory(
    			new PropertyValueFactory<Media, Float>("cost"));
    	tblMedia.setItems(this.cart.getItemsOrdered());
    	
    	btnPlay.setVisible(false);
    	btnRemove.setVisible(false);
    	
    	tblMedia.getSelectionModel().selectedItemProperty().addListener(
    			new ChangeListener<Media>() {
    				
    				@Override
    				public void changed(ObservableValue<? extends Media> observable, Media oldValue, 
    						Media newValue) {
    					if(newValue != null) {
    						updateButtonBar(newValue);
    					}	
    				}
				});
    }
    
    void updateButtonBar(Media media) {
    	btnRemove.setVisible(true);
    	if(media instanceof Playable) {
    		btnPlay.setVisible(true);
    	} else {
    		btnPlay.setVisible(false);
    	}
    }
    
    public static void main(String[] args) {
		new CartScreen(new Cart());
	}
}
