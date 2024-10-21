import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameWorld {
    private static GameWorld instance;

    // Attributes GameWorld
    private String[][] worldMap;
    private List<String> locations;
    private List<NPC> npcs;
    private String timeOfDay;
    private String weatherConditions;

    // Private Constructor
    private GameWorld() {
        this.worldMap = new String[10][10];
        this.locations = new ArrayList<>();
        this.npcs = new ArrayList<>();
        this.timeOfDay = "Day";
        this.weatherConditions = "Sunny";

        initializeWorld();
    }

    // Method to access the singleton instance
    public static GameWorld getInstance() {
        if (instance == null) {
            instance = new GameWorld();
        }
        return instance;
    }

    private void initializeWorld() {
        for (int i = 0; i < worldMap.length; i++) {
            for (int j = 0; j < worldMap[i].length; j++) {
                worldMap[i][j] = "Empty";
            }
        }

        locations.add("Town Center");
        locations.add("Dark Forest");
        locations.add("Mystic Cave");

        NPC npc1 = new NPC();
        npc1.setName("Farmer");
        npc1.setRole("Farming");
        npc1.setStatus("Working");

        NPC npc2 = new NPC();
        npc2.setName("Merchant");
        npc2.setRole("Selling");
        npc2.setStatus("Working");
    }

    public String[][] getWorldMap() {
        return worldMap;
    }

    public String getLocations() {
        Random random = new Random();
        int num = random.nextInt(3);
        return locations.get(num);
    }

    public List<NPC> getNpcs() {
        return npcs;
    }

    public String getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(String timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    public String getWeatherConditions() {
        return weatherConditions;
    }

    public void setWeatherConditions(String weatherConditions) {
        this.weatherConditions = weatherConditions;
    }

    public void setLocation(int x, int y, String value) {
        if (x >= 0 && x < worldMap.length && y >= 0 && y < worldMap[x].length) {
            worldMap[x][y] = value;
        }
    }

}
