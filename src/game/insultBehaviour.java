package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class is used to allow an actor to throw an insult at another player
 */
public class insultBehaviour extends Action implements ActionFactory{

    private Actor target;
    private Random rand = new Random();
    private ArrayList<String> insultsList = new ArrayList<>();
    private String Insult;
    private float insultChance;
    private int distanceBetweenActors;

    /**
     * This is the constructor for insultBehaviour
     * @param subject The actor the insult is thrown at
     */
    public insultBehaviour(Actor subject) {
        this.target = subject;
//        We add insults to the ArrayList of insults
        insultsList.add("Fatty");
        insultsList.add("Moron");
        insultsList.add("Useless");
        insultsList.add("Pimple head");
        insultsList.add("Loser");
    }

    /**
     * This is used to return an insult if the insultChance generated using random is <=0.1
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return eg String: "Player says Moron to target."
     * else Return ""
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        Insult = insultsList.get(rand.nextInt(insultsList.size()));
        insultChance = rand.nextFloat();
        if (insultChance <= 0.1) {
            return actor + " says " + Insult + " " + "to " + target + ".";
        }
        return "";
    }

    /**
     * Used to calculate distance between two locations
     * @param a first location
     * @param b second location
     * @return an int which is the distance between a and b
     */
    public int distance(Location a, Location b) {
        return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
    }

    /**
     * The insult will be thrown at target only if the target is right next to the player
     * @param actor Actor throwing the insult
     * @param map where actor is in the map
     * @return Returns the result from execute
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (target.isConscious()) {
            Location here = map.locationOf(actor);
            Location there = map.locationOf(target);

            distanceBetweenActors = distance(here, there);

            if (distanceBetweenActors == 1) {
                if (!this.execute(actor, map).equals("")) {
                    return this;
                }
                return null;
            }
            return null;

        }
        return null;
    }
    @Override
    public String menuDescription(Actor actor) {
        return "";
    }

    @Override
    public String hotKey() {
        return "";
    }

}