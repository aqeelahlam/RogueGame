package game;

import edu.monash.fit2099.engine.*;

public class newPlayer extends Player {
    boolean isStun = false;
    private int missedTurns = 0;
    private boolean remainingOxygen;
    private Location RocketPadLocation;
    private final static int NUMBEROFSKIPMOVES = 2;
    private final static int MAXSPACEMOVES = 10;


    /**
     * This is the constructor for newPlayer
     * @param name The name of the player
     * @param displayChar The DisplayChar of the player
     * @param priority The priority of the player
     * @param hitPoints The hitpoints of the player
     * @param rocketPadLocation Location of the RocketPad to transport player during emergency(Lack of Oxygen)
     */
    public newPlayer(String name, char displayChar, int priority, int hitPoints, Location rocketPadLocation) {
        super(name, displayChar, priority, hitPoints);
        this.RocketPadLocation = rocketPadLocation;
    }


    /**
     * This function is used to check for number of turns available in the moon,
     * and will also support the StunBehaviour action for the Ninja
     * @param actions the actions to display
     * @param map the map to display
     * @param display the object that performs the console I/O
     * @return SafetyTransportAction or SkipTurnAction
     */
    @Override
    public Action playTurn(Actions actions, GameMap map, Display display) {

//        Code for oxygen depletion:
        if (this.hasSkill(OxygenSkill.OXYGEN_SKILL)) {
            for (Item item : this.getInventory()) {
                if (item.getDisplayChar() == 'Ö') {
                    if (((OxygenTank) item).getCount() == MAXSPACEMOVES) {
                        this.removeItemFromInventory(item);
                        break;
                    } else {
                        ((OxygenTank) item).incrementCount();
                        break;
                    }
                }
            }

            for (Item item : this.getInventory()) {
                if (item.getDisplayChar() == 'Ö') {
                    remainingOxygen = true;
                    break;
                } else {
                    remainingOxygen = false;
                }

            }
            if (!remainingOxygen) {
                this.removeSkill(OxygenSkill.OXYGEN_SKILL);
                return new SafetyTransportAction(this, RocketPadLocation);
            }

        }

//        Code for Ninja StunBehaviour
        if (isStun) {
            while (missedTurns < NUMBEROFSKIPMOVES) {
                missedTurns++;
                return new SkipTurnAction();
            }
        }

        this.isStun = false;
        return super.playTurn(actions, map, display);


    }

    public void setStun(boolean stun) {
        isStun = stun;
    }

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(100, "Focus Punch");
    }
}
