import processing.core.PImage;

import java.util.List;

public class House implements EntityInterface{

    private final String kind;
    private final String id;
    private Point position;
    private final List<PImage> images;
    private int imageIndex;
    double animationPeriod;
    private int health;


    public House(String kind, String id, Point position, List<PImage> images) {
        this.kind = kind;
        this.id = id;
        this.position = position;
        this.images = images;

    }

    public Point getPosition() {
        return position;
    }
    public void setPosition(Point position) {
        this.position = position;
    }
    public String getKind() {
        return this.kind;
    }
    public String getId() {
        return id;
    }
    public void nextImage() {
        this.imageIndex = this.imageIndex + 1;
    }
    public int getHealth() {
        return health;
    }
    public PImage getCurrentImage(){
        return this.images.get(this.imageIndex % this.images.size());
    }


    public void setHealth(int health){
        this.health = health;
    }

    public double getAnimationPeriod() {
        return this.animationPeriod;
    }



    public String log(){
        return this.id.isEmpty() ? null :
                String.format("%s %d %d %d", this.id, this.position.x, this.position.y, this.imageIndex);
    }


    public static House createHouse(String id, Point position, List<PImage> images) {
        return new House("HOUSE", id, position, images);
    }
}
