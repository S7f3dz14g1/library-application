package models;

import api.ApiConfig;
import api.LibraryBook;
import controllers.BookListController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class BookListModel {

    private String token;

    private BookListController controller;

    private ApiConfig apiConfig;

    private List<LibraryBook> bookList;


    public BookListModel(BookListController controller){
        this.controller=controller;
        apiConfig=new ApiConfig();
        setBookList();
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<LibraryBook> booksList(){
        return apiConfig.getBooks(token);
    }

    private void setBookList(){
        bookList=apiConfig.getBooks(token);
    }

    public List<LibraryBook> getBooksSortByTitle(){
        bookList.sort(Comparator.comparing(LibraryBook::getTitle));
        return bookList;
    }

    public List<LibraryBook>  getBooksSortByRanting(){
        bookList.sort(Comparator.comparing(LibraryBook::getRating));
        return bookList;
    }
    public List<LibraryBook>  getBooksSortByDate(){
        bookList.sort(Comparator.comparing(LibraryBook::getPublisher));
        return bookList;
    }
    public List<LibraryBook> getBookByTittle(String tittle){
        List<LibraryBook> helper=new ArrayList<>();
        for (LibraryBook book:bookList){
            if (book.getTitle().equals(tittle))
                helper.add(book);
        }
        return helper;
    }

    public LibraryBook getBookById(int id){
        for (LibraryBook book:bookList){
            if (book.getId()==id)
                return book;
        }
        return null;
    }

    public List<LibraryBook> getBookByDiscover(){
        List<LibraryBook> helper=new ArrayList<>();
        bookList.sort(Comparator.comparing(LibraryBook::getPopularity));
        for (LibraryBook book:bookList){
            helper.add(book);
            if (helper.size()==10)break;
        }
        return helper;
    }

    public List<LibraryBook> getTopBook(){
        List<LibraryBook> helper=new ArrayList<>();
        bookList.sort(Comparator.comparing(LibraryBook::getRating));

        for (LibraryBook book:bookList){
            helper.add(book);
            if (helper.size()==10)break;
        }
        return helper;
    }

    public List<LibraryBook> getBookByRating(){
        bookList.sort(Comparator.comparing(LibraryBook::getRating));
        return bookList;
    }

    public int getBooksCopies(int index){
        int copies=0;
        for (LibraryBook book:bookList){
            if(book.getId()==index)
                copies++;
        }
        return copies;
    }
}

