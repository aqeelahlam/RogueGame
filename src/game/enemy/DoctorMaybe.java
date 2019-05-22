package game.enemy;

import edu.monash.fit2099.engine.*;
import game.RocketEngine;

import java.util.Random;

/**
 * This class is for DoctorMaybe who is a mini boss in the game, he will drop the RocketEngine if the player knocks
 * him out.
 */
public class DoctorMaybe extends Actor {

    private Random rand = new Random();

    /**
     * This is the constructor for DoctorMaybe
     * This character is represented by 'D' in the map.
     * His priority is third to the player
     */
    public DoctorMaybe() {
        super("Doctor Maybe", 'D', 3, 15);
        inventory.add(new RocketEngine().newRocketEngineInstance());
    }

    /**
     * The Doctor is restricted from moving and many other actions, so we remove all actions except
     * for AttackAction & SkipTurnAction.
     * The Doctor will drop the RocketEngine only when he is knocked out
     * @param actions collection of possible Actions for this Actor
     * @param map     the map containing the Actor
     * @param display the I/O object to which messages may be written
     * @return the Action that is performed
     */
    @Override
    public Action playTurn(Actions actions, GameMap map, Display display) {
        for(Action action : actions){
            if(!(action instanceof AttackAction) && !(action instanceof SkipTurnAction)){
                actions.remove(action);
            }
        }
        return actions.get(rand.nextInt(actions.size()));
    }

    /**
     * The Doctor is weak and is only able to hit with half the Damage of the grunt, so we Override this
     * method to reduce his damage.
     * @return new IntrinsicWeapon
     */
    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(5/2,"Slap");
    }
}


