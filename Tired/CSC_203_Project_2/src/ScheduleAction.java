public interface ScheduleAction extends EntityInterface {
    void scheduleActions(EventScheduler scheduler, WorldModel world, ImageStore imageStore);

    double getAnimationPeriod();

}
