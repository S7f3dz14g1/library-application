package item;

import api.ApiConfig;

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

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
