package CoreGame;

public class Monster {
	private int maxHealth;
	private int currentHealth;
	private int size;
	private int speed;
	private int damage;

	public Monster(int maxHealth, int size, int speed, int damage) {
		this.maxHealth = maxHealth;
		currentHealth = maxHealth;
		this.size = size;
		this.speed = speed;
		this.damage = damage;
	}

	public Monster(int maxHealth, int currentHealth, int size, int speed, int damage) {
		this.maxHealth = maxHealth;
		this.currentHealth = currentHealth;
		this.size = size;
		this.speed = speed;
		this.damage = damage;
	}

	public void takeDamage(int damagetaken) {
		currentHealth -= damagetaken;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
}
