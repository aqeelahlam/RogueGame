package game;

import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;

public class Water extends Ground {

    private final static int MAXLOAD = 1;
    private int fillAmount;

    /**
     * Constructor.
     *
     * displayChar character to display for this type of terrain
     */
    public Water() {
        super('w');
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }

    @Override
    public Actions allowableActions(Actor actor, Location location, String direction) {
        if(fillAmount==0){
            return new Actions(new FillWaterPistolAction(fillAmount));
        }
        return null;
    }
    }

