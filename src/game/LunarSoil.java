package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;

public class LunarSoil extends Ground {

    public LunarSoil() {
        super('0');
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return actor.hasSkill(SpaceSkill.SPACE_SKILL);
    }
}


