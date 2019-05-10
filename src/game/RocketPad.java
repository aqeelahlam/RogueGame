package game;

import edu.monash.fit2099.engine.*;

/**
 * This Class is used to create the RocketPad, a position in the map that allows player to build their Rocket
 */
public class RocketPad extends Ground {

    /**
     * This is the constructor for RocketPad
     * it is presented on the map with the symbol 'Ŕ'
     */
    public RocketPad() {
        super('Ŕ');
    }

    /**
     * This will create a new instance of BuildingRocketAction to check for RocketBody & RocketEngine from
     * players inventory
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return
     */
    @Override
    public Actions allowableActions(Actor actor, Location location, String direction) {
        return new Actions(new BuildingRocketAction(actor));

    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }

    @Override
    public boolean blocksThrownObjects() {
        return true;
    }
}
