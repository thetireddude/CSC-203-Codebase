/**
 * An event is made up of an Entity that is taking an
 * Action a specified time.
 */
public final class Event {
    private final ActionInterface action;
    private final double time;
    private final EntityInterface entity;

    public Event(ActionInterface action, double time, EntityInterface entity) {
        this.action = action;
        this.time = time;
        this.entity = entity;
    }

    public ActionInterface getAction() {
        return action;
    }

    public double getTime() {
        return time;
    }

    public EntityInterface getEntity() {
        return entity;
    }
}
