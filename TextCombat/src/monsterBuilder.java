
	public class monsterBuilder {
	
		
	public monsterBuilder() {
		
		
		
		
	}
	
	public static manyMonsters zombie() {
		
		manyMonsters monster = new manyMonsters();
		monster.monsterName = "Zombie";
		monster.monsterDesc = "  dressed in ragged clothing  with the clothes hanging from its bones... ";
		monster.monsterTaunt = " mmMMMMRRRGHaaa...";
		monster.monsterWeapon ="Hands";
		monster.monsterHP = 15 + (int)(Math.random()*10+1);
		monster.monsterDMG = 4;
		monster.monsterAccuracy = 55;
		monster.monsterCritChance = 10;
		monster.monsterCritMulti = 2;
		monster.monsterSpecial = false;
		
		return monster;
		
		
	}
	
	public static manyMonsters goblin() {
		
		manyMonsters monster = new manyMonsters();
		monster.monsterName = "Goblin";
		monster.monsterDesc = " short in stature, but sports a menacing grin... ";
		monster.monsterTaunt = " It's your coin or your life human...";
		monster.monsterWeapon ="Rusty Dagger";
		monster.monsterHP = 15 + (int)(Math.random()*10+1);
		monster.monsterDMG = 3;
		monster.monsterAccuracy = 60;
		monster.monsterCritChance = 15;
		monster.monsterCritMulti = 2;
		monster.monsterSpecial = false;
		
		return monster;
		
		
	}
	
	public static manyMonsters forestTroll() {
		
		manyMonsters monster = new manyMonsters();
		monster.monsterName = "Forest Troll";
		monster.monsterDesc = " big and lumbering with a club the size of a horse... ";
		monster.monsterTaunt = " little human, mmm delcious...";
		monster.monsterWeapon ="Club";
		monster.monsterHP = 25 + (int)(Math.random()*10+1);
		monster.monsterDMG = 7;
		monster.monsterAccuracy = 55;
		monster.monsterCritChance = 7;
		monster.monsterCritMulti = 2;
		monster.monsterSpecial = false;
		
		return monster;
	}
	
	public static manyMonsters wraith() {
		
		manyMonsters monster = new manyMonsters();
		monster.monsterName = "Wraith";
		monster.monsterDesc = " seemingly shimmering in and out of existence... ";
		monster.monsterTaunt = " .......";
		monster.monsterWeapon ="Unknown";
		monster.monsterHP = 20 + (int)(Math.random()*10+1);
		monster.monsterDMG = 5;
		monster.monsterAccuracy = 55;
		monster.monsterCritChance = 1;
		monster.monsterCritMulti = 2;
		monster.monsterSpecial = false;
		
		return monster;
	}
	
public static manyMonsters balrog() {
		
		manyMonsters monster = new manyMonsters();
		monster.monsterName = "Balrog";
		monster.monsterDesc = " wreathed in shadow and flame... ";
		monster.monsterTaunt = " .......";
		monster.monsterWeapon ="Unknown";
		monster.monsterHP = 40 + (int)(Math.random()*10+1);
		monster.monsterDMG = 5;
		monster.monsterAccuracy = 55;
		monster.monsterCritChance = 1;
		monster.monsterCritMulti = 2;
		monster.monsterSpecial = true;
		monster.monsterAmp = 1.5;
		monster.monsterFlavour = "The balrog let's out a deafening roar, causing you to cower and taker increased damage!";
		
		
		
		return monster;
	}

}