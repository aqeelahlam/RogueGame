package game;

import edu.monash.fit2099.engine.*;

public class FlyingRocketAction extends Action {

    private Actor actor;
    private Location location;
    private Location MoonBase;


    public FlyingRocketAction(Actor actor, Location location, Location moonBase){
        this.actor = actor;
        this.location = location;
        this.MoonBase = moonBase;
    }


    /**
     * Perform the Action.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if(actor.hasSkill(SpaceSkill.SPACE_SKILL)){
            map.moveActor(actor, map.at(0,0));
            return "Actor moves to moon";
        }
        return "";

    }

    /**
     * Returns a descriptive string
     *
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return "";
    }

    /**
     * Returns the key used in the menu to trigger this Action.
     * <p>
     * There's no central management system for this, so you need to be careful not to use the same one twice.
     *
     * @return The key we use for this Action in the menu.
     */
    @Override
    public String hotKey() {
        return "";
    }
}
