package game;

import edu.monash.fit2099.engine.*;

public class LunarSoil extends Ground {

    public LunarSoil() {
        super('0');
    }

    @Override
    public boolean canActorEnter(Actor actor)
    {
        if (actor.hasSkill(SpaceSkill.CYBERNETIC_IMPLANTS))
        {
            return true;
        }
        else
        {
            for (Item item:actor.getInventory())
            {
                if (item.getDisplayChar()=='8')
                {
                    return true;
                }
            }
        }
        return false;
    }
}


