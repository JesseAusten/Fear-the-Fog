
public class meleeCombat  {
	
	int damage;
	String damageType;
	boolean crit;

	public void Combat(character c) {

		damage = 0;
		damageType = "physical";
		crit = false;

		if (((Math.random()*100)+1) > (c.accuracy)) { // Player turn

			System.out.println("You miss!");

		} else {

			damage = (int) (Math.random() * c.physicalDamage) + 1;

			if ((Math.random() * 100 + 1) < c.critChance) {

				damage *= 2;
				crit = true;

			} 

		}

	}

}
