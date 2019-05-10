package game;

import edu.monash.fit2099.engine.DropItemAction;
import edu.monash.fit2099.engine.Item;

/**
 * This class is used to create an instance of the Item RocketBody
 */
public class RocketBody extends Item {

    /**
     * This is the constructor for RocketBody
     */
    public RocketBody(){
        super("Rocket Body", 'Ȫ');
    }

    /**
     * This is the constructor for RocketBody, this allows it to be added into an actors inventory
     * @return newRocketBody
     */
    public static RocketBody newRocketBodyInstance() {

        RocketBody newRocketBody = new RocketBody();
        newRocketBody.allowableActions.clear();
        newRocketBody.allowableActions.add(new DropItemAction(newRocketBody));
        return newRocketBody;

    }
}