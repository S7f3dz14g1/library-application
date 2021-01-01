package bookDetalist;

import bookList.BookListController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import models.LibraryBook;

public class BookDetailsController {

    @FXML
    private Text titleBook;

    @FXML
    private Text authorsBook;

    @FXML
    private Text ratingBook;

    @FXML
    private Text popularityBook;

    @FXML
    private Text pagesBook;

    @FXML
    private Text yearBook;

    @FXML
    private Text publisherBook;

    private BookDetailsModel model;

    private VBox parent;

    private VBox bookList;

    public void initialize() {
        model=new BookDetailsModel(this);
    }

    public void setBookDetalist(String title){
        LibraryBook libraryBook=model.getBook(title);
        titleBook.setText(libraryBook.getTitle());
        authorsBook.setText(libraryBook.getAuthors());
        ratingBook.setText(libraryBook.getRating()+"");
        popularityBook.setText(libraryBook.getPopularity()+"");
        pagesBook.setText(libraryBook.getPages()+"");
        yearBook.setText(libraryBook.getYear()+"");
        publisherBook.setText(libraryBook.getPublisher());
    }

    public void onClickedBack(ActionEvent actionEvent) {
        parent.getChildren().clear();
        parent.getChildren().add(bookList);
    }

    public void setParent(VBox parent) {
        this.parent = parent;
    }

    public void setBookList(VBox bookList) {
        this.bookList = bookList;
    }

}
