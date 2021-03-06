package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

/**
 * We use this Action to allow the player to quit the game
 */
public class QuitGameAction extends Action {

    @Override
    public String execute(Actor actor, GameMap map) {
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Quit Game";
    }

    @Override
    public String hotKey() {
        return "q";
    }
}
