package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.*;

public class Application {


	public static void main(String[] args) {
		 World world = new World(new Display());

		 FancyGroundFactory groundFactory = new FancyGroundFactory(new Floor(), new Wall(), new RocketPad());
		 GameMap gameMap;

		List<String> map = Arrays.asList(
				".......................",
				"....#####....######....",
				"....#...#....#....#....",
				"....#........#....#....",
				"....#####....######....",
				".......................",
				".......................",
				".......................",
				".......................",
				".......................",
				"...........Ŕ...........");
		gameMap = new GameMap(groundFactory, map);
		world.addMap(gameMap);
		
		Actor player = new Player("Player", '@', 1, 100);
		world.addPlayer(player, gameMap, 2, 11);

        Key key1 = new Key("Key 1",1).newKeyInstance("Key 1",1);
        Key key2 = new Key("Key 2", 2).newKeyInstance("Key 2",2);

        Door door1 = new Door(key1);
        gameMap.add(door1,gameMap.at(8,3));

        Door door2 = new Door(key2);
        gameMap.add(door2,gameMap.at(15,4));

//        Initialize Grunts
		Grunt grunt = new Grunt("Mongo", player);
		gameMap.addActor(grunt, 0, 0);
		Grunt grunt2 = new Grunt("Norbert", player);
		gameMap.addActor(grunt2,  10, 10);

//        Initialize Goons
		Goon goon = new Goon("Vimuthy", player);
		goon.addItemToInventory(key1);
		gameMap.addActor(goon, 0,6);

		Goon goon1 = new Goon("Rashad", player);
		goon1.addItemToInventory(key2);
		gameMap.addActor(goon1, 0,10);

        DoctorMaybe doctorMaybe = new DoctorMaybe();
        gameMap.addActor(doctorMaybe, 5, 2);



//		Ninja ninja = new Ninja("Nick", player);
//		gameMap.addActor(ninja,0,0);

//		gameMap.addActor(doctorMaybe, 0,0);
//
//		Q q = new Q();
//		gameMap.addActor(q,0,0);
//
//		RocketPlans rocketPlans = new RocketPlans();
//		gameMap.addItem(rocketPlans,0,1);
			
		world.run();
	}
}
