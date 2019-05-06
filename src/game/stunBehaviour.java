package game;

import edu.monash.fit2099.engine.*;


public class stunBehaviour implements ActionFactory {

    private Actor target;

    public stunBehaviour(Actor subject) {
        this.target = subject;
    }

    @Override
    public Action getAction(Actor actor, GameMap map)
    {
        Location here = map.locationOf(actor);
        Location there = map.locationOf(target);
        int currentDistance = distance(here, there);
        if (currentDistance<=5)
        {
            return new SkipTurnAction();
        }



        return null;
    }

    // Manhattan distance.
    private int distance(Location a, Location b) {
        return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
    }
}