package game;

import edu.monash.fit2099.engine.*;

public class BuildingRocketAction extends Action {

    private Actor actor;
    private int numberOfItems;

    public BuildingRocketAction(Actor actor) {
        this.actor = actor;
        numberOfItems = 0;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        for(Item item:actor.getInventory()){
            if(item.getDisplayChar() == 'Ȫ' || item.getDisplayChar() == 'ñ'){
                numberOfItems ++;
            }
        }
        if(numberOfItems == 2){
            map.removeActor(actor);
            return actor + " Successfully built the Rocket";
        }
        return actor + " you're missing a few parts ";
    }

    @Override
    public String menuDescription(Actor actor) {
        return ("Build Rocket!");
    }

    @Override
    public String hotKey() {
        return "";
    }
}

