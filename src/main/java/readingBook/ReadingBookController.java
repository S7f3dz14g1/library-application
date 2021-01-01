package readingBook;

import informationBox.InformationBox;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ReadingBookController implements Initializable {

    @FXML
    private Text idBook;

    @FXML
    private Text titleBook;

    @FXML
    private Text bookCopyId;

    @FXML
    private Text borrowDate;

    private ReadingBookModel model;

    private VBox parent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model=new ReadingBookModel(this);
    }

    public void onClickedReturn(MouseEvent mouseEvent) {
            model.returnBook(bookCopyId.getText());
    }

    public void showInformationWindow(){
        InformationBox.infoBox("The book was returned");
    }
    public void setToken(String token){
        model.setToken(token);
    }

    public void setIdBook(String idBook) {
        this.idBook.setText(idBook);
    }

    public void setTitleBook(String titleBook) {
        this.titleBook.setText(titleBook);
    }

    public void setBookCopyId(String  bookCopyId) {
        this.bookCopyId.setText(bookCopyId);
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate.setText(borrowDate);
    }

    public void setParent(VBox parent) {
        this.parent = parent;
    }
}
