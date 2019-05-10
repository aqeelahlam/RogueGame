package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;

public class Goon extends Actor {

    // Goons have 50 hitpoints and are always represented with a 'G'
    public Goon(String name, Actor player) {

        super(name, 'G', 5, 5);
        addBehaviour(new FollowBehaviour(player));
        addBehaviour(new insultBehaviour(player));
        }


    private List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();

    private void addBehaviour(ActionFactory behaviour) {
        actionFactories.add(behaviour);
    }

    @Override
    public Action playTurn(Actions actions, GameMap map, Display display) {
        for (ActionFactory factory : actionFactories) {
            Action action = factory.getAction(this, map);
            if(action != null)
                return action;

        }

        for (Action action : actions){
            if(action instanceof DropItemAction){
                actions.remove(action);
            }
        }

        return super.playTurn(actions,  map,  display);
    }

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(10, "Focus Punch");
    }
}


