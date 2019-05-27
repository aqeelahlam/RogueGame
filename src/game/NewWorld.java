package game;

import edu.monash.fit2099.engine.*;


public class NewWorld extends World {

    private boolean test;

    public NewWorld(Display display){
        super(display);

    }

    @Override
    public void run()
    {
        if(player == null)

            throw new IllegalStateException();


        while (stillRunning())
        {
            GameMap playersMap = actorLocations.locationOf(player).map();
            playersMap.draw(display);
            if (actorLocations.locationOf(player).getGround().getDisplayChar()=='.')
            {
                for(Item item: player.getInventory()){
                    if (item.toString().equals("Sleeping Yugo Maxx"))
                    {
                        display.println("Player wins. Game Over.");
                        System.exit(1);
                    }
                }
            }
            for (Actor actor : actorLocations)
            {
                processActorTurn(actor);
            }
        }
        display.println(endGameMessage());
        System.exit(1);
    }



    protected void processActorTurn(Actor actor)
    {
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
        if (actor.getDisplayChar()=='@')
        {
            actions.add(new QuitGameAction());
        }
        Action action = actor.playTurn(actions, map, display);
        if (action.hotKey().equals("q"))
        {
            display.println("Player quit the game.");
            System.exit(1);
        }
        String result = action.execute(actor, map);
        display.println(result);
    }

    @Override
    protected boolean stillRunning() {
        return player.isConscious();
    }

    @Override
    protected String endGameMessage()
    {
        if(!player.isConscious())
        {
            return "Player loses. Game Over.";
        }

        return "";
    }
}