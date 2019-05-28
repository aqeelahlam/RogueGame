package game;

import edu.monash.fit2099.engine.*;
import game.enemy.YugoMaxx;

/**
 * This class is used to build the rocket using the RocketBody and the RocketEngine
 */
public class BuildingRocketAction extends Action {

    private Actor actor;
    private int numberOfItems;
    private Location rocketPadLocation;
    private Location finalDestination;
    private Actor enemy;
//    This variable will hold the number of items required to build the Rocket
    private final static int MAXNOOFITEMS = 2;

    /**
     * This is the constructor for BuildingRocketAction
     * @param actor This is the actor holding the the RocketBody & RocketEngine
     * @param rocketPadLocation The Location of the RocketPad, used to build rocket on this location
     * @param finalDestination This is the location where the player is transported to (Eg: The Moon)
     * @param enemy The enemy who will be given Cybernetic Implants
     */
    public BuildingRocketAction(Actor actor, Location rocketPadLocation, Location finalDestination, Actor enemy) {
        this.actor = actor;
        numberOfItems = 0;
        this.rocketPadLocation = rocketPadLocation;
        this.finalDestination = finalDestination;
        this.enemy = enemy;
    }

    /**
     * We check if the player(actor) has the RocketEngine and the RocketBody in his inventory(we increment count
     * for each item), if the count of items is 2, we build the rocket at the Rocket Pad's location.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return
     * if player has both items : eg String: "Player Successfully built the Rocket!"
     * else: eg String: "You're still missing a few parts, come back when you have them all"
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        for(Item item:actor.getInventory()){
            if(item.getDisplayChar() == 'Ȫ' || item.getDisplayChar() == 'ñ'){
                numberOfItems ++;
                actor.removeItemFromInventory(item);
            }
        }
        if(numberOfItems == MAXNOOFITEMS){
            map.add(new Rocket(finalDestination, enemy), rocketPadLocation);

            return actor + " Successfully built the Rocket!";
        }
        return " You're still missing a few parts, come back when you have them all";
    }

    /**
     * a string describing the action
     * @param actor The actor performing the action.
     * @return eg String: Do you want to build the rocket?
     */
    @Override
    public String menuDescription(Actor actor) {
        return ("Do you want to build the rocket?");
    }

    @Override
    public String hotKey() {
        return "";
    }
}

