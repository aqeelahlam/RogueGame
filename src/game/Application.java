package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.FancyGroundFactory;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Player;
import edu.monash.fit2099.engine.World;

public class Application {


	public static void main(String[] args) {
		 World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Floor(), new Wall(), new Door(), new RocketPad());
		GameMap gameMap;

		List<String> map = Arrays.asList(
				".......................",
				"....#####....######....",
				"....#...#....#....#....",
				"....#...†....#....#....",
				"....#####....##†###....",
				".......................",
				".......................",
				".......................",
				".......................",
				".......................",
				"...........Ŕ...........");
		gameMap = new GameMap(groundFactory, map);
		world.addMap(gameMap);
		
		Actor player = new Player("Player", '@', 1, 100);
		world.addPlayer(player, gameMap, 2, 2);
		
//		Grunt grunt = new Grunt("Mongo", player);
//		gameMap.addActor(grunt, 0, 0);
//		Grunt grunt2 = new Grunt("Norbert", player);
//		gameMap.addActor(grunt2,  10, 10);
//		Goon goon = new Goon("Vimuthy", player);
//		gameMap.addActor(goon, 0,6);
//
//		Goon goon1 = new Goon("Rashad", player);
//		gameMap.addActor(goon1, 0,10);
//		Ninja ninja = new Ninja("Nick", player);
//		gameMap.addActor(ninja,0,0);
//		DoctorMaybe doctorMaybe = new DoctorMaybe();
////		gameMap.addActor(doctorMaybe, 5, 2);
//		gameMap.addActor(doctorMaybe, 0,0);

		Q q = new Q();
		gameMap.addActor(q,0,0);
//
		RocketPlans rocketPlans = new RocketPlans();
		gameMap.addItem(rocketPlans,0,1);

//		RocketBody rocketBody = new RocketBody();
//		gameMap.addItem(rocketBody,9,10);

//		RocketEngine rocketEngine = new RocketEngine();
//		gameMap.addItem(rocketEngine,8,10);

			
		world.run();
	}
}
