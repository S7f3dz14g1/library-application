package mainWindow;

import bookList.BookListController;
import helpers.Button;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;

public class MainWindowController {

    @FXML
    private VBox emptyListBook;

    @FXML
    private Text nickText;

    @FXML
    private TextField titleBookText;

    private MainWindowModel model;

    public void initialize() {
        model=new MainWindowModel(this);

    }

    public void setList(){
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/BooksList.fxml"));
        try {
            setScreen(loader.load());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        BookListController controller=loader.getController();
        controller.setPane(emptyListBook);
        controller.setToken(model.getToken());
        controller.setList(Button.TopBooks,null);
    }

    public void setScreen(VBox pane) {
        emptyListBook.getChildren().clear();
        emptyListBook.getChildren().add(pane);
    }

    public void setNick(String nick){
        nickText.setText(nick);
    }

    public void setToken(String token){
        model.setToken(token);
    }

    public void onClickedTitleButton(MouseEvent actionEvent) {
        BookListController controller= getBookListControlerLoader();
        controller.setPane(emptyListBook);
        controller.setToken(model.getToken());
        controller.setList(Button.Tittle,null);
    }

    public void onClickedHistoryButton(MouseEvent actionEvent) {
        BookListController controller=getBookListControlerLoader();
        controller.setPane(emptyListBook);
        controller.setToken(model.getToken());
        controller.setHistoryBook(model.getToken());
    }

    public void onClickedReadingButton(MouseEvent actionEvent) {
        BookListController controller=getBookListControlerLoader();
        controller.setPane(emptyListBook);
        controller.setToken(model.getToken());
        controller.setReadingBook(model.getToken());
    }

    public void onClickedDiscoverButton(MouseEvent actionEvent) {
        BookListController controller= getBookListControlerLoader();
        controller.setPane(emptyListBook);
        controller.setToken(model.getToken());
        controller.setList(Button.Discover,null);
    }

    public void onClickedTopBooksButton(MouseEvent actionEvent) {
        BookListController controller= getBookListControlerLoader();
        controller.setPane(emptyListBook);
        controller.setToken(model.getToken());
        controller.setList(Button.TopBooks,null);
    }

    public void onClickedDateButton(MouseEvent actionEvent) {
        BookListController controller= getBookListControlerLoader();
        controller.setPane(emptyListBook);
        controller.setToken(model.getToken());
        controller.setList(Button.Date,null);
    }

    public void onClickedRantingButton(MouseEvent actionEvent) {
        BookListController controller= getBookListControlerLoader();
        controller.setPane(emptyListBook);
        controller.setToken(model.getToken());
        controller.setList(Button.Ranting,null);
    }

    public void onClickedSearch(MouseEvent mouseEvent) {
        BookListController controller= getBookListControlerLoader();
        controller.setPane(emptyListBook);
        controller.setToken(model.getToken());
        controller.setList(Button.Search,titleBookText.getText().toString());
    }

    private BookListController getBookListControlerLoader(){
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/BooksList.fxml"));
        try {
            setScreen(loader.load());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return loader.getController();
    }
}
