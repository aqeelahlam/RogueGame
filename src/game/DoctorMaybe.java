package game;

import edu.monash.fit2099.engine.Actor;

public class DoctorMaybe extends Actor {

    public DoctorMaybe() {
        super("Doctor Maybe", 'D', 3, 15);
        inventory.add(new RocketEngine().newRocketEngineInstance());
    }

}


