package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;

public class Ninja extends Actor {

    // Grunts have 50 hitpoints and are always represented with a g
    public Ninja(String name, Actor player) {
        super(name, 'N', 5, 50);
        addBehaviour(new stunBehaviour(player));

    }

    private List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();

    private void addBehaviour(ActionFactory behaviour) {
        actionFactories.add(behaviour);
    }

    @Override
    public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
//        return super.playTurn());
        return null;
    }

    @Override
    public Action playTurn(Actions actions, GameMap map, Display display) {
        for (ActionFactory factory : actionFactories) {
            Action action = factory.getAction(this, map);
            if(action != null)
                return action;

        }

            return null;
    }



}


