package game;

import edu.monash.fit2099.engine.*;

/**
 * This class is used to create Doors in the map
 */
public class Door extends Ground {
    private Key key;

    /**
     * This is the constructor for Door
     * @param key it is needed for each door, as each door has its unique key
     */
    public Door(Key key) {
        super('†');
        this.key = key;
    }

    /**
     * This will check if the player has the key to open a particular door
     * Note: Each key is unique for each door (1 key = 1 door)
     * @param actor The actor who holds the key in his inventory
     * @return Boolean: True if the key he has matches the door
     * else: False
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        for (Item item : actor.getInventory()) {
            if (item.equals(key)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This will add an action for the actor to enter
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return
     */
    @Override
    public Actions allowableActions(Actor actor, Location location, String direction) {
        if (this.canActorEnter(actor)) {
//            return new Actions(new MoveActorAction(location, direction, ""));
            return new Actions(new UnlockDoorAction(direction,this));
        }
        return new Actions();
    }



    @Override
    public boolean blocksThrownObjects() {
        return true;
    }
}
