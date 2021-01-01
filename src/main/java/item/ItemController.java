package item;

import bookDetalist.BookDetailsController;
import bookList.BookListModel;
import informationBox.InformationBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ItemController implements Initializable {

    @FXML
    private Text titleBook;

    @FXML
    private Text authorBook;

    @FXML
    private Button borrow;

    private VBox parent;

    private VBox bookList;

    private ItemModel model;

   @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.model=new ItemModel(this);
    }

    public void setBookList(VBox bookList) {
        this.bookList = bookList;
    }

    public void setTitle(String title){
        titleBook.setText(title);
    }

    public void setAuthor(String author){
        authorBook.setText(author);
    }

    public void onClickedDetalis(ActionEvent actionEvent) {
        FXMLLoader loaderBookDetails = new FXMLLoader(this.getClass().getResource("/fxml/BookDetails.fxml"));
        try {
            setScreen(loaderBookDetails.load());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        BookDetailsController controllerBook=loaderBookDetails.getController();
        controllerBook.setParent(parent);
        controllerBook.setBookList(bookList);
        controllerBook.setBookDetalist(titleBook.getText());
    }

    public void setParent(VBox parent) {
        this.parent = parent;
    }

    public void setScreen(VBox pane) {
        parent.getChildren().clear();
        parent.getChildren().add(pane);
    }

    public void OnClickedBorrow(MouseEvent mouseEvent) {
       model.borrowBook();
     }

    public void showInformationWindow(){
        InformationBox.infoBox("Wszystkie egzemplarze tej książki został wypożyczone");
    }

    public void setToken(String token){
       model.setToken(token);
    }

    public void setIdBook(String idBook) {
        model.setIdBook(idBook);
    }
}
