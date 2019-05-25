package game;

import edu.monash.fit2099.engine.*;

/**
 * This class is used to build the rocket
 */
public class BuildingRocketAction extends Action {

    private Actor actor;
    private int numberOfItems;
//    Write (Extensibility)
    private final static int MAXNOOFITEMS = 2;
    private Location rocketPadLocation;
    private Location finalDestination;



    /**
     * This is the constructor for BuildingRocketAction
     * @param actor The actor that has the Rocket Parts
     */
    public BuildingRocketAction(Actor actor, Location rocketPadLocation, Location finalDestination) {
        this.actor = actor;
        numberOfItems = 0;
        this.rocketPadLocation = rocketPadLocation;
        this.finalDestination = finalDestination;
    }

    /**
     * We check if the player has the RocketEngine and the RocketBody in his inventory,
     * if the count of items is 2, we remove the actor and end the game
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
            }
        }
        if(numberOfItems == MAXNOOFITEMS){
            for(Item item:actor.getInventory()){
                if(item.getDisplayChar() == 'Ȫ' || item.getDisplayChar() == 'ñ'){
                    actor.removeItemFromInventory(item);
                }
            }

            map.add(new Rocket(finalDestination), rocketPadLocation);

            return actor + " Successfully built the Rocket!";
        }
        return " You're still missing a few parts, come back when you have them all ";
    }

    /**
     * a string describing the action
     * @param actor The actor performing the action.
     * @return eg String: Build Rocket!
     */
    @Override
    public String menuDescription(Actor actor) {
        return ("Build Rocket!");
    }

    @Override
    public String hotKey() {
        return "";
    }
}

