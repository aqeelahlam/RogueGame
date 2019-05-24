package game;

import edu.monash.fit2099.engine.Item;

public class Spacesuit extends Item {

    public Spacesuit(){
        super("Spacesuit", '8');

    }

//    Check this to see if this actually needs "Super"
    @Override
    public void addSkill(Enum skill) {
        super.addSkill(SpaceSkill.SPACE_SKILL);
    }
}
