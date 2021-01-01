package historyBook;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class HistoryBookController {

    @FXML
    private Text idBook;

    @FXML
    private Text titleBook;

    @FXML
    private Text bookCopyId;

    @FXML
    private Text borrowDate;

    @FXML
    private Text returnedDate;

    private VBox parent;

    public void setIdBook(String idBook) {
        this.idBook.setText(idBook);
    }

    public void setParent(VBox parent) {
        this.parent = parent;
    }

    public void setTitleBook(String titleBook) {
        this.titleBook.setText(titleBook);
    }

    public void setBookCopyId(String bookCopyId) {
        this.bookCopyId.setText(bookCopyId);
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate.setText(borrowDate);
    }

    public void setReturnedDate(String returnedDate) {
        this.returnedDate.setText(returnedDate);
    }
}
