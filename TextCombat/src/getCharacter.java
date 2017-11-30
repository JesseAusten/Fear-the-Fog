import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class getCharacter {

	String charName;
	int charHP;
	int charStamina;
	int charAgility;
	int charIntellect;
	int charStrength;
	String charWeapon;
	String charClass;

	Connection charDB = null;
	Statement charState = null;
	Scanner scanner = new Scanner(System.in);

	public getCharacter() { // retrieve chracter saves

		try {

			Class.forName("org.sqlite.JDBC"); //connect to server
			charDB = DriverManager.getConnection("jdbc:sqlite:textgame.sqlite");

		} catch (Exception e) {

			// error
			System.out.println("error");
		}

		try {

			this.charState = charDB.createStatement();
			ResultSet rs_stats = charState.executeQuery("SELECT character_name FROM characterSave;"); //sql query, get available character names

			while (rs_stats.next()) {

				String name = rs_stats.getString("character_name");

				System.out.println(name);
			}

		} catch (Exception e) {

			// error
			System.out.println("error" + e.getMessage());
		}
		while(charName == null) {
		System.out.println("Please type in the name of the character you wish to select (case sensitive)");
		String characterName = scanner.nextLine(); //take user input

		try {

			ResultSet rs_stats = charState
					.executeQuery("SELECT * FROM characterSave WHERE character_name = \"" + characterName + "\";"); //load user selected character

			charName = rs_stats.getString("character_name"); //set stat values
			charHP = rs_stats.getInt("character_hp");
			charStamina = rs_stats.getInt("character_Stamina");
			charAgility = rs_stats.getInt("character_agility");
			charIntellect = rs_stats.getInt("character_intellect");
			charStrength = rs_stats.getInt("character_strength");
			charWeapon = rs_stats.getString("character_weapon");
			charClass = rs_stats.getString("class");

		} catch (Exception e) {
		
			System.out.println("Invalid input, enter a valid character name.");
		}
		}

	}

	public void closeDB() {

		try {

			charDB.close(); //close db

		} catch (Exception e) {
			// error
			System.out.println("error");

		}

	}

}
