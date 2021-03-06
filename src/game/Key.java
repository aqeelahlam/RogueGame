package game;

import edu.monash.fit2099.engine.DropItemAction;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.*;

/**
 * This class holds instances of keys
 */
public class Key extends Item {

    private int keyId;

    /**
     * This is the constructor for Key
     * @param name The name given to the key (eg: Key1, Key2, etc)
     * @param id The unique identifier for each key
     */
    public Key(String name, int id){
        super(name, 'K');
        this.keyId = id;
    }


    public Key newKeyInstance(String name, int keyId) {
        Key newKey = new Key(name,keyId);
        newKey.allowableActions.clear();
        newKey.allowableActions.add(new DropItemAction(newKey));
        return newKey;
    }
}





