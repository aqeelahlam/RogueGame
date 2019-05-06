package game;

import edu.monash.fit2099.engine.*;

public class talkBehavior extends Action{

    private Actor actor;
    private Actor otherPerson;
    private String speech;

    public talkBehavior(Actor actor, Actor otherPerson, String speech){
        this.actor = actor;
        this.otherPerson = otherPerson;
        this.speech = speech;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
//        This one depends on whether Q talks to player or vice versa
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }

    @Override
    public String hotKey() {
        return null;
    }

}
