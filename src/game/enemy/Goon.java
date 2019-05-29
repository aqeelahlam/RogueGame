package game.enemy;

import edu.monash.fit2099.engine.*;
import game.ActionFactory;
import game.FollowBehaviour;
import game.SpaceSkill;
import game.insultBehaviour;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is for Goon who needs to be defeated, he will drop a unique Key if the player knocks him out.
 * This key can be used to unlock a certain door
 */
public class Goon extends Actor {

    /**
     * This is the constructor for Goon
     * This character is represented by 'G' in the map.
     * His priority is fifth to the player
     * @param name This is the name of the Grunt
     * @param player This will be the Actor the grunt follows
     */
    // Goons have 50 hitpoints and are always represented with a 'G'
    public Goon(String name, Actor player) {

        super(name, 'G', 5, 50);
        addBehaviour(new FollowBehaviour(player));
        addBehaviour(new insultBehaviour(player));
        addSkill(SpaceSkill.CYBERNETIC_IMPLANTS);
        }

    private List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();

    /**
     * This method is used to simply add a behaviour
     * @param behaviour The behaviour we wish to add
     */
    private void addBehaviour(ActionFactory behaviour) {
        actionFactories.add(behaviour);
    }

    /**
     * We iterate through actionFactories to get its next action
     * The Grunt will drop the Key only when he is knocked out
     * @param actions collection of possible Actions for this Actor
     * @param map     the map containing the Actor
     * @param display the I/O object to which messages may be written
     * @return the Action that is performed
     */
    @Override
    public Action playTurn(Actions actions, GameMap map, Display display) {
        for (ActionFactory factory : actionFactories) {
            Action action = factory.getAction(this, map);
            if(action != null)
                return action;
        }

        for (Action action : actions){
            if(action instanceof DropItemAction || action instanceof  PickUpItemAction){
                actions.remove(action);
            }
        }

        return super.playTurn(actions,  map,  display);
    }

    /**
     * We override this to double its damage as of the Grunt
     * @return IntrinsicWeapon
     */
    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(10, "Focus Punch");
    }
}


