package CoreGame;

public class Terrain {

	public enum TerrainTypes {

		LINE("Line"), L_BLOCK("L-Block"), SQUARE("Square"), SHORT_LINE("Short Line"); // TO DO: Create patterns in JSON file
																						

		private final String name;

		private TerrainTypes(String type) {

			this.name = type;

		}

		public String getName() {

			return this.name;
		}

	}

	private String name;
	private Tile[] tileSet;
	private int row;
	private int col;
	
	 // Constructor using enum cosntants for premade terrain types

	public Terrain(TerrainTypes type) {

		this.name = type.getName();
		PatternIO load = new PatternIO();
		int[][] pattern = load.loadPattern(type.getName());
		tileSet = new Tile[pattern[0].length];

		for (int i = 0; i < (tileSet.length - 1); i++) {

			tileSet[i] = new Tile(false, false, true, false, pattern[0][i], pattern[1][i]);

		}

	}
	
	// Constructor takes a string for custom terrain 
	
	public Terrain(String type) { 
		
		this.name = type;
		PatternIO load = new PatternIO();
		int[][] pattern = load.loadPattern(type);
		tileSet = new Tile[pattern[0].length];

		for (int i = 0; i < (tileSet.length - 1); i++) {

			tileSet[i] = new Tile(false, false, true, false, pattern[0][i], pattern[1][i]);

		}
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
