package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;

public class Q extends Actor {
    public Q(String name, Actor player){
        super(name, 'Q',2,300);

    }
    private List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();


    @Override
    public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
        Actions list = super.getAllowableActions(otherActor, direction, map);
        for(Item item : otherActor.getInventory()){
            if (item.getDisplayChar() == 'Ø'){
                list.add(new talkBehavior(otherActor, this, "Hand them over, I don't have all day!"));
                list.add(new GivePlansAction(item, RocketBody.newRocketBodyInstance(), otherActor, this));
                return list;
            }
        }

        list.add(new talkBehavior(otherActor,this,"I can give you something that will help, but I'm going to need the plans."));

        return list;

    }


//    Do I really need this? CHECK
    @Override
    public Action playTurn(Actions actions, GameMap map, Display display) {
        for (ActionFactory factory : actionFactories) {
            Action action = factory.getAction(this, map);
            if(action != null)
                return action;
        }

        for(Action action : actions){
            if((action instanceof AttackAction) || (action instanceof PickUpItemAction)){
                actions.remove(action);
            }
        }
        return super.playTurn(actions,  map,  display);
    }


}