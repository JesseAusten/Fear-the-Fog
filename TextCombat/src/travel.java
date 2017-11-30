import java.util.Scanner;

public class travel {
	private int heal=0;
	private int x = 1; // counter variable
	private int m; // distance counter
	private int terrain; // increase / decrease encounter chance
	private int travelDistance; // number of encounter 'rolls'
	private boolean monsterEncounter;

	public travel() {

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		while (!monsterEncounter) {
			
			m=0;
			System.out.println('\n'+"What would you like to do?");
			System.out.println("Follow the road (500m) ----- 1");
			System.out.println("Take the forest path (300m) ----- 2");
			System.out.println("Rest (0m)  ----- 3");

			int select = scanner.nextInt(); //take user input
				
					
				switch (select) {

			case 1:

				travelDistance = 5; // road distance (1 roll per 100m)
				terrain = 2; // terrain difficulty (monster encounter chance)

				break;

			case 2:

				travelDistance = 3; // see case 1
				terrain = 4;

				break;

			case 3:

				travelDistance = 0; // rest, no rolls and gain 5 hp
				heal = 5;
				

				break;
				
				default : System.out.println("Invalid input!");
							select = 0;
			}

			while (m < travelDistance) { //roll until travel distance is met, or monster is encountered

				if (((Math.random() * 100) + 1) < x) { // if true, monster has been encountered

					System.out.println("You can see an enemy approaching!");
					System.out.println("What would you like to do?");
					System.out.println("Stand and fight! ---- 1");
					System.out.println("Run away! ------------2");

					int fightOrFlight = scanner.nextInt(); //take user input

					switch (fightOrFlight) {

					case 1:

						monsterEncounter = true; //fight the monster
						m = travelDistance; // end the while loop
						break;

					case 2:

						if (((Math.random() * 100) + 1) < 20) { //attempt to run away
							
							System.out.println("You successfully run away!"); //successfully run away

							break;
							
						} else {
							System.out.println("Despite your best efforts the enemy creature has caught up with you..");
							monsterEncounter = true; // fail to run away, start monster encounter
							m = travelDistance;

						}
						break;

					}

				} else {

					m++; // move 100m
				}

				x += terrain; // increase encounter chance

				System.out.println(x); // debug

			}
			
			if(!monsterEncounter) {
				if (travelDistance > 0) System.out.println("You arrive safely with no issues..."); else System.out.println("You rest, gaining 5 hp...");
				
			} 

		}

	}
	
	public int getHeal() {
		
		return heal; // set heal value
	}

}
