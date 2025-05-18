import processing.core.PImage;

import java.util.List;

public class Stump implements EntityInterface{

    private final String kind;
    private final String id;
    private Point position;
    private final List<PImage> images;
    private int imageIndex;
    private final int resourceLimit;
    private int resourceCount;
    private final double actionPeriod;
    private final double animationPeriod;
    private int health;
    private final int healthLimit;

    public Stump(String kind, String id, Point position, List<PImage> images, int resourceLimit,
                     int resourceCount, double actionPeriod, double animationPeriod, int health, int healthLimit) {
        this.kind = kind;
        this.id = id;
        this.position = position;
        this.images = images;
        this.imageIndex = 0;
        this.resourceLimit = resourceLimit;
        this.resourceCount = resourceCount;
        this.actionPeriod = actionPeriod;
        this.animationPeriod = animationPeriod;
        this.health = health;
        this.healthLimit = healthLimit;
    }

    public static Stump createStump(String id, Point position, List<PImage> images) {
        return new Stump("STUMP", id, position, images, 0, 0, 0, 0, 0, 0);
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
    public int getHealth() {
        return health;
    }
    public String getId() {
        return id;
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


    public void nextImage() {
        this.imageIndex = this.imageIndex + 1;
    }


    public String log(){
        return this.id.isEmpty() ? null :
                String.format("%s %d %d %d", this.id, this.position.x, this.position.y, this.imageIndex);
    }
}
