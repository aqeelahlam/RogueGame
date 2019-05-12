package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is for Q who is a NPC(Non-Player-Character) in the game, he will give the player the RocketBody if
 * the player has the RocketPlans with him.
 */
public class Q extends Actor {

    /**
     * This is the constructor for Q
     * This character is represented by 'Q' in the map.
     * His priority is Second to the player
     */
    public Q(){
        super("Q", 'Q',2,1000);
    }

    /**
     * This is an Overridden method of Actor:
     * This method is used to give Q his possible Actions which is either talkBehavior or GivePlansAction
     * which is usually controlled by the other Actor
     * This will also check for RocketPlans within the players inventory and give the player the RocketBody.
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return An array of allowable Actions
     */

    @Override
    public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
        Actions list = super.getAllowableActions(otherActor, direction, map);
//        Iterate through the inventory of the otherActor
        for(Item item : otherActor.getInventory()){
            if (item.getDisplayChar() == 'Æ'){
                list.add(new talkBehavior(otherActor, this, "Hand them over, I don’t have all day!"));
                list.add(new GivePlansAction(item, RocketBody.newRocketBodyInstance(), otherActor, this));
                return list;
            }
        }

        list.add(new talkBehavior(otherActor,this,"I can give you something that will help, but I’m going to need the plans."));
        return list;

    }

    /**
     * This is used to remove AttackAction and PickUpItemAction to prevent Q from harming the player or
     * picking up an item in the map.
     * @param actions collection of possible Actions for this Actor
     * @param map     the map containing the Actor
     * @param display the I/O object to which messages may be written
     * @return the Action that is performed
     */
    @Override
    public Action playTurn(Actions actions, GameMap map, Display display) {
        for(Action action : actions){
            if((action instanceof AttackAction) || (action instanceof PickUpItemAction)){
                actions.remove(action);
            }
        }
        return super.playTurn(actions,  map,  display);
    }

}