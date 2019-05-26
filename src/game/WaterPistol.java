package game;

import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.DropItemAction;
import edu.monash.fit2099.engine.WeaponItem;
import game.enemy.YugoMaxx;

public class WaterPistol extends WeaponItem {

    private boolean isFull = false;
    private Actor target;

    public WaterPistol(Actor target){
        super("Water Pistol", 'P', 0,"Splash");
        this.target = target;

    }

    @Override
    public Actions getAllowableActions() {

        super.allowableActions.add(new ShootAction(target));
        return super.allowableActions;
    }

    public void setFull(boolean full) {
        isFull = full;
    }

    public boolean isFull() {
        return isFull;
    }

}
