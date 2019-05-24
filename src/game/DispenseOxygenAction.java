package game;
import edu.monash.fit2099.engine.*;


public class DispenseOxygenAction extends Action {


    private Location location;
    public DispenseOxygenAction(Location location){
        this.location = location;
    }

    @Override
    public String execute(Actor actor, GameMap map)
    {
        
        location.addItem(new OxygenTank());
        return  menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Dispense Oxygen.";
    }

    @Override
    public String hotKey(){
        return "";
    }

}
