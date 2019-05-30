package game.rocket;

import edu.monash.fit2099.engine.*;
import game.oxygen.OxygenSkill;

/**
 * This class is used to safely transport the player back to earth when
 * his oxygen has depleted
 */
public class SafetyTransportAction extends Action {

    private Actor actor;
    private Location otherLocation;

    /**
     * This is the constructor for SafetyTransportAction
     * @param actor The actor to be transported
     * @param otherLocation The location where he gets transported to
     */
    public SafetyTransportAction(Actor actor, Location otherLocation){
        this.actor = actor;
        this.otherLocation = otherLocation;
    }


    /**
     * We remove the Oxygen Skill from the player and just simply move the actor
     * back to the main location(Earth)
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     * Eg: "Oxygen Depleted. Transporting back to Earth."
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        actor.removeSkill(OxygenSkill.OXYGEN_SKILL);
        map.moveActor(actor, otherLocation);
        return "Oxygen Depleted. Transporting back to Earth.";

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
