package game;

import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.WeaponItem;

public class WaterPistol extends WeaponItem {

    private final static int MAXLOAD = 1;
    private int fillAmount;

    public WaterPistol(){
        super("Water Pistol", 'P', 0,"Splash");

    }

    @Override
    public Actions getAllowableActions() {
        if(fillAmount==0){
            return new Actions(new FillWaterPistolAction(fillAmount));
        }
        return super.allowableActions;
    }
}
