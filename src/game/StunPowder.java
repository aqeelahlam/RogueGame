package game;

import edu.monash.fit2099.engine.DropItemAction;
import edu.monash.fit2099.engine.WeaponItem;

public class StunPowder extends WeaponItem {

    public StunPowder(){
        super("Stun Powder", 'Ø',0,"stuns");
    }

    public static StunPowder newInventoryStunPowderInstance() {

        StunPowder stunPowder = new StunPowder();
        stunPowder.allowableActions.clear();
        stunPowder.allowableActions.add(new DropItemAction(stunPowder));

        return stunPowder;
    }

}