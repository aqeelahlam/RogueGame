package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

public class UnlockDoorAction extends Action {

    private Key key;
    private Door door;
    private Location doorLocation;

    /**
     * This is the constructor for UnlockDoorAction
     * @param newKey The key used for this door
     * @param newDoor The door
     * @param newDoorLocation The location of the door
     */
    public UnlockDoorAction(Key newKey, Door newDoor, Location newDoorLocation){
        this.key = newKey;
        this.door = newDoor;
        this.doorLocation = newDoorLocation;

    }

    /**
     * We check if the door is unlocked, if not we unlock it and replace the door
     * DisplayChar with a floor DisplayChar
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return Eg: "Door is unlocked"
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (!door.isUnlocked()){
            door.setUnlocked(true);
            map.add(new Floor(), doorLocation);
            actor.removeItemFromInventory(key);
            return "Door is unlocked";
        }
        return  "";

    }

    /**
     * Returns a descriptive string
     *
     * @param actor The actor performing the action.
     * @return eg String: Do you want to build the rocket?
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Do you want to unlock this Door?";
    }

    @Override
    public String hotKey() {
        return "";
    }
}
