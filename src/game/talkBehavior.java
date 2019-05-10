package game;

import edu.monash.fit2099.engine.*;

/**
 * This class is used to allow an actor to talk to another actor(otherPerson)
 */
public class talkBehavior extends Action{

    private Actor actor;
    private Actor otherPerson;
    private String speech;

    /**
     * Constructor for talkBehavior
     * @param actor The actor that starts
     * @param otherPerson The actor that will reply to the first actor
     * @param speech a String that will store what the actor wishes to convey to the other
     */

    public talkBehavior(Actor actor, Actor otherPerson, String speech){
        this.actor = actor;
        this.otherPerson = otherPerson;
        this.speech = speech;
    }

    /**
     * Performs the talking action
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return eg String: "Player says hello"
     */
    @Override
    public String execute(Actor actor, GameMap map) {

        return otherPerson + " says " + speech;
    }

    /**
     * a string describing the action
     * @param actor The actor performing the action.
     * @return eg String: "Player speaks to Q"
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " speaks to " + otherPerson;
    }

    @Override
    public String hotKey() {
        return "";
    }

}
