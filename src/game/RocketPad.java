package game;

import edu.monash.fit2099.engine.*;

public class RocketPad extends Ground {

    public RocketPad() {
        super('Ŕ');
    }


    @Override
    public Actions allowableActions(Actor actor, Location location, String direction) {
        return new Actions(new BuildingRocketAction(actor));

    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }

    @Override
    public boolean blocksThrownObjects() {
        return true;
    }
}
