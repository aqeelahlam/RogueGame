package game;

import edu.monash.fit2099.engine.*;


/**
 * Class extends the world class which represents the game world, including location of all actors, the player and the playing grid.
 */
public class NewWorld extends World {

    /**
     *
     * @param display
     */
    public NewWorld(Display display){
        super(display);

    }

    /**
     * Run the game.
     *
     * On each iteration the gameloop does the following:
     *  - displays the player's map
     *  - checks if player is on earth and if player has YugoMax in the inventory and stops the game if true.
     *  - processes the actions of every Actor in the game, regardless of map
     *
     * We could either only process the actors on the current map, which would make
     * time stop on the other maps, or we could process all the actors.  We chose to
     * process all the actors.
     *
     * @throws IllegalStateException if the player doesn't exist
     */
    @Override
    public void run() {
        if(player == null)

            throw new IllegalStateException();


        while (stillRunning()) {
            GameMap playersMap = actorLocations.locationOf(player).map();
            playersMap.draw(display);
            if (actorLocations.locationOf(player).getGround().getDisplayChar()=='.') {
                for(Item item: player.getInventory()){
                    if (item.toString().equals("Sleeping Yugo Maxx")) {
                        display.println("Player wins. Game Over.");
                        System.exit(1);
                    }
                }
            }
            for (Actor actor : actorLocations) {
                processActorTurn(actor);
            }
        }
        display.println(endGameMessage());
        System.exit(1);
    }


    /**
     * Gives an Actor its turn.
     * Gives Player an option to quit.
     *
     * The Actions an Actor can take include:
     * <ul>
     *  <li> those conferred by items it is carrying </li>
     *  <li> movement actions for the current location and terrain </li>
     *  <li> actions that can be done to Actors in adjacent squares </li>
     *  <li> actions that can be done using items in the current location </li>
     *  <li> skipping a turn</li>
     *  <li> Quitting the game</li>
     * </ul>
     *
     * @param actor the Actor whose turn it is.
     */
    protected void processActorTurn(Actor actor) {
        Location here = actorLocations.locationOf(actor);
        GameMap map = here.map();

        Actions actions = new Actions();
        for (Item item : actor.getInventory()) {
            actions.add(item.getAllowableActions());
        }

        for (Exit exit : here.getExits()) {
            Location destination = exit.getDestination();
            if (actorLocations.isAnActorAt(destination)) {
                Actor adjacentActor = actorLocations.actorAt(destination);
                actions.add(adjacentActor.getAllowableActions(actor, exit.getName(), map));

            } else {
                Ground adjacentGround = map.groundAt(destination);
                actions.add(adjacentGround.allowableActions(actor, destination, exit.getName()));
                actions.add(adjacentGround.getMoveAction(actor, destination, exit.getName(), exit.getHotKey()));
            }
        }

        for (Item item : here.getItems()) {
            actions.add(item.getAllowableActions());
        }
        actions.add(new SkipTurnAction());
        if (actor.getDisplayChar()=='@') {
            actions.add(new QuitGameAction());
        }
        Action action = actor.playTurn(actions, map, display);
        if (action.hotKey().equals("q")) {
            display.println("Player quit the game.");
            System.exit(1);
        }
        String result = action.execute(actor, map);
        display.println(result);
    }

    /**
     * Returns true if the game is still running.
     *
     * The game is considered to still be running if the player is still conscious.
     *
     * @return true if the player is still conscious.
     */
    @Override
    protected boolean stillRunning() {
        return player.isConscious();
    }


    /**
     * Return a string that can be displayed when the game ends(Player is unconscious.
     *
     * @return the string "Player is unconscious, better luck next time pal"
     */
    @Override
    protected String endGameMessage() {
        if(!player.isConscious()) {
            return "Player is unconscious, better luck next time pal";
        }
        return "";
    }
}