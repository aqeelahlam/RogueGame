package game.oxygen;
import edu.monash.fit2099.engine.*;


public class DispenseOxygenAction extends Action {

    private Location location;

    /**
     * This is the constructor for DispenseOxygenAction
     * @param newLocation Location where we dispense the oxygen tank.
     */
    public DispenseOxygenAction(Location newLocation){
        this.location = newLocation;
    }

    /**
     * This is where we add an Oxygen Tank to the location.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        
        location.addItem(new OxygenTank());
        return "Oxygen has been dispensed successfully";
    }

    /**
     * a string describing the action
     * @param actor The actor performing the action.
     * @return
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Dispense Oxygen.";
    }

    @Override
    public String hotKey(){
        return "";
    }

}
