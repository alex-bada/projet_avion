import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;

public class Interface extends Application {

    double dragY;
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("The one and only Earth");
        Earth root = new Earth();
        Pane pane = new Pane(root);
        Scene theScene = new Scene(pane, 600, 400, false);


        PerspectiveCamera camera = new PerspectiveCamera(true);         // allow to have a good view of the Earth
        camera.setTranslateZ(-1000);                                      // by further the camera
        camera.setNearClip(0.1);
        camera.setFarClip(2000.0);
        camera.setFieldOfView(35);
        theScene.setCamera(camera);

        theScene.addEventHandler(MouseEvent.ANY, event -> {
            if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
                dragY = event.getSceneY();
                System.out.println("Clicked on : (" + event.getSceneX() + ", " + event.getSceneY() + ")");
            }
            else if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                double newTZ = camera.getTranslateZ() + (event.getSceneY() - dragY);
                if (newTZ > -2000 && newTZ < -500) camera.setTranslateZ(newTZ);
                dragY = event.getSceneY();
            }

        });

        primaryStage.setScene(theScene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}