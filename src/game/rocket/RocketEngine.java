package game.rocket;

import edu.monash.fit2099.engine.DropItemAction;
import edu.monash.fit2099.engine.Item;

/**
 * This is the constructor for RocketEngine
 */

public class RocketEngine extends Item {
    public RocketEngine(){
        super("Rocket Engine", 'ñ');
    }

    /**
     * This is the constructor for RocketEngine, this allows it to be added into an actors inventory
     * @return rocketEngine
     */
    public static RocketEngine newRocketEngineInstance() {

        RocketEngine rocketEngine = new RocketEngine();
        rocketEngine.allowableActions.clear();
        rocketEngine.allowableActions.add(new DropItemAction(rocketEngine));
        return rocketEngine;
    }

}
