package game;

import edu.monash.fit2099.engine.*;
import game.enemy.YugoMaxx;
import java.util.Random;


public class ShootAction extends Action {

//Random is used to generate a random number
    private Random rand = new Random();
    private float ShootChance = rand.nextFloat();
    private Actor target;


    /**
     * This is the constructor for ShootAction
     * @param subject The actor being shot
     */
    public ShootAction(Actor subject) {
        this.target = subject;
    }


    /**
     * If the chances of a successful hit occurs, Yugo Maxx's exoskeleton is removed,
     * The pistol is removed from the inventory to allow him to attack Yugo Maxx
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return A explanatory String message
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (ShootChance<0.7) {

            ((YugoMaxx) target).setExoskeleton(false);
            for(Item item:actor.getInventory()) {
                if (item.getDisplayChar()=='P') {
                    actor.removeItemFromInventory(item);

                }
            }

            return "The Exoskeleton of Yugo Maxx has been broken down";

        }
        else {
            for(Item item:actor.getInventory()) {
                if (item.getDisplayChar()=='P') {
                    ((WaterPistol) item).setFull(false);

                }
            }
            return "The shot missed.";
        }
    }

    /**
     * Returns a descriptive string
     *
     * @param actor The actor performing the action.
     * @return eg String:  "Fire Pistol"
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Fire Pistol";
    }

    @Override
    public String hotKey() {
        return "";
    }
}
