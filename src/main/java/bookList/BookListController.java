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
    private VBox parent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model=new BookListModel(this);
    }

    public void setList(Button button,String title){
        List<LibraryBook> bookList=getBookList(button,title);
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

            /// do każdego elementu dodaj referencje do panelu rodzina - (ważne aby ustawić panel przed wywołaniem metody 'setList' bo pole 'parent' bedzie null)
            itemController.setParent(parent);
            listItem.getChildren().add(node[i]);
        }
    }

    private List<LibraryBook> getBookList(Button button,String title){
        switch (button){
            case Date:
                return model.getBooksSortByDate();
            case Tittle:
                return model.getBooksSortByTitle();
            case Ranting:
                return model.getBooksSortByRanting();
            case Discover:
                return model.getBookByDiscover();
            case Search:
                return model.getBooksByTitle(title);
            //case History:
          //      return null;
          //  case Reading:
          //      return null;
            case TopBooks:
                return model.getTopBook();
            default:
                return model.getTopBook();
        }

    }


    public void setPane(VBox box) {
        parent = box;
    }
}
