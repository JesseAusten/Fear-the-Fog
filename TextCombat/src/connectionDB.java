import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class connectionDB {

	private String charname;
	private int hp;
	private int stamina;
	private int agility;
	private int intellect;
	private int strength;
	private String weapon;
	private String classname;
	private Scanner scanner;

	Connection test = null;
	Statement statement = null;

	public connectionDB() {

		// Attempt to connect

		try {

			Class.forName("org.sqlite.JDBC");
			test = DriverManager.getConnection("jdbc:sqlite:textgame.sqlite");

		} catch (Exception e) {

			// error
			System.out.println("error");
		}
	}

	public void createclass() {

		scanner = new Scanner(System.in);

		try { // getting base stats!

			System.out.println("Please select the class you would like to create" + '\n');
			System.out.println("1 -- Mage");
			System.out.println("2 -- Warrior");
			System.out.println("3 -- Paladin");
			System.out.println("4 -- Ranger");
			System.out.println("5 -- Rogue");
			System.out.println("6 -- Cleric");

			int getClass = scanner.nextInt(); // Select which stat sheet to retrieve

			classname = null;

			switch (getClass) {

			case 1:
				classname = "Mage";
				break;
			case 2:
				classname = "Warrior";
				break;
			case 3:
				classname = "Paladin";
				break;
			case 4:
				classname = "Ranger";
				break;
			case 5:
				classname = "Rogue";
				break;
			case 6:
				classname = "Cleric";
				break;

			}

			this.statement = test.createStatement(); // execute SQL query
			ResultSet rs_stats = statement
					.executeQuery("SELECT * FROM characterBasestats WHERE class_name = \"" + classname + "\";)");

			while (rs_stats.next()) {

				// convert into variables

				hp = rs_stats.getInt("class_hp");
				stamina = rs_stats.getInt("class_stamina");
				agility = rs_stats.getInt("class_agility");
				intellect = rs_stats.getInt("class_intellect");
				strength = rs_stats.getInt("class_strength");
				weapon = rs_stats.getString("class_weapon");

			}
		} catch (Exception e) {// error
		}

		System.out.println("Enter your character name: "); // pick character name
		scanner.nextLine();
		charname = scanner.nextLine();

		// generating base hp
		hp += (int) ((Math.random() * stamina) / 2);

	}

	public void savedChar() {
		try {
			// save new character to the DB
			this.statement = test.createStatement();
			statement.executeUpdate(
					"INSERT INTO characterSave(character_name, character_hp, character_stamina, character_agility, character_intellect, character_strength, character_weapon, class) VALUES(\""
							+ charname + "\", " + hp + ", " + stamina + " ," + agility + ", " + intellect + ", "
							+ strength + ", \"" + weapon + "\", \"" + classname + "\");");

		} catch (Exception e) {
			System.out.println("error: " + e.getMessage());
		}

	}

	public void closeDB() {

		try {
			// close connection with the DB
			test.close();

		} catch (Exception e) {
			// error
			System.out.println("error");

		}
	}

}
