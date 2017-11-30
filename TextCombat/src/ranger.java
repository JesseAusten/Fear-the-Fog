
public class ranger extends spell {

	public ranger() {

		spell1 = "True Aim";
		spell2 = "Volley";
		spell3 = "Power Shot";
	}

	public void spellOne(character c) {

		damage = 0;
		System.out.println(c.accuracy);
		System.out.println("You steady your aim...!");

		if ((Math.random() * 100 + 1) > (c.accuracy + 15)) {

			System.out.println("You somehow miss... How embarrassing!");

		} else {

			damage = (int) (Math.random() * (c.physicalDamage));
			damageType = "physical";

			if (((int) ((Math.random() * 100) + 1)) < c.critChance) {

				damage *= 2;
				crit = true;
			}

		}

	}

	public void spellTwo(character c) {

		damage = 0;
		z = 0;
		System.out.println("You fire a volley of arrows (Up to 3 hits!)");
		damageType = "physical";

		y = 1;

		while (y <= 3) {

			if (((int) ((Math.random() * 100) + 1)) > c.accuracy) {

				System.out.println("You miss...");

				y++;
			} else {

				damage = 1 + (int) ((Math.random() * (c.physicalDamage) + 1)) / 2;

				if (((int) ((Math.random() * 100) + 1)) < c.critChance) {

					damage *= 2;
					System.out.println("Critical hit!");

				} else {
					System.out.println("You hit!");
				}
				y++;
				z += damage;

			}

		}
		damage = z;

	}

	public void spellThree(character c) {

		damage = 0;

		if (x == 0)
			System.out.println(
					"You begin to charge a powerful shot, you can feel the bow tingling in your hands...(Cast again to release!)");
		x++;

		if (x >= 2) {

			if (((int) (Math.random() * 100) + 1) > (c.accuracy + 10)) {

				System.out.println("You miss .... doh");
				x = 0;

			} else {

				x = 0;
				damage = 4 + (int) ((Math.random() * 10) + 1) + (int) (Math.random() * c.physicalDamage);
				damageType = "physical";

				if (damage >= 10) {

					flavour = "A devastating hit!";
				}
			}

		}

	}

}
