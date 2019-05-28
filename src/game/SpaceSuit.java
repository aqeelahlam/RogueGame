package game;

import edu.monash.fit2099.engine.Item;

public class SpaceSuit extends Item {

    /**
     * This class is used to create an instance of a SpaceSuit
     */
    public SpaceSuit(){
        super("Spacesuit", '8');

    }

    @Override
    public void addSkill(Enum skill) {
        addSkill(SpaceSkill.SPACE_SKILL);
    }
}
