import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FxApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/Login.fxml"));
        Pane stackPane=loader.load();
        Scene scene= new Scene(stackPane);
        primaryStage.setTitle("LibraryApp");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}