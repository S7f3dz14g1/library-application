package informationBox;

import javafx.scene.control.Alert;

public class InformationBox {

    public static void infoBox(String info){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(info);
        alert.showAndWait();
    }
}