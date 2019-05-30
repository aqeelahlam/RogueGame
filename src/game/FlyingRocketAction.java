package game;

import edu.monash.fit2099.engine.*;
import game.enemy.YugoMaxx;

public class FlyingRocketAction extends Action {

    private Actor actor;
    private Actor enemy;
    private Location otherLocation;
    private final static int MAXCOUNT = 2;
    private int count = 0;


    /**
     * This is the constructor for FlyingRocketAction
     * @param actor The actor who is transported
     * @param otherLocation The location where the actor is transported to
     * @param enemy The enemy who we give Cybernetic Implants to
     */
    public FlyingRocketAction(Actor actor, Location otherLocation, Actor enemy) {
        this.actor = actor;
        this.otherLocation = otherLocation;
        this.enemy = enemy;
    }

    /**
     * We iterate through the players inventory to check if he has a spacesuit and
     * Oxygen tank(s) before we allow him to be transported to the base.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     * Eg: "actor uses Rocket!"
     */
    @Override
    public String execute(Actor actor, GameMap map) {

        for (Item item : actor.getInventory()) {

               if(item.getDisplayChar()=='8' || item.getDisplayChar()=='Ö') {
                    count++;
                    if (count==MAXCOUNT) {
                    map.moveActor(actor, otherLocation);
                    // The player only has Oxygen skill when he is travelling to the MoonBase
                    if (otherLocation.getGround().getDisplayChar()== '░') {
                        actor.addSkill(OxygenSkill.OXYGEN_SKILL);
                    }
                    // We remove oxygen skill once he travels back to earth(To maintain count of moves)
                    if (otherLocation.getGround().getDisplayChar()=='.') {
                        actor.removeSkill(OxygenSkill.OXYGEN_SKILL);
                    }
                    // YugoMaxx is given these implants to allow them to walk on the moon
                    enemy.addSkill(SpaceSkill.CYBERNETIC_IMPLANTS);

                    return actor + " uses Rocket";
                    }
               }

        }
        return "Unfortunately, you will still need at least one Oxygen Tank and a spaceSuit buddy";
    }

    /**
     * Returns a descriptive string
     *
     * @param actor The actor performing the action.
     * @return eg String: Do you want to build the rocket?
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Move to Base";
    }

    @Override
    public String hotKey() {
        return "";
    }


}
