package game;

import edu.monash.fit2099.engine.DropItemAction;
import edu.monash.fit2099.engine.Item;

public class RocketPlans extends Item {

    public RocketPlans(){
        super("Rocket Plans", 'Ø');
    }

    public static RocketPlans newRocketPlansInstance() {

        RocketPlans newRocketPlans = new RocketPlans();
        newRocketPlans.allowableActions.clear();
        newRocketPlans.allowableActions.add(new DropItemAction());
        return newRocketPlans;
    }
}
