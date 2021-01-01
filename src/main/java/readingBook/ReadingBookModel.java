package readingBook;

import api.ApiConfig;

public class ReadingBookModel {

    private ReadingBookController controller;

    private ApiConfig apiConfig;

    private String token;

    public void setToken(String token) {
        this.token = token;
    }

    public ReadingBookModel(ReadingBookController controller) {
        this.controller = controller;
        apiConfig=new ApiConfig();
    }

    public void returnBook(String id){
       try {
           apiConfig.returnBook(id,token);
       }catch (Exception e){
           controller.showInformationWindow();
       }
    }
}
