package game;

import edu.monash.fit2099.engine.*;
import game.enemy.YugoMaxx;

/**
 * This Class is used to create the RocketPad, a position in the map that allows player to build their Rocket
 */
public class RocketPad extends Ground {

    private Location MoonBase;
    private Actor enemy;

    /**
     * This is the constructor for RocketPad
     * it is presented on the map with the symbol 'Ŕ'
     */
    public RocketPad(Location moonBase, Actor enemy) {
        super('Ŕ');
        this.MoonBase = moonBase;
        this.enemy = enemy;
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
        return new Actions(new BuildingRocketAction(actor, location, MoonBase, enemy));

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
