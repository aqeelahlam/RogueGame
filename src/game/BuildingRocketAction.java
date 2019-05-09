package game;

import edu.monash.fit2099.engine.*;

public class BuildingRocketAction extends DropItemAction {

    private Item item;
    protected int itemsDropped;

    public BuildingRocketAction(Item item){
        super(item);
        this.item = item;
        itemsDropped = 0;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        actor.removeItemFromInventory(item);
        itemsDropped++;

        if (itemsDropped == 2){
            map.removeActor(actor);
            return "Congratulations, have successfully built the Rocket" + System.lineSeparator() + "Player used Rocket to leave infested Planet.";
        }
        return menuDescription(actor);

    }

    @Override
    public String menuDescription(Actor actor) {
//        Chanhe this line
        return actor + " drops the " + item + " on the Rocket Pad.";
    }

    @Override
    public String hotKey() {
        return "";
    }
}
