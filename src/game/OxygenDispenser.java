package game;
import edu.monash.fit2099.engine.*;

public class OxygenDispenser extends Ground {

    private Location location;
    /**
     * This class is used to create an instance of Oxygen Dispenser
     */
    public OxygenDispenser()
    {
        super('O');
    }

    /**
     * We iterate through the inventory of the actor and will check if
     * he has the spacesuit. Next we check if there is an oxygen tank already
     * dispensed, and finally we will dispense an oxygen tank at that location.
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return actions
     */
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

    @Override
    public boolean canActorEnter(Actor actor) {
        for (Item item:actor.getInventory()){
            if(item.getDisplayChar()=='8')
            {
                return true;
            }
        }
        return false;
    }
}
