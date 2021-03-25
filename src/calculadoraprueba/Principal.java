/*
 * Necesita jdk 15
 * y JavaFx 17
 * 
 */
package calculadoraprueba;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Clemente Quintana
 */
public class Principal extends Application{

    @Override
    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("calculadora.fxml"));
        Scene scene = new Scene(root,320,400);
        stage.setResizable(false);
        stage.setTitle("CalcuClemen-DAM-B");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    
    }

}
