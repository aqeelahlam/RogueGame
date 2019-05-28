package game;
import edu.monash.fit2099.engine.*;

public class OxygenDispenser extends Ground {

    /**
     *
     */
    public OxygenDispenser()
    {
        super('O');
    }

    @Override
    public Actions allowableActions(Actor actor, Location location, String direction) {
        Actions actions =  super.allowableActions(actor,location,direction);
        actions.clear();
        for (Item item:actor.getInventory()) {
            if (item.getDisplayChar() == '8') {
                if (location.getItems().size() > 0) {
                    return actions;
                } else {
                    actions.add(new DispenseOxygenAction(location));
                }
            }
        }
        return actions;
    }
}
