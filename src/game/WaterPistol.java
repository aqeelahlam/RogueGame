package game;

import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.WeaponItem;

public class WaterPistol extends WeaponItem {

    public WaterPistol(){
        super("Water Pistol", 'P', 0,"Splash");
    }


    @Override
    public Actions getAllowableActions() {
        return super.getAllowableActions();
    }
}
