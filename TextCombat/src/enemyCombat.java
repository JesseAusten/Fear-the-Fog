
public class enemyCombat {

	int damage;
	double damageAmp = 1;

	public enemyCombat(manyMonsters x) {

		if (x.monsterSpecial) {

			if (((Math.random() * 100) + 1) > 66) {

				damageAmp = x.monsterAmp;
				System.out.println(x.monsterFlavour);

			}

		}
		if (((Math.random() * 100) + 1) < x.monsterAccuracy) { // monster turn

			System.out.println(x.monsterName + " attacks and misses!");

		} else {

			damage = (int) (Math.random() * x.monsterDMG) + 1;

			if (((Math.random() * 100) + 1) < x.monsterCritChance) {

				damage *= x.monsterCritMulti;

				System.out.println(x.monsterName + " critically strikes for " + damage + " damage!");

			} else {

				System.out.println(x.monsterName + " hits for " + damage + " damage");
			}

		}

	}

	public int getDamage() {

		return damage;
	}

}
