package game;

import edu.monash.fit2099.engine.*;

public class FlyingRocketAction extends Action {

    private Actor actor;
    private Location otherLocation;
    private final static int MAXCOUNT = 2;
    private int count = 0;

    public FlyingRocketAction(Actor actor, Location otherLocation){
        this.actor = actor;
        this.otherLocation = otherLocation;
    }


    /**
     * Perform the Action.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    @Override
    public String execute(Actor actor, GameMap map) {

        for (Item item : actor.getInventory())
        {

//            if (item.hasSkill(SpaceSkill.SPACE_SKILL)) {
               if(item.getDisplayChar()=='8' || item.getDisplayChar()=='Ö')
               {
                    count++;
                    if (count==MAXCOUNT)
                    {
                    map.moveActor(actor, otherLocation);
                    if (otherLocation.getGround().getDisplayChar()=='0')
                    {
                        actor.addSkill(OxygenSkill.OXYGEN_SKILL);
                    }
                    return actor + " uses Rocket!";
                    }
                }

        }
        return "You cant go to the moon without the space suit and oxygen!";
    }

    /**
     * Returns a descriptive string
     *
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Move to Base";
    }

    /**
     * Returns the key used in the menu to trigger this Action.
     * <p>
     * There's no central management system for this, so you need to be careful not to use the same one twice.
     *
     * @return The key we use for this Action in the menu.
     */
    @Override
    public String hotKey() {
        return "";
    }


}
