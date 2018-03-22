
public class mage extends spell {
	private int x = 3; // Pyro accuracy
	private int d = 0; // arcane +damage
	private int a = 0; // arcane -damage
	private int y; // counter var for hail storm
	private int z; // sum var for hail storm
	private int gg;

	public mage() {

		spell1 = "Pyroblast"; //set spell names
		spell2 = "Arcane Blast";
		spell3 = "Hail Storm";
	}

	public void spellOne(character c) {

		damage = 0; //reset damage
		System.out.println("You unleash a massive ball of fire!");

		if ((Math.random() * 100 + 1) > (c.accuracy - x)) { //check for hit

			System.out.println("You miss ... maybe try an easier spell"); 

		} else { //hit

			damage = (int) (Math.random() * 15 + (Math.random() * c.spellDamage)); // calculate damage

			damageType = "fire";
			
			flavour = "The strain of the spell has reduced your accuracy on the next cast by " + x;

		}

		x++; //reduces spell accuracy

		

	}

	public void spellTwo(character c) {

		damage = 0;
		System.out.println("You summon the power of the arcane...!");

		if ((Math.random() * 100 + 1) > (c.accuracy)) {

			System.out.println("You miss, the air around you vibrates angrily");
			if ((d - a) < 0) //check current damage decrease
				System.out.println("The arcane energy dissapates from your veins, you lose " + Math.abs(d - a)
						+ " damage on your next cast of Arcane Blast");
			a = (d - a) - 2 <= 0 ? 0 : a + 2; // cant go below zero
		} else {

			damage = (d - a) > 0 ? (d - a) + 3 + (int) (Math.random() * c.spellDamage) //calculate damage
					: (int) (Math.random() * c.spellDamage) + 3;
			

			damageType = "arcane";
			if ((d - a) > 0)
				flavour = "You can feel the arcane energy building in your veins, you gain " + (d - a)
						+ " damage on your next Arcane Blast cast";
			d += 2;
		}

	}

	public void spellThree(character c) {

		damage = 0;
		z = 0;
		System.out.println("You call down a hail of ice! (Up to 3 hits!)");
		y = 1;

		while (y <= 3) {
			if ((int) Math.random() * 100 + 1 > c.accuracy) {

				System.out.println("You miss ... how?");
			} else {

				damage = (int) ((Math.random() * (c.spellDamage) + 1)) / 2;
				damageType = "ice";
				y++;
				z += damage;

			}

		}

		damage = z;

	}

}
