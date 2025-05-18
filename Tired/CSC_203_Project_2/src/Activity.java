public class Activity implements ActionInterface {

    private final EntityInterface entity;
    private final WorldModel world;
    private final ImageStore imageStore;

    public Activity(EntityInterface entity, WorldModel world, ImageStore imageStore, int repeatCount) {
        this.entity = entity;
        this.world = world;
        this.imageStore = imageStore;
    }

    public static Activity createActivityAction(EntityInterface entity, WorldModel world, ImageStore imageStore) {
        return new Activity(entity, world, imageStore, 0);
    }

    public void executeAction(EventScheduler scheduler) {
        ExecuteEntityActivity temp_entity = (ExecuteEntityActivity) this.entity;
        switch (temp_entity.getKind()) {
            case "SAPLING", "TREE", "FAIRY", "DUDE_NOT_FULL", "DUDE_FULL":
                temp_entity.executeEntityActivity(this.world, this.imageStore, scheduler);
                break;
            default:
                throw new UnsupportedOperationException(String.format("executeActivityAction not supported for %s", this.entity.getKind()));
        }
    }
}
