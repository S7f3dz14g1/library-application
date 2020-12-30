package bookList;

import models.LibraryBook;
import item.ItemController;
import helpers.Button;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BookListController implements Initializable {
    
    @FXML
    private VBox listItem;

    private BookListModel model;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model=new BookListModel(this);
    }

    public void setList(Button button){
        List<LibraryBook> bookList=getBookList(button);
        Node[] node=new Node[bookList.size()];
        for (int i = 0; i <bookList.size(); i++) {
            FXMLLoader loader= new  FXMLLoader(this.getClass().getResource("/fxml/Item.fxml"));
            try {
                node[i]= loader.load();
            }catch (Exception e){
            }
            ItemController itemController= loader.getController();
            itemController.setAuthor(bookList.get(i).getAuthors());
            itemController.setTitle(bookList.get(i).getTitle());
            listItem.getChildren().add(node[i]);
        }
    }

    private List<LibraryBook> getBookList(Button button){
        switch (button){
            case Date:
                return model.getBooksSortByDate();
            case Tittle:
                return model.getBooksSortByTitle();
            case Ranting:
                return model.getBooksSortByRanting();
            case Discover:
                return model.getBookByDiscover();
            default:
                return model.getTopBook();
        }

    }
}
