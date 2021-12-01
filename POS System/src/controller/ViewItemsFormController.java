package controller;

import bo.BOFactory;
import bo.custom.ViewItemsBO;
import dto.ItemDTO;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import view.tdm.ItemTm;

import java.util.ArrayList;

public class ViewItemsFormController {
    public TableView<ItemTm> tblItemDetailsView;
    public TableColumn colItemCode;
    public TableColumn colItemDescription;
    public TableColumn colItemSize;
    public TableColumn colItemQty;
    public TableColumn colUnitPrice;
    public TableColumn colBuyingPrice;
    private ViewItemsBO itemBO = (ViewItemsBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.VIEWITEMS);

    public void initialize() {
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colItemDescription.setCellValueFactory(new PropertyValueFactory<>("itemDescription"));
        colItemSize.setCellValueFactory(new PropertyValueFactory<>("size"));
        colItemQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colBuyingPrice.setCellValueFactory(new PropertyValueFactory<>("buyingPrice"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        getItemDetails();
    }

    public void getItemDetails() {
        tblItemDetailsView.getItems().clear();
        ArrayList<ItemDTO> allItems = itemBO.getAllItems();
        for (ItemDTO i : allItems
        ) {
            tblItemDetailsView.getItems().add(new ItemTm(i.getItemCode(), i.getItemDescription(), i.getSize(), i.getQty(), i.getBuyingPrice(), i.getUnitPrice()));
        }
    }
}
