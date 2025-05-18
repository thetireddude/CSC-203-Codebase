public class Animation implements ActionInterface {

    private final EntityInterface entity;
    private final int repeatCount;

    public Animation(EntityInterface entity, WorldModel world, ImageStore imageStore, int repeatCount) {
        this.entity = entity;
        this.repeatCount = repeatCount;
    }

    public static Animation createAnimationAction(EntityInterface entity, int repeatCount) {
        return new Animation(entity, null, null, repeatCount);
    }

    public void executeAction(EventScheduler scheduler) {
        this.entity.nextImage();
        if (this.repeatCount != 1) {
            scheduler.scheduleEvent(this.entity, createAnimationAction(this.entity, Math.max(this.repeatCount - 1, 0)), this.entity.getAnimationPeriod());
        }
    }
}
