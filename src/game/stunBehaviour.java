package game;

import edu.monash.fit2099.engine.*;

import java.util.Random;


public class stunBehaviour extends Action implements ActionFactory {

    private newPlayer target;
    private Random rand = new Random();
    private float stunChance = rand.nextFloat();

    public stunBehaviour(newPlayer subject) {
        this.target = subject;
    }

    @Override
    public String execute(Actor actor, GameMap map)
    {
        if (stunChance<0.5) {
            return actor + " throws StunPowder at " + target + "." + System.lineSeparator() +
                    target + " is Stunned and Ninja Moves away.";
        }
        else
        {
            return actor + " misses " +target + ".";
        }
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
            Location Ninja = map.locationOf(actor);
            Location Player = map.locationOf(target);


            if (((Math.abs(Ninja.x() - Player.x()) < 5) && Ninja.y() == Player.y()) )
            {
//                east
                if (Ninja.x()>Player.x()) {
                    int currentDistance = Ninja.x() - Player.x();
                    for (Exit exit : Ninja.getExits()) {
                        Location destination = exit.getDestination();
                        if (destination.canActorEnter(actor)) {
                            int newDistance = destination.x() - Player.x();
                            if (newDistance > currentDistance) {
                                map.moveActor(actor,destination);
                                if (stunChance<0.5)
                                {target.isStun = true;}
                                return this;

                            }
                        }
                    }
                }
//                west
                else {
                    int currentDistance = Player.x() - Ninja.x();
                    for (Exit exit : Ninja.getExits()) {
                        Location destination = exit.getDestination();
                        if (destination.canActorEnter(actor)) {
                            int newDistance = Player.x() - destination.x();
                            if (newDistance > currentDistance) {
                                map.moveActor(actor,destination);
                                if (stunChance<0.5)
                                {target.isStun = true;}
                                return this;

                            }
                        }
                    }
                }


            }
            else if (((Math.abs(Ninja.y() - Player.y()) < 5) && Ninja.x() == Player.x()) ) {
//                South
                if (Ninja.y() > Player.y()) {
                    int currentDistance = Ninja.y() - Player.y();
                    for (Exit exit : Ninja.getExits()) {
                        Location destination = exit.getDestination();
                        if (destination.canActorEnter(actor)) {
                            int newDistance = destination.y() - Player.y();
                            if (newDistance > currentDistance) {
                                map.moveActor(actor,destination);
                                if (stunChance<0.5)
                                {target.isStun = true;}
                                return this;

                            }
                        }
                    }
                }

//                North
                else {
                    int currentDistance = Player.y() - Ninja.y();
                    for (Exit exit : Ninja.getExits()) {
                        Location destination = exit.getDestination();
                        if (destination.canActorEnter(actor)) {
                            int newDistance = Player.y() - destination.y();
                            if (newDistance > currentDistance) {
                                map.moveActor(actor,destination);
                                if (stunChance<0.5)
                                {target.isStun = true;}
                                return this;
                            }
                        }
                    }
                }
            }




        }
        catch (java.lang.NullPointerException ex){;}
        return null;


    }

    // Manhattan distance.
    private int distance(Location a, Location b) {
        return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
    }
}