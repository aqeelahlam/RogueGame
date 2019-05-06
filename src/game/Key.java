package game;

import edu.monash.fit2099.engine.DropItemAction;
import edu.monash.fit2099.engine.Item;

import java.util.ArrayList;

public class Key extends Item {

    private String keyId;
    private ArrayList<String> keys = new ArrayList<String>();

    public Key(){
        super("Key", 'K');
        keys.add("12345");
        keys.add("67890");

    }

    public static Key newKeyInstance() {
        Key newKey = new Key();
        newKey.allowableActions.clear();
        newKey.allowableActions.add(new DropItemAction(newKey));
        return newKey;
    }
}
