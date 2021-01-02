package item;

import api.ApiConfig;
import models.LibraryBook;

import java.util.List;

public class ItemModel {

    private ItemController controller;

    private ApiConfig apiConfig;

    private String token;

    private String idBook;

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }

    public ItemModel(ItemController controller) {
        this.controller = controller;
        apiConfig=new ApiConfig();
    }

    public void borrowBook(){
        try{
            apiConfig.borrowBook(idBook,token);

        }catch (Exception e){
            controller.showInformationWindow();
        }
    }

    public int getBooksCopies(){
        int copies=0;
        List<LibraryBook> bookList=apiConfig.getBooks();
        for (LibraryBook book:bookList){
            if(book.getId()+""==idBook)
                copies++;
        }
        return copies;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
