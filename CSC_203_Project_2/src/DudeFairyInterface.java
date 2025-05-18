public interface DudeFairyInterface {

    boolean moveToEntity(WorldModel world, EntityInterface target, EventScheduler scheduler);
    Point nextPosition(WorldModel world, Point destPos);
    }
