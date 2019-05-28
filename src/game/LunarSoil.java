package game;

import edu.monash.fit2099.engine.*;

/**
 * This class is used to create the soil for lunar ground(Moons Floor)
 */
public class LunarSoil extends Ground {

    public LunarSoil() {
        super('░');
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        if (actor.hasSkill(SpaceSkill.CYBERNETIC_IMPLANTS)) {
            return true;
        }
        else {
            for (Item item:actor.getInventory()) {
                if (item.getDisplayChar()=='8') {
                    return true;
                }
            }
        }
        return false;
    }
}


