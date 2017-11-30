import java.util.Scanner;

public class Combat {

	private String spell1;
	private String spell2;
	private String spell3;
	private String damageType;
	private boolean crit;
	private int damage;
	private spell setSpell;
	private manyMonsters currentMonster;
	private int dot;
	private int dotDuration;
	private int duration = 1;
	private double amp = 1;
	
	
	

	Scanner scanner = new Scanner(System.in);

	public void gameStart(character current) {

		switch (current.charClass) { // call spellbook for the appropriate class

		case "Mage":

			setSpell = new mage();

			break;

		case "Ranger":

			setSpell = new ranger();

			break;

		case "Cleric":

			setSpell = new cleric();

		}

		spell1 = setSpell.spell1; // set the spell names
		spell2 = setSpell.spell2;
		spell3 = setSpell.spell3;

		// generate random monsters
		manyMonsters[] monsterArray = { monsterBuilder.zombie(), monsterBuilder.goblin(), monsterBuilder.forestTroll(),
				monsterBuilder.wraith(), monsterBuilder.balrog() };

		int randomMon = (int) (Math.random() * monsterArray.length);
		currentMonster = monsterArray[randomMon]; // set current monster to selected random monster

		System.out.printf("\nA %s approaches you, it is%s", currentMonster.monsterName, currentMonster.monsterDesc);
		scanner = new Scanner(System.in);

		while (current.hp > 0 && currentMonster.monsterHP > 0) { // initiate combat
			
			damage = 0;

			System.out.printf("\n%s Current HP : %d -------- %s Current HP: %d \n", current.charName, current.hp,
					currentMonster.monsterName, currentMonster.monsterHP);
			System.out.println("Select your attack!");
			System.out.println(spell1 + "---------1");
			System.out.println(spell2 + "---------2");
			System.out.println(spell3 + "---------3");
			System.out.println("Melee-------------4"); // spell select menu

			int select = scanner.nextInt();

			switch (select) {

			case 1: // use selected spell

				setSpell.spellOne(current);
				damage = setSpell.damage;
				dot = setSpell.dot;
				dotDuration = setSpell.dotDuration;
				if(setSpell.ampExists)amp = setSpell.damageAmp;
				damageType = setSpell.damageType;
				crit = setSpell.crit;
				
				break;

			case 2:

				setSpell.spellTwo(current);
				damage = setSpell.damage;
				dot = setSpell.dot;
				dotDuration = setSpell.dotDuration;
				if(setSpell.ampExists)amp = setSpell.damageAmp;
				damageType = setSpell.damageType;
				crit = setSpell.crit;
				
				break;

			case 3:

				setSpell.spellThree(current);
				damage = setSpell.damage;
				dot = setSpell.dot;
				dotDuration = setSpell.dotDuration;
				if(setSpell.ampExists)amp = setSpell.damageAmp;
				damageType = setSpell.damageType;
				crit = setSpell.crit;
				break;

			case 4:

				meleeCombat combat = new meleeCombat();
				combat.Combat(current);
				damage = combat.damage;
				damageType = combat.damageType;
				crit = combat.crit;
				break;

			default:
				System.out.println("Invalid Selection");
			}

			// deal damage
			
			damage *= amp;
			if(damage > 0) {
			if(!crit)System.out.println("You hit dealing "+damage+" "+damageType+" damage!"); else System.out.println("You critically strike dealing "+damage+" "+damageType+" damage!");
			if(setSpell.flavour != null)System.out.println(setSpell.flavour);
			}
			
			currentMonster.monsterHP -= damage;
			
			
			// enemy turn
			
			if(currentMonster.monsterHP > 0) {
			enemyCombat monTurn = new enemyCombat(currentMonster);
			damage = monTurn.getDamage();
			current.hp -= damage;
			}

			if (duration <= dotDuration) {//deal dot damage

				System.out.println(currentMonster.monsterName + " takes " + dot +" "+setSpell.damageType+ " damage from his wounds...");
				dot *= amp;
				currentMonster.monsterHP -= dot;
				duration++;

			}

			// end combat
			if (current.hp <= 0) {

				System.out.println('\n' + "You have been defeated!");
			}

			if (currentMonster.monsterHP <= 0) {

				System.out.println('\n' + currentMonster.monsterName + " has been defeated!" + '\n');
			}

		}

	}

}
