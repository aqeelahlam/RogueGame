package game;

import edu.monash.fit2099.engine.Actor;

import java.util.ArrayList;
import java.util.List;

//MAKE CHANGES TO ADAPT: STILL IMPLEMENTING
public class Goon extends Actor {

    // Grunts have 100(twice of Grunt) hitpoints and are always represented with a G
    public Goon(String name, Actor player) {
        super(name, 'G', 5, 100);
        addBehaviour(new FollowBehaviour(player));
//        addBehaviour(new insultBehaviour(player));

    }

    private List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();

    private void addBehaviour(ActionFactory behaviour) {
        actionFactories.add(behaviour);
    }
}
