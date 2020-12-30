package bookDetalist;

import api.ApiConfig;
import models.LibraryBook;

import java.util.List;

public class BookDetailsModel {

    private BookDetailsController controller;

    private LibraryBook book;

    private ApiConfig apiConfig;


    public BookDetailsModel(BookDetailsController controller) {
        this.controller = controller;
        apiConfig = new ApiConfig();
    }

    public LibraryBook getBook(String title) {
        List<LibraryBook> books = apiConfig.getBooks();
        for (LibraryBook book : books)
            if (book.getTitle().equals(title)){
                this.book = book;
                break;
            }
        return book;
    }
}
