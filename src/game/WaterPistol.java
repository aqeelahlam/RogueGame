package game;

import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.WeaponItem;

public class WaterPistol extends WeaponItem {

    private boolean isFull = false;

    public WaterPistol(){
        super("Water Pistol", 'P', 0,"Splash");

    }

    public void setFull(boolean full) {
        isFull = full;
    }

    public boolean isFull() {
        return isFull;
    }

}
