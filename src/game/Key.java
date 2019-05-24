package game;

import edu.monash.fit2099.engine.DropItemAction;
import edu.monash.fit2099.engine.Item;


public class Key extends Item {

    private int keyId;
    public Key(String name,int id){
        super(name, 'K');
        this.keyId = id;
    }


    public Key newKeyInstance(String name,int keyId) {
        Key newKey = new Key(name,keyId);
        newKey.allowableActions.clear();
        newKey.allowableActions.add(new DropItemAction(newKey));
        return newKey;
    }
}
