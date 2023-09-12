import java.util.ArrayList;
import java.util.List;

public class Environment {
    private List<Entity> entities;

    public Environment() {
        entities = new ArrayList<>();
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public void removeEntity(Entity entity) {
        entities.remove(entity);
    }

    public void performInteractions() {
        for (Entity entity : entities) {
            if (entity instanceof Human) {

            } else if (entity instanceof Alien) {

            }
        }
    }
}