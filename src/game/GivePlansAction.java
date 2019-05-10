package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

/**
 * This class is used to allow the RocketPlans to be exchanged for the RocketBody
 */
public class GivePlansAction extends Action {

    private Item givingItem;
    private Item takingItem;
    private Actor actor;
    private Actor subject;

    /**
     *
     * @param givingItem This is the item the player will give to the requesting actor
     * @param takingItem This is the item the player will get from the requesting actor
     * @param actor The actor performing the action.
     * @param subject The actor that exchanges with the player
     */
    public GivePlansAction(Item givingItem, Item takingItem, Actor actor, Actor subject){
        this.givingItem = givingItem;
        this.takingItem = takingItem;
        this.actor = actor;
        this.subject = subject;
    }

    /**
     * This is where we remove and add items to each actors respective inventory
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return
     * if player has item: eg String: "Player gives Chocolate in return for Money"
     * else: eg String: "Player disappears with a cheery wave."
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        actor.removeItemFromInventory(givingItem);
        subject.addItemToInventory(givingItem);

        subject.removeItemFromInventory(takingItem);
        actor.addItemToInventory(takingItem);

        map.removeActor(subject);
        return menuDescription(actor) + System.lineSeparator() + subject + " disappears with a cheery wave.";

    }

    /**
     * a string describing the action
     * @param actor The actor performing the action.
     * @return eg String: "Player gives Chocolate in return for Money"
     */
    @Override
    public String menuDescription(Actor actor) {
        return (actor + " gives " + givingItem + " in return for "+ takingItem);
    }

    @Override
    public String hotKey() {
        return "";
    }
}