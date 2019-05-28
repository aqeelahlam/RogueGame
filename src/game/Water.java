package game;

import edu.monash.fit2099.engine.*;

public class Water extends Ground {


    /**
     * Constructor.
     * displayChar character to display for this type of terrain
     */
    public Water() {
        super('w');
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }

    /**
     * This function is used to set the water pistol instance to full
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return
     */
    @Override
    public Actions allowableActions(Actor actor, Location location, String direction) {
        for(Item item:actor.getInventory()){
            if(item.getDisplayChar() == 'P'){
                return new Actions(new FillWaterPistolAction((WaterPistol) item));
            }
        }
        return new Actions();

    }
}

