package game;

import edu.monash.fit2099.engine.*;

public class RocketPad extends Ground {

    public RocketPad() {
        super('Ŕ');
    }

    @Override
    public Actions allowableActions(Actor actor, Location location, String direction) {
        BuildingRocketAction buildingRocketAction = new BuildingRocketAction();
        for (Item item: actor.getInventory()){
            if (item.getDisplayChar() == 'ñ'){
                buildingRocketAction.execute(actor, location.map());
            }
        }

        return buildingRocketAction;
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
