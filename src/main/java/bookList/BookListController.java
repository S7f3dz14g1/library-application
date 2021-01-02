package bookList;

import historyBook.HistoryBookController;
import models.LibraryBook;
import item.ItemController;
import helpers.Button;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import models.UserHistory;
import readingBook.ReadingBookController;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BookListController implements Initializable {
    
    @FXML
    private VBox listItem;

    private BookListModel model;

    private VBox parent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model=new BookListModel(this);    }

    public void setList(Button button,String title){
        List<LibraryBook> bookList=getBookList(button,title);
        Node[] node=new Node[bookList.size()];
        for (int i = 0; i <bookList.size(); i++) {
            if(model.getBooksCopies(bookList.get(i).getId())!=0) {
            }
                FXMLLoader loader= new  FXMLLoader(this.getClass().getResource("/fxml/Item.fxml"));
            try {
                node[i]= loader.load();
            }catch (Exception e){
            }
            ItemController itemController= loader.getController();
            itemController.setAuthor(bookList.get(i).getAuthors());
            itemController.setTitle(bookList.get(i).getTitle());
            itemController.setParent(parent);
            itemController.setIdBook(bookList.get(i).getId()+"");
            itemController.setToken(model.getToken());
            itemController.setBookList(listItem);
            listItem.getChildren().add(node[i]);
        }
    }

    public void setHistoryBook(String token){
        List<UserHistory> bookList=model.getUserHistory(token);
        Node[] node=new Node[bookList.size()];
        for (int i = 0; i <bookList.size(); i++) {
                FXMLLoader loader= new  FXMLLoader(this.getClass().getResource("/fxml/HistoryBook.fxml"));
                try {
                    node[i]= loader.load();
                }catch (Exception e){
                }
                HistoryBookController historyBookController= loader.getController();
                historyBookController.setBookCopyId(bookList.get(i).getBookCopyId()+"");
                historyBookController.setTitleBook(bookList.get(i).getTitle());
                historyBookController.setIdBook(i+1+"");
                historyBookController.setReturnedDate(bookList.get(i).getReturnedDate().toString());
                historyBookController.setBorrowDate(bookList.get(i).getBorrowDate().toString());
                listItem.getChildren().add(node[i]);

        }
    }

    public void setReadingBook(String token){
        List<UserHistory> bookList=model.getReadingBooks(token);
        Node[] node=new Node[bookList.size()];
        for (int i = 0; i <bookList.size(); i++) {
                FXMLLoader loader= new  FXMLLoader(this.getClass().getResource("/fxml/ReadingBook.fxml"));
                try {
                    node[i]= loader.load();
                }catch (Exception e){
                }
                ReadingBookController readingBookController = loader.getController();
                readingBookController.setBookCopyId(bookList.get(i).getBookCopyId()+"");
                readingBookController.setBorrowDate(bookList.get(i).getBorrowDate().toString());
                readingBookController.setIdBook(bookList.get(i).getBookCopyId()+"");
                readingBookController.setParent(listItem);
                readingBookController.setToken(model.getToken());
                readingBookController.setTitleBook(bookList.get(i).getTitle());
                listItem.getChildren().add(node[i]);

        }
    }

    private List<LibraryBook> getBookList(Button button,String title){
        switch (button){
            case Date:
                return model.getBooksSortByDate();
            case Tittle:
                return model.getBooksSortByTitle();
            case Ranting:
                return model.getBooksSortByRanting();
            case Discover:
                return model.getBookByDiscover();
            case Search:
                return model.getBooksByTitle(title);
            default:
                return model.getTopBook();
        }
    }

    public void setPane(VBox box) {
        parent = box;
    }

    public void setToken(String token){
        model.setToken(token);
    }
}
