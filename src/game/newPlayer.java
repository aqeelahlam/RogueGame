package game;

import edu.monash.fit2099.engine.*;

public class newPlayer extends Player {
    boolean isStun = false;
    int missedTurns = 0;
    private boolean checkOx;
    private boolean remainingOx;
    private Location RocketPadLocation;


    public void setStun(boolean stun) {
        isStun = stun;
    }

    public newPlayer(String name, char displayChar, int priority, int hitPoints,Location rocketPadLocation) {
        super(name, displayChar, priority, hitPoints);
        this.RocketPadLocation = rocketPadLocation;
        addSkill(SpaceSkill.SPACE_SKILL);
    }




    @Override
    public Action playTurn(Actions actions, GameMap map, Display display) {

        if (this.hasSkill(OxygenSkill.OXYGEN_SKILL))
        {
            for (Item item : this.getInventory()) {
                if (item.getDisplayChar() == 'Ö') {
                    if(((OxygenTank) item).getCount()==10)
                    {
                        this.removeItemFromInventory(item);
                        break;
                    }
                    else{
                        ((OxygenTank) item).incrementCount();
                        break;
                    }

                }

            }

            for(Item item: this.getInventory())
            {
                if (item.getDisplayChar()=='Ö')
                {
                    remainingOx = true;
                    break;
                }
                else {
                    remainingOx = false;

                }

            }
            if(!remainingOx)
            {
                return new SafetyTransportAction(this,RocketPadLocation);
            }

        }

        if (isStun) {
            while (missedTurns<2)
            {
                missedTurns++;
                return new SkipTurnAction();
            }
        }

        this.isStun = false;
        return super.playTurn(actions,map,display);


    }
}
