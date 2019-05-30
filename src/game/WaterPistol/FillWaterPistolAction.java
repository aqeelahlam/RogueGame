package game.WaterPistol;

import edu.monash.fit2099.engine.*;
import game.WaterPistol.WaterPistol;

/**
 * This class is used to refill the water pistol
 */
public class FillWaterPistolAction extends Action {

    private WaterPistol waterPistol;

    /**
     * This is the constructor for FillWaterPistolAction
     * @param WaterPistol used to fill an instance of WaterPistol gun
     */
    public FillWaterPistolAction(WaterPistol WaterPistol){

        this.waterPistol = WaterPistol;
    }

    /**
     * Sets the status of the WaterPistol instance to full
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return eg String: "Player's Pistol Reloaded"
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        waterPistol.setFull(true);
        return actor + "'s" + " Pistol Reloaded";

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

    @Override
    public String hotKey() {
        return "";
    }
}
