package game;

import edu.monash.fit2099.engine.*;

public class newPlayer extends Player {
    boolean isStun = false;
    int missedTurns = 0;

    public void setStun(boolean stun) {
        isStun = stun;
    }

    public newPlayer(String name, char displayChar, int priority, int hitPoints) {
        super(name, displayChar, priority, hitPoints);
    }

    @Override
    public Action playTurn(Actions actions, GameMap map, Display display) {

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
