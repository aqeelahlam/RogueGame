package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.Random;

public class insultBehaviour extends Action implements ActionFactory{

    private Actor target;
    private Random rand = new Random();
    private ArrayList<String> insults = new ArrayList<>();
    private String Insult;


    public insultBehaviour(Actor subject) {
        this.target = subject;
        insults.add("You suck");
        insults.add("Ewww youre ");
        insults.add("Useless");
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        Insult = insults.get(rand.nextInt(insults.size()));

        return Insult + " " + target + "." + System.lineSeparator();
    }

    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location here = map.locationOf(actor);
        Location there = map.locationOf(target);

        Range xs, ys;
        if (here.x() == there.x() || here.y() == there.y()) {
            xs = new Range(Math.min(here.x(), there.x()), Math.abs(here.x() - there.x()) + 1);
            ys = new Range(Math.min(here.y(), there.y()), Math.abs(here.y() - there.y()) + 1);

            for (int x : xs) {
                for (int y : ys) {
                    if(map.at(x, y).getGround().blocksThrownObjects())
                        return null;
                }
            }
            return this;
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