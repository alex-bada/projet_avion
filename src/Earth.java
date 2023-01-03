import javafx.animation.AnimationTimer;
import javafx.geometry.Point3D;
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

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long time) {
                //System.out.println("Valeur de time : " + time);
                double angle = time / 60_000_000.0;
                getEarth().setRotate(angle);
                getEarth().setRotationAxis(new Point3D(0, -1, 0));
            }

            public Earth getEarth() {
                return Earth.this;
            }

        };
        animationTimer.start();

    }


}
