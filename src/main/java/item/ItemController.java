package item;

import bookDetalist.BookDetailsController;
import bookDetalist.BookDetailsModel;
import bookList.BookListController;
import helpers.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import mainWindow.MainWindowController;

import java.io.IOException;

public class ItemController {

    @FXML
    private Text titleBook;

    @FXML
    private Text authorBook;
    private VBox parent;
    public void setTitle(String title){
        titleBook.setText(title);
    }

    public void setAuthor(String author){
        authorBook.setText(author);
    }

    public void onClickedDetalis(ActionEvent actionEvent) {
        FXMLLoader loaderBookDetails = new FXMLLoader(this.getClass().getResource("/fxml/BookDetails.fxml"));
        try {
            setScreen(loaderBookDetails.load()); // jak zwykle czyszczenie zawartości rodzina i wrzucenie nowej zawartosci
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        BookDetailsController controllerBook=loaderBookDetails.getController();
        controllerBook.setBookDetalist(titleBook.getText());
    }

    public void setParent(VBox parent) {
        this.parent = parent;
    }

    public void setScreen(VBox pane) {
        parent.getChildren().clear();
        parent.getChildren().add(pane);
    }
}
