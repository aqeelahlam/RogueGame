package game;

import edu.monash.fit2099.engine.*;
import game.enemy.YugoMaxx;
import java.util.Random;


public class ShootAction extends Action {


    private Random rand = new Random();
    private float ShootChance = rand.nextFloat();
    private Actor target;


    public ShootAction(Actor subject) {
        this.target = subject;
    }


    @Override
    public String execute(Actor actor, GameMap map) {
        if (ShootChance<0.7)
        {

            ((YugoMaxx) target).setExoskeleton(false);
            for(Item item:actor.getInventory())
            {
                if (item.getDisplayChar()=='P')
                {
                    actor.removeItemFromInventory(item);

                }
            }

            return "The Exoskeleton of Yugo Maxx has been broken down.";

        }
        else {
            for(Item item:actor.getInventory())
            {
                if (item.getDisplayChar()=='P')
                {
                    ((WaterPistol) item).setFull(false);

                }
            }
            return "The shot missed.";
        }
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Shoot water";
    }

    @Override
    public String hotKey() {
        return "";
    }
}
