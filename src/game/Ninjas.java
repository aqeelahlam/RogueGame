package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;

public class Ninjas extends Actor {

    // Grunts have 50 hitpoints and are always represented with a g
    public Ninjas(String name, Actor player) {
        super(name, 'N', 5, 50);
        addBehaviour(new stunBehaviour(player));
        super.addItemToInventory(Key.newKeyInstance("123"));
    }

    private List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();

    private void addBehaviour(ActionFactory behaviour) {
        actionFactories.add(behaviour);
    }

    @Override
    public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
        return super.getAllowableActions( otherActor,  direction,  map);
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


