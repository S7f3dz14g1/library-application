package mainWindow;

import bookList.BookListController;
import helpers.Button;
import javafx.event.ActionEvent;
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
        setList();
    }

    private void setList(){
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/BooksList.fxml"));
        try {
            setScreen(loader.load());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        BookListController controller=loader.getController();
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

    public void onClickedTitleButton(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/BooksList.fxml"));
        try {
            setScreen(loader.load());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        BookListController controller=loader.getController();
        controller.setList(Button.Tittle,null);
    }

    public void onClickedHistoryButton(ActionEvent actionEvent) {
        //wyświetlenie histori przeczytanych książke
    }

    public void onClickedReadingButton(ActionEvent actionEvent) {
        //wyśiwetlenie książek po rankingu
    }

    public void onClickedDiscoverButton(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/BooksList.fxml"));
        try {
            setScreen(loader.load());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        BookListController controller=loader.getController();
        controller.setList(Button.Discover,null);
    }

    public void onClickedTopBooksButton(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/BooksList.fxml"));
        try {
            setScreen(loader.load());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        BookListController controller=loader.getController();
        controller.setList(Button.TopBooks,null);
    }

    public void onClickedDateButton(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/BooksList.fxml"));
        try {
            setScreen(loader.load());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        BookListController controller=loader.getController();
        controller.setList(Button.Date,null);
    }

    public void onClickedRantingButton(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/BooksList.fxml"));
        try {
            setScreen(loader.load());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        BookListController controller=loader.getController();
        controller.setList(Button.Ranting,null);
    }

    public void onClickedSearch(MouseEvent mouseEvent) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/BooksList.fxml"));
        try {
            setScreen(loader.load());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        BookListController controller=loader.getController();
        controller.setList(Button.Search,titleBookText.getText().toString());
    }
}
