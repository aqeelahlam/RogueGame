package game;

import edu.monash.fit2099.engine.DropItemAction;
import edu.monash.fit2099.engine.Item;

public class RocketBody extends Item {

    public RocketBody(){
        super("BuildingRocketAction Body", 'Ȫ');
    }

    public static RocketBody newRocketBodyInstance() {

        RocketBody newRocketBody = new RocketBody();
        newRocketBody.allowableActions.clear();
        newRocketBody.allowableActions.add(new DropItemAction(newRocketBody));
        return newRocketBody;

    }
}