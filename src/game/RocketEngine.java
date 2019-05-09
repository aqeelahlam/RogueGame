package game;

import edu.monash.fit2099.engine.DropItemAction;
import edu.monash.fit2099.engine.Item;

public class RocketEngine extends Item {
    public RocketEngine(){
        super("BuildingRocketAction Engine", 'ñ');
    }

    public static RocketEngine newRocketEngineInstance() {

        RocketEngine rocketEngine = new RocketEngine();
        rocketEngine.allowableActions.clear();
        rocketEngine.allowableActions.add(new DropItemAction(rocketEngine));
        return rocketEngine;
    }

}
