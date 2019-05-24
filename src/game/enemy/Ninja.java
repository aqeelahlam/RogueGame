package game.enemy;

import edu.monash.fit2099.engine.*;
import game.ActionFactory;
import game.SpaceSkill;
import game.newPlayer;
import game.stunBehaviour;

import java.util.ArrayList;
import java.util.List;

public class Ninja extends Actor {

//    private Actions playerActions = new Actions();

//    private Boolean stunSuccess = false;


    // Grunts have 50 hitpoints and are always represented with a g
    public Ninja(String name, newPlayer player) {
        super(name, 'N', 5, 25);
        addBehaviour(new stunBehaviour(player));
        addSkill(SpaceSkill.CYBERNETIC_IMPLANTS);

    }

    private List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();

    private void addBehaviour(ActionFactory behaviour) {
        actionFactories.add(behaviour);
    }


//    @Override
//    public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
//        if (stunSuccess)
//        {
//            Actions actions =  super.getAllowableActions( otherActor,  direction,  map);
//            for(Action action : actions){
//                if((action instanceof AttackAction) || (action instanceof MoveActorAction)){
//                    actions.remove(action);
//                }
//            }
//
//        }
//        return super.getAllowableActions( otherActor,  direction,  map);
//
//    }

    @Override
    public Action playTurn(Actions actions, GameMap map, Display display) {
        for (ActionFactory factory : actionFactories) {
            Action action = factory.getAction(this, map);
            if(action != null) {
//                stunSuccess = true;
                return action;
            }

        }
        return new SkipTurnAction();

    }



}


