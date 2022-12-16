import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;

import java.util.ArrayList;

public class Earth extends Group {
    Rotate ry;
    Sphere sph;
    ArrayList<Sphere> list;
    PhongMaterial material;
    public Earth() {
        sph = new Sphere(300);
        material = new PhongMaterial();

        this.getChildren().add(sph);
        material.setDiffuseMap( new Image("file:data/earth_lights_4800.png"));
        sph.setMaterial(material);

    }


}
