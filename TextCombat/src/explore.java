
public class explore {

	private static String state = "Travel"; //default state
	private boolean game = true;
	private int v = 0;
	
	getCharacter getChar = new getCharacter(); //character select
	
	character loadChar = new character();
	

	public void stateMachine() {
		
		game = true;
		
		loadChar.characterLoad(getChar); //load in character stats
		gamePlay(loadChar);
		
		while(game) {

		switch(state) {
		
		case "Travel" :
			
			travel Travel = new travel(); //go to travel method
			loadChar.hp += Travel.getHeal();
			state = "Combat";
			break;
			
		case "Combat" :
			
			 //load combat and combat stats
			
			Combat test = new Combat();
			test.gameStart(loadChar);
			getChar.closeDB();
			if(loadChar.hp > 0) {state = "Travel";} else state = "Defeat";
			break;
			
		case "Defeat" :
			
			game = false;
			
			
			
			
			
		
			}

		}
		
	}
	
	
	public void gamePlay(character current) {

		System.out.println("You have chosen: " + '\n');
		System.out.printf(
				"Name: %s \nClass: %s \nHP: %d \nAccuracy: %d \nDamage: %d \nSpell Damage: %d \nCrit Chance: %d \nDodge Chance: %d \nWeapon: %s \n",
				current.charName, current.charClass, current.hp, current.accuracy, current.physicalDamage,
				current.spellDamage, current.critChance, current.dodgeChance, current.charWeapon); // display character
																									// stats

	}

}


