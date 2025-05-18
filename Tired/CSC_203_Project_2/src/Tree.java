import processing.core.PImage;

import java.util.List;

public class Tree implements EntityInterface, ExecuteEntityActivity, TransformEntity, ScheduleAction{
    public static final String STUMP_KEY = "stump";

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

    public Tree(String kind, String id, Point position, List<PImage> images, int resourceLimit,
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
    public int getHealth() {
        return health;
    }
    public PImage getCurrentImage(){
        return this.images.get(this.imageIndex % this.images.size());
    }


    public void setHealth(int health){
        this.health = health;
    }

    public void nextImage() {
        this.imageIndex = this.imageIndex + 1;
    }


    public String log(){
        return this.id.isEmpty() ? null :
                String.format("%s %d %d %d", this.id, this.position.x, this.position.y, this.imageIndex);
    }
    public double getAnimationPeriod() {
        return this.animationPeriod;
    }

    public static Tree createTree(String id, Point position, double actionPeriod, double animationPeriod, int health, List<PImage> images) {
        return new Tree("TREE", id, position, images, 0, 0, actionPeriod, animationPeriod, health, 0);
    }

    public void executeEntityActivity(WorldModel world, ImageStore imageStore, EventScheduler scheduler) {

        if (!this.transformEntity(world, scheduler, imageStore)) {

            scheduler.scheduleEvent(this, Activity.createActivityAction(this, world, imageStore), this.actionPeriod);
        }
    }

    public void scheduleActions(EventScheduler scheduler, WorldModel world, ImageStore imageStore){
        scheduler.scheduleEvent(this, Activity.createActivityAction(this, world, imageStore), this.actionPeriod);
        scheduler.scheduleEvent(this, Animation.createAnimationAction(this, 0), getAnimationPeriod());
    }

    public boolean transformEntity(WorldModel world, EventScheduler scheduler, ImageStore imageStore) {
        if (this.health <= 0) {
            EntityInterface stump = Stump.createStump(STUMP_KEY + "_" + this.id, this.position, imageStore.getImageList(STUMP_KEY));

            world.removeEntity(scheduler, this);

            world.addEntity(stump);

            return true;
        }

        return false;
    }


}
