
public class character  {
	 String charName;
	 String charClass;
	 String charWeapon;
	 int stamina;
	 int agility;
	 int intellect;
	 int strength;
	 int hp;
	 int accuracy;
	 int physicalDamage;
	 int spellDamage;
	 int critChance;
	 int dodgeChance;
	 int damage;
	 int critMulti;

	public void characterLoad(getCharacter loadChar) {
		
		

		charName = loadChar.charName;
		charClass = loadChar.charClass;
		hp = loadChar.charHP;
		stamina = loadChar.charStamina;
		agility = loadChar.charAgility;
		intellect = loadChar.charIntellect;
		strength = loadChar.charStrength;
		charWeapon = loadChar.charWeapon;
		
		hp += stamina;
		accuracy = 50 + (int)(agility *.6) + (int)(strength *.6) + (int)(intellect *.6);
		physicalDamage = 2 + (strength / 3) + (agility / 3);
		spellDamage = 3 + (intellect /2);
		critChance = 5 + (agility / 2) + (strength / 3);
		dodgeChance = 5 + (agility / 2) + (strength / 2)+ (intellect / 2);
		critMulti = (int)(2 + (strength * .1));
		
		
		loadChar.closeDB();
		
	}

}
