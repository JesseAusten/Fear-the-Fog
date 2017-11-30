import java.util.Scanner;

public class menu { //main menu
	


	public static void main(String[] args) {
		
		

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		boolean play = true;

		while (play) {
			System.out.println("-----------------------------------");
			System.out.println("######## BASIC BITCH RPG ######## ");
			System.out.println("-----------------------------------");
			System.out.println('\n' + "######## Select an option: ######## ");
			System.out.println("Create New Character -- 1");
			System.out.println("Character Select ----------2");
			System.out.println("Exit ---------------3");
			int userInput = scanner.nextInt(); //retrieve user input

			switch (userInput) {

			case 1:

				connectionDB rundb = new connectionDB(); //connect to db and create new character based on user input
				rundb.createclass();
				rundb.savedChar();
				rundb.closeDB();

				break;

			case 2:

				explore start = new explore(); //load char and start game
				start.stateMachine();
				
				break;

			case 3:

				play = false; //exit  game
				break;

			default:
				System.out.println("Invalid Entry"); 

			}

		}

		System.out.println("Game over!");

	}

}
