import processing.core.PImage;

import java.util.ArrayList;
import java.util.List;

public interface EntityInterface {

    List<String> kinds = List.of("HOUSE", "DUDE_FULL", "DUDE_NOT_FULL", "OBSTACLE", "FAIRY", "STUMP", "SAPLING", "TREE");


    Point getPosition();
    void setPosition(Point position);
    String getKind();
    String getId();

    String log();

    void nextImage();
    int getHealth();
    void setHealth(int health);

    double getAnimationPeriod();

    PImage getCurrentImage();





}
