package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class UnlockDoorAction extends Action {

    private Item key;
    private Door door;


    public UnlockDoorAction(Item key, Door door){
        this.key = key;
        this.door = door;

    }

    @Override
    public String execute(Actor actor, GameMap map) {
        if (!door.isUnlocked()){
            door.setUnlocked(true);
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
