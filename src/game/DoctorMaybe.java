package game;

import edu.monash.fit2099.engine.*;

import java.util.Random;

public class DoctorMaybe extends Actor {

    private Random rand = new Random();

    public DoctorMaybe() {
        super("Doctor Maybe", 'D', 3, 15);
        inventory.add(new RocketEngine().newRocketEngineInstance());
    }

    @Override
    public Action playTurn(Actions actions, GameMap map, Display display) {
        for(Action action : actions){
            if(!(action instanceof AttackAction) && !(action instanceof SkipTurnAction)){
                actions.remove(action);
            }
        }
        return actions.get(rand.nextInt(actions.size()));
    }

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(5/2,"Slap");
    }
}


