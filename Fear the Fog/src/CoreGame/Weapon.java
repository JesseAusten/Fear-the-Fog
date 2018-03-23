package CoreGame;

public class Weapon {
	
	private String name;
	private int damage;
	private int reach;
	
	public Weapon(String name, int damage, int reach) {
		this.name = name;
		this.damage = damage;
		this.reach = reach;
	}
	
	public String getName() {
		return name;
	}

	public int getDamage() {
		return damage;
	}

	public int getReach() {
		return reach;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public void setReach(int reach) {
		this.reach = reach;
	}

}
