package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.*;
import game.enemy.*;

public class Application {


	public static void main(String[] args) {
		 World world = new World(new Display());

		 FancyGroundFactory groundFactory = new FancyGroundFactory(new Floor(), new Wall(), new Water(), new LunarSoil());
		 GameMap gameMap;

		List<String> map = Arrays.asList(
				".......................",
				"....#####....######....",
				"....#...#....#....#....",
				"....#........#....#....",
				"....#####....##.###....",
				".......................",
				".......................",
				".......................",
				".......................",
				"...wwwww...............",
				"...wwwww...............");
		gameMap = new GameMap(groundFactory, map);
		world.addMap(gameMap);

		List<String> Moon = Arrays.asList(
				"0000000000",
				"0000000000",
				"0000000000",
				"0000000000",
				"0000000000",
				"0000000000",
				"0000000000",
				"0000000000",
				"0000000000",
				"00000.0000");

		GameMap moon = new GameMap(groundFactory, Moon);
		world.addMap(moon);


		newPlayer player = new newPlayer("Player", '@', 1, 100, gameMap.at(11,10));

		SpaceSuit spaceSuit = new SpaceSuit();
		gameMap.addItem(spaceSuit,13,9);
//		world.addPlayer(player, gameMap, 2, 11);
//
//
//      Key key1 = new Key("Key 1",1).newKeyInstance("Key 1",1);
//      Key key2 = new Key("Key 2", 2).newKeyInstance("Key 2",2);

//      Key key1 = new Key("Key 1",1);
//      Key key2 = new Key("Key 2", 2);
//
//      Door door1 = new Door(key1);
//      gameMap.add(door1, gameMap.at(8,3));
//
//      Door door2 = new Door(key2);
//      gameMap.add(door2, gameMap.at(15,4));
//
////        Initialize Grunts
//		Grunt grunt = new Grunt("MongoK", player);
//		gameMap.addActor(grunt, 0, 5);
//		grunt.addItemToInventory(key1);
//		Grunt grunt2 = new Grunt("Norbert", player);
//		gameMap.addActor(grunt2,  10, 10);
//
////        Initialize Goons
//		Goon goon = new Goon("Karian", player);
//		goon.addItemToInventory(key2);
//		gameMap.addActor(goon, 20,6);
//
//		Goon goon1 = new Goon("Rashad", player);
//		gameMap.addActor(goon1, 0,10);
//
//      DoctorMaybe doctorMaybe = new DoctorMaybe();
//      gameMap.addActor(doctorMaybe, 6, 3);
//
//		Ninja ninja = new Ninja("Ninja", player);
//		gameMap.addActor(ninja,5,5);
//
//		Q q = new Q();
//		gameMap.addActor(q,19,9);
//
//		RocketPlans rocketPlans = new RocketPlans();
//		gameMap.addItem(rocketPlans,16,3);

//		CHARACTERS IN MOON		\\

//		Grunt moonGrunt1 = new Grunt("Mims", player);
//		moon.addActor(moonGrunt1, 0, 0);
//
//		Grunt moonGrunt2 = new Grunt("Mims2", player);
//		moon.addActor(moonGrunt2, 0, 0);

//		Rocket rocket = new Rocket(moon.at(9,6));
//		gameMap.add(rocket, gameMap.at(10,10));

//		Rocket moonRocket = new Rocket(gameMap.at(11,9));
//		moon.add(moonRocket, moon.at(5,9));





//		TO TEST     \\
		world.addPlayer(player, gameMap, 10, 13);
//		gameMap.addItem(new SpaceSuit(), 13,9);

		YugoMaxx yugoMaxx = new YugoMaxx();
		gameMap.addActor(yugoMaxx, 0,7);

		gameMap.addItem(new WaterPistol(), 13, 9);

		OxygenDispenser ox = new OxygenDispenser();
		gameMap.add(ox,gameMap.at(11,8));
//
		Rocket rocket = new Rocket(moon.at(5,8));
		gameMap.add(rocket, gameMap.at(11,10));
//
		RocketEngine rocketEngine = new RocketEngine();
		gameMap.addItem(rocketEngine,11,9);

		RocketBody rocketBody = new RocketBody();
		gameMap.addItem(rocketBody, 12,9);
//
		RocketPad rocketPad = new RocketPad(moon.at(5,8));
		gameMap.add(rocketPad, gameMap.at(11,10));

//		gameMap.addItem(key1, 11, 9);
//		gameMap.addItem(key2, 12,9);


		world.run();
	}
}
