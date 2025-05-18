import processing.core.PImage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Dude_Not_Full implements EntityInterface, ExecuteEntityActivity, TransformEntity, ScheduleAction{

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

    public Dude_Not_Full(String kind, String id, Point position, List<PImage> images, int resourceLimit,
                         int resourceCount, double actionPeriod, double animationPeriod, int health) {
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

    public String log(){
        return this.id.isEmpty() ? null :
                String.format("%s %d %d %d", this.id, this.position.x, this.position.y, this.imageIndex);
    }

    public double getAnimationPeriod() {
        return this.animationPeriod;
    }


    public static Dude_Not_Full createDudeNotFull(String id, Point position, double actionPeriod, double animationPeriod, int resourceLimit, List<PImage> images) {
        return new Dude_Not_Full("DUDE_NOT_FULL", id, position, images, resourceLimit, 0, actionPeriod, animationPeriod, 0);
    }

    public void executeEntityActivity(WorldModel world, ImageStore imageStore, EventScheduler scheduler) {
        Optional<EntityInterface> target = world.findNearest(this.position, new ArrayList<>(Arrays.asList("TREE", "SAPLING")));

        if (target.isEmpty() || !this.moveToEntity(world, target.get(), scheduler) || !this.transformEntity(world, scheduler, imageStore)) {
            scheduler.scheduleEvent(this, Activity.createActivityAction(this, world, imageStore), this.actionPeriod);
        }
    }

    public void scheduleActions(EventScheduler scheduler, WorldModel world, ImageStore imageStore){
        scheduler.scheduleEvent(this, Activity.createActivityAction(this, world, imageStore), this.actionPeriod);
        scheduler.scheduleEvent(this, Animation.createAnimationAction(this, 0), getAnimationPeriod());
    }

    public boolean transformEntity(WorldModel world, EventScheduler scheduler, ImageStore imageStore) {
        if (this.resourceCount >= this.resourceLimit) {
            EntityInterface dude = Dude_Full.createDudeFull(this.id, this.position, this.actionPeriod, this.animationPeriod, this.resourceLimit, this.images);

            world.removeEntity(scheduler, this);
            scheduler.unscheduleAllEvents(this);

            world.addEntity(dude);
            ((Dude_Full) dude).scheduleActions(scheduler, world, imageStore);

            return true;
        }

        return false;
    }

    public boolean moveToEntity(WorldModel world, EntityInterface target, EventScheduler scheduler) {
        if (this.position.adjacent(target.getPosition())) {
            this.resourceCount += 1;
            target.setHealth(target.getHealth() - 1);
            return true;
        } else {
            Point nextPos = this.nextPosition(world, target.getPosition());

            if (!this.position.equals(nextPos)) {
                world.moveEntity(scheduler, this, nextPos);
            }
            return false;
        }
    }

    public Point nextPosition(WorldModel world, Point destPos) {
        int horiz = Integer.signum(destPos.x - this.position.x);
        Point newPos = new Point(this.position.x + horiz, this.position.y);

        if (horiz == 0 || world.isOccupied(newPos) && world.getOccupancyCell(newPos).getKind() != "STUMP") {
            int vert = Integer.signum(destPos.y - this.position.y);
            newPos = new Point(this.position.x, this.position.y + vert);

            if (vert == 0 || world.isOccupied(newPos) && world.getOccupancyCell(newPos).getKind() != "STUMP") {
                newPos = this.position;
            }
        }

        return newPos;
    }
}