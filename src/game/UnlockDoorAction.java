package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

public class UnlockDoorAction extends Action {

    private Key key;
    private Door door;
    private Location doorLocation;


    public UnlockDoorAction(Key newKey, Door newDoor, Location newDoorLocation){
        this.key = newKey;
        this.door = newDoor;
        this.doorLocation = newDoorLocation;

    }

    @Override
    public String execute(Actor actor, GameMap map) {
        if (!door.isUnlocked()){
            door.setUnlocked(true);
            map.add(new Floor(), doorLocation);
            actor.removeItemFromInventory(key);
            return menuDescription(actor);
        }
        return "";

    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " unlocks this Door ";
    }

    @Override
    public String hotKey() {
        return "";
    }
}
