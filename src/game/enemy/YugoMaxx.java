package game.enemy;

import edu.monash.fit2099.engine.*;
import game.ActionFactory;
import game.WaterPistol.ShootAction;
import game.WaterPistol.WaterPistol;

import java.util.ArrayList;
import java.util.List;

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
        Actions actions = super.getAllowableActions(otherActor, direction, map);
        if (otherActor.getDisplayChar()=='@' )
        {
            for(Item item:otherActor.getInventory())
            {
                if (item.getDisplayChar()=='P')
                {
                    if(((WaterPistol) item).isFull())
                    {
                        actions.add(new ShootAction(this));
                    }
                }
            }
        }
        return actions;
    }


    private List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();


    @Override
    public Action playTurn(Actions actions, GameMap map, Display display) {

        for (ActionFactory factory : actionFactories) {
            Action action = factory.getAction(this, map);
            if(action != null)
                return action;
        }
        for (Action action : actions){
            if(action instanceof PickUpItemAction){
                actions.remove(action);
            }

        }

        return super.playTurn(actions, map, display);
    }

    @Override
    public void hurt(int points) {
        if (this.exoskeleton)
        {
            hitPoints-=0;
        }
        else {
            hitPoints-=points;
        }
    }

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(10, "Upper Cut");
    }
}
