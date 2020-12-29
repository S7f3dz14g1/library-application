package models;

import api.ApiConfig;
import api.LibraryBook;
import controllers.MainWindowController;

import java.util.List;

public class MainWindowModel {

    private String token;

    private MainWindowController controller;

    private ApiConfig apiConfig;

    public MainWindowModel(MainWindowController controller){
        this.controller=controller;
        apiConfig=new ApiConfig();
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<LibraryBook>booksList(){
        return apiConfig.getBooks(token);
    }
}
