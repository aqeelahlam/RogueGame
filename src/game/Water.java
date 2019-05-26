package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;

public class Water extends Ground {

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








}

