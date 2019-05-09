package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class GivePlansAction extends Action {

    private Item givingItem;
    private Item takingItem;
    private Actor actor;
    private Actor subject;

    public GivePlansAction(Item givingItem, Item takingItem, Actor actor, Actor subject){
        this.givingItem = givingItem;
        this.takingItem = takingItem;
        this.actor = actor;
        this.subject = subject;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        actor.removeItemFromInventory(givingItem);
        subject.addItemToInventory(givingItem);

        subject.removeItemFromInventory(takingItem);
        actor.addItemToInventory(takingItem);

        map.removeActor(subject);
        return menuDescription(actor) + System.lineSeparator() + subject + " disappears with a cheery wave.";

    }

    @Override
    public String menuDescription(Actor actor) {
        return (actor + " gives " + givingItem + " for "+ takingItem);
    }

    @Override
    public String hotKey() {
        return "";
    }
}