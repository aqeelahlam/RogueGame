package game;

import edu.monash.fit2099.engine.Item;

public class SpaceSuit extends Item {

    public SpaceSuit(){
        super("Spacesuit", '8');

    }

    //    Check this to see if this actually needs "Super"
    @Override
    public void addSkill(Enum skill) {
        addSkill(SpaceSkill.SPACE_SKILL);
    }
}
