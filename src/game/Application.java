package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.*;
import game.WaterPistol.Water;
import game.WaterPistol.WaterPistol;
import game.enemy.*;
import game.oxygen.OxygenDispenser;
import game.rocket.*;

public class Application {


	public static void main(String[] args) {
		 World world = new NewWorld(new Display());

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
				".......................",
				".....www......www......");
		gameMap = new GameMap(groundFactory, map);
		world.addMap(gameMap);

		List<String> Moon = Arrays.asList(
				"░░░░░░░░░░░░░░░░░░░░",
				"░░░░░░░░░░░░░░░░░░░░",
				"░░░░░░░░░░░░░░░░░░░░",
				"░░░░░░░░░░░░░░░░░░░░",
				"░░░░░░░░░░░░░░░░░░░░",
				"░░░░░░░░░░░░░░░░░░░░",
				"░░░░░░░░░░░░░░░░░░░░",
				"░░░░░░░░░░░░░░░░░░░░",
				"░░░░░░░░░░░░░░░░░░░░",
				"░░░░░░░░░░░░░░░░░░░░");

		GameMap moon = new GameMap(groundFactory, Moon);
		world.addMap(moon);


		newPlayer player = new newPlayer("Player", '@', 1, 100, gameMap.at(11,10));

		world.addPlayer(player, gameMap, 6, 10);


//		Initialize the keys to be given to the enemies:

      	Key key1 = new Key("Key 1",1).newKeyInstance("Key 1",1);
      	Key key2 = new Key("Key 2", 2).newKeyInstance("Key 2",2);


//		Initialize the Doors:

      	Door door1 = new Door(key1);
      	gameMap.add(door1, gameMap.at(8,3));

      	Door door2 = new Door(key2);
      	gameMap.add(door2, gameMap.at(15,4));


//        Initializing the Enemies:

//		Grunts:
		Grunt grunt = new Grunt("MongoK", player);
		gameMap.addActor(grunt, 0, 5);
		grunt.addItemToInventory(key1);

		Grunt grunt2 = new Grunt("Norbert", player);
		gameMap.addActor(grunt2,  5, 0);

//		Goons:
		Goon goon = new Goon("Karian", player);
		goon.addItemToInventory(key2);
		gameMap.addActor(goon, 20,6);

		Goon goon1 = new Goon("Rashad", player);
		gameMap.addActor(goon1, 0,10);

//		DoctorMaybe:
		DoctorMaybe doctorMaybe = new DoctorMaybe();
		gameMap.addActor(doctorMaybe, 6, 3);

//		Ninja:
		Ninja ninja = new Ninja("Ninja", player);
		gameMap.addActor(ninja,8,5);


//		Initializing Helpful Character Q:

		Q q = new Q();
		gameMap.addActor(q,19,9);


//		Initializing Rocket elements and Pad:

//		RocketPlans:
		RocketPlans rocketPlans = new RocketPlans();
		gameMap.addItem(rocketPlans,16,3);

		YugoMaxx yugoMaxx = new YugoMaxx();
		moon.addActor(yugoMaxx, 9,0);

//		RocketPad:
		RocketPad rocketPad = new RocketPad(moon.at(9,8), yugoMaxx);
		gameMap.add(rocketPad, gameMap.at(11,10));

//		SpaceSuit:
		gameMap.addItem(new SpaceSuit(), 13,9);

//		Oxygen Dispenser:
		OxygenDispenser oxygenDispenser = new OxygenDispenser();
		gameMap.add(oxygenDispenser, gameMap.at(11,8));



//		CHARACTERS IN MOON		\\

		Grunt moonGrunt1 = new Grunt("Jerry", player);
		moon.addActor(moonGrunt1, 0, 0);

		Grunt moonGrunt2 = new Grunt("Tom", player);
		moon.addActor(moonGrunt2, 19, 9);

		Goon moonGoon1 = new Goon("Jeremy", player);
		moon.addActor(moonGoon1, 19,0);

		Goon moonGoon2 = new Goon("Richard", player);
		moon.addActor(moonGoon2, 0,9);


//		Initializing Rocket in the Moon:

		Rocket moonRocket = new Rocket(gameMap.at(11,10),yugoMaxx);
		moon.add(moonRocket, moon.at(9,9));

		WaterPistol waterPistol = new WaterPistol();
		moon.addItem(waterPistol, 9,4);



//		TO TEST     \\
//		world.addPlayer(player, gameMap, 10, 13);
//		gameMap.addItem(new SpaceSuit(), 13,9);

//		gameMap.addItem(new WaterPistol(), 13, 9);

//		Rocket rocket = new Rocket(moon.at(5,8));
//		gameMap.add(rocket, gameMap.at(11,10));

//		RocketEngine rocketEngine = new RocketEngine();
//		gameMap.addItem(rocketEngine,11,9);

//		RocketBody rocketBody = new RocketBody();
//		gameMap.addItem(rocketBody, 12,9);

//		Rocket rocket = new Rocket(moon.at(9,6));
//		gameMap.add(rocket, gameMap.at(10,10));

//  	gameMap.addItem(key1, 11, 9);
//		gameMap.addItem(key2, 12,9);


		world.run();
	}
}
