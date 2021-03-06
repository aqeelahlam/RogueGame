package game.rocket;

import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;

public class Rocket extends Ground {

    private Location finalDestination;
    private Actor enemy;

    /**
     * This is the constructor for Rocket
     * @param finalDestination The destination where the player wants to go to
     * @param enemy the enemy who will be given implants
     */
    public Rocket(Location finalDestination, Actor enemy){
        super( 'R');
        this.finalDestination = finalDestination;
        this.enemy = enemy;

    }

    public Rocket(){
        super('R');
    }

    /**
     * Returns an empty Action list.
     *
     * @param actor     the Actor acting
     * @param location  the current Location
     * @param direction the direction of the Ground from the Actor
     * @return
     */
    @Override
    public Actions allowableActions(Actor actor, Location location, String direction) {
        return new Actions(new FlyingRocketAction(actor, finalDestination, enemy));
    }

    /**
     * Override this to implement impassable terrain, or terrain that is only passable if conditions are met.
     *
     * @param actor
     * @return true
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }

    /**
     * Override this to implement terrain that blocks thrown objects but not movement, or vice versa
     *
     * @return true
     */
    @Override
    public boolean blocksThrownObjects() {
        return super.blocksThrownObjects();
    }

}
