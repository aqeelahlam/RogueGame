package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.Random;

public class insultBehaviour extends Action implements ActionFactory{

    private Actor target;
    private Random rand = new Random();
    private ArrayList<String> insults = new ArrayList<>();
    private String Insult;
    private float insultChance;
    private int distanceBetweenActors;


    public insultBehaviour(Actor subject) {
        this.target = subject;
        insults.add("Idiot");
        insults.add("Moron");
        insults.add("Useless");
        insults.add("Pimple head");
        insults.add("Baboon");
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        Insult = insults.get(rand.nextInt(insults.size()));

        insultChance = rand.nextFloat();
        if (insultChance <= 0.1) {
            return actor + " says " + Insult + " " + "to " + target + ".";
        }
        return "";
    }


    @Override
    public Action getAction(Actor actor, GameMap map) {
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
    @Override
    public String menuDescription(Actor actor) {
        return "";
    }

    @Override
    public String hotKey() {
        return "";
    }

    /**
     * Used to calculate distance between two locations
     * @param a first location
     * @param b second location
     * @return an int which is the distance between a and b
     */
    // Manhattan distance.
    public int distance(Location a, Location b) {
        return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
    }
}