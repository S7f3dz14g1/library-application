package item;

import bookDetalist.BookDetailsController;
import bookDetalist.BookDetailsModel;
import bookList.BookListController;
import helpers.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.text.Text;
import mainWindow.MainWindowController;

import java.io.IOException;

public class ItemController {

    @FXML
    private Text titleBook;

    @FXML
    private Text authorBook;

    public void setTitle(String title){
        titleBook.setText(title);
    }

    public void setAuthor(String author){
        authorBook.setText(author);
    }

    public void onClickedDetalis(ActionEvent actionEvent) {
        FXMLLoader loaderMainWindow = new FXMLLoader(this.getClass().getResource("/fxml/MainWindow.fxml"));
        FXMLLoader loaderBookDetails = new FXMLLoader(this.getClass().getResource("/fxml/BookDetails.fxml"));
        try {
            loaderMainWindow.load();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        MainWindowController controllerMain=loaderMainWindow.getController();

        try {
            controllerMain.setScreen(loaderBookDetails.load());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        BookDetailsController controllerBook=loaderBookDetails.getController();
        controllerBook.setBookDetalist(titleBook.getText());

    }
}
