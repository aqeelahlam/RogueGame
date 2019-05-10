package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;


public class Door extends Ground {
    private Key key;

    public Door(Key key)
    {
        super('†');
        this.key = key;
    }



    @Override
    public boolean canActorEnter(Actor actor)
    {
        for (Item item : actor.getInventory())
        {
            if (item.equals(key))
            {
                return true;
            }

        }

        return false;
    }

    @Override
    public Actions allowableActions(Actor actor, Location location, String direction)
    {
        if (this.canActorEnter(actor))

        {
            return new Actions(new MoveActorAction(location, direction, ""));

        }
        return new Actions();
    }



    @Override
    public boolean blocksThrownObjects() {
        return true;
    }
}
