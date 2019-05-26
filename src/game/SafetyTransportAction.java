package game;

import edu.monash.fit2099.engine.*;

public class SafetyTransportAction extends Action {

    private Actor actor;
    private Location otherLocation;
    private boolean remainingOx;

    public SafetyTransportAction(Actor actor, Location otherLocation){
        this.actor = actor;
        this.otherLocation = otherLocation;
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
