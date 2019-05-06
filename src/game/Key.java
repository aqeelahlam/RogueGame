package game;

import edu.monash.fit2099.engine.DropItemAction;
import edu.monash.fit2099.engine.Item;


public class Key extends Item {

    private String keyId;

    public Key(String id){
        super("Key", 'K');
        this.keyId = id;

    }

    public static Key newKeyInstance(String keyId) {
        Key newKey = new Key(keyId);
        newKey.allowableActions.clear();
        newKey.allowableActions.add(new DropItemAction(newKey));
        return newKey;
    }
}
