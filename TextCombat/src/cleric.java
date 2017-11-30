
public class cleric extends spell {

	public cleric() {

		spell1 = "Searing Light";
		spell2 = "Amplify Damage";
		spell3 = "Ethereal Weapon";
	}

	public void spellOne(character c) {

		damage = 0;

		System.out.println("You call down a searing ray of light");

		if (((Math.random() * 100) + 1) > c.accuracy) {

			System.out.println("You miss...");
		} else {

			damage = (int) (Math.random() * 6) + 1;
			dot = (int) (Math.random() * 4) + 1;
			dotDuration = 3;
			damageType = "fire";
			
			flavour = "Due to his wounds, your target takes fire damage the the next 3 turns!";


		}

	}

	public void spellTwo(character c) {

		System.out
				.println("You bathe your enemy in a dark energy... he will take increased damage from your abilities");

		damageAmp = 1.5;
		ampExists = true;

	}

	public void spellThree(character c) {
		System.out.println("Your staff transforms into a shimmering blade, the razor edge looks deadly...");
		c.charWeapon = "Ethereal Blade";
		c.physicalDamage = 12;
		damageType = "arcane";

	}

	public void spellFour(character c) {
	}

	public void Combat(character c) {
	}

	public double getDamageAmp() {

		return damageAmp;
	}

}
