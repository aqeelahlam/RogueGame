package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class UnlockDoorAction extends Action {

    private String direction;
    private Door door;

    public UnlockDoorAction(String direction, Door door){
        this.direction = direction;
        this.door = door;
    }

    @Override
    public String execute(Actor actor, GameMap map) {

        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }

    @Override
    public String hotKey() {
        return null;
    }
}
