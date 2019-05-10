package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;

public class Ninja extends Actor {

    private Actions playerActions = new Actions();

    private Boolean stunSuccess = false;

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
    public Actions getAllowableActions(Actor Player, String direction, GameMap map) {
        if (this.stunSuccess)
        {
            Actions newActions = new Actions();
            for (Action action: newActions)
            {
                if (!(action instanceof SkipTurnAction))
                {
                    newActions.remove(action);
                }
            }

            return newActions;

        }
        return new Actions(new AttackAction(Player, this));
    }

    @Override
    public Action playTurn(Actions actions, GameMap map, Display display) {
        for (ActionFactory factory : actionFactories) {
            Action action = factory.getAction(this, map);
            if(action != null)
                stunSuccess = true;
                return action;

        }

        return null;
    }



}


