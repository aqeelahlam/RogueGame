package game;

import edu.monash.fit2099.engine.*;


public class stunBehaviour extends Action implements ActionFactory {

    private newPlayer target;

    public stunBehaviour(newPlayer subject) {
        this.target = subject;
    }

    @Override
    public String execute(Actor actor, GameMap map)
    {
        return actor + " throws StunPowder at " + target + "." + System.lineSeparator()+
                target + " is Stunned.";
    }
    @Override
    public String menuDescription(Actor actor) {
        return "";
    }

    @Override
    public String hotKey() {
        return "";
    }



    @Override
    public Action getAction(Actor actor, GameMap map)
    {
        try {
            Location here = map.locationOf(actor);
            Location there = map.locationOf(target);


            if (((Math.abs(here.x() - there.x()) < 5) & here.y() == there.y()) )
            {
//                east
                if (here.x()>there.x())
                {
                    map.moveActor(actor, new Location(map,here.x()+1,here.y()));
                    target.isStun = true;
                    return this;

                }
//                west
                else {
                    map.moveActor(actor, new Location(map,here.x()-1,here.y()));
                    target.isStun = true;

                    return this;
                }

            }
            else if (((Math.abs(here.y() - there.y()) < 5) & here.x() == there.x()) )
            {
//                South
                if (here.y()>there.y())
                {
                    map.moveActor(actor, new Location(map,here.x(),here.y()+1));
                    target.isStun = true;

                    return this;

                }
//                North
                else {
                    map.moveActor(actor, new Location(map,here.x(),here.y()-1));
                    target.isStun = true;

                    return this;
                }

            }

        }
        catch (java.lang.NullPointerException ex){;}
        target.isStun = false;
        return null;


    }

    // Manhattan distance.
    private int distance(Location a, Location b) {
        return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
    }
}