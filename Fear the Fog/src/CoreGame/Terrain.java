package CoreGame;

public class Terrain {
	
	private String name;
	private Tile[] tileSet;
	

	public Terrain(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
