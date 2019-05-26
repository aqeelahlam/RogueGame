package game;

import edu.monash.fit2099.engine.*;

public class FillWaterPistolAction extends Action {

    private int FillAmount;
    private WaterPistol waterPistol;

    public FillWaterPistolAction(WaterPistol WaterPistol){

        this.waterPistol = WaterPistol;

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
        waterPistol.setFull(true);
        return actor + "'s" + " Weapon Reloaded";

    }

    /**
     * Returns a descriptive string
     *
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Reload Water Pistol";
    }

    /**
     * Returns the key used in the menu to trigger this Action.
     * <p>
     * There's no central management system for this, so you need to be careful not to use the same one twice.
     * See https://en.wikipedia.org/wiki/Connascence
     *
     * @return The key we use for this Action in the menu.
     */
    @Override
    public String hotKey() {
        return "";
    }
}
