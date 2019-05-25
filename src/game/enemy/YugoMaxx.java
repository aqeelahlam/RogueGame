package game.enemy;

import edu.monash.fit2099.engine.*;

public class YugoMaxx extends Actor {

    private boolean exoskeleton = true;

    public YugoMaxx(){
        super("Yugo Maxx", 'Y', 3,100);

    }

    public void setExoskeleton(boolean exoskeleton) {
        this.exoskeleton = exoskeleton;
    }

    public boolean isExoskeleton() {
        return exoskeleton;
    }


    /**
     * Returns a collection of the Actions containing an AttackAction that the otherActor can do to the current Actor.
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return A collection of Actions.
     */
    @Override
    public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
        return super.getAllowableActions(otherActor, direction, map);
    }

    @Override
    public Action playTurn(Actions actions, GameMap map, Display display) {
        return super.playTurn(actions, map, display);
    }

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(10, "Upper Cut");
    }
}
