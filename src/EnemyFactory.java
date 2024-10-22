public class EnemyFactory {
    public static Enemy createEnemy(String type, int level) {
        Enemy enemy;
        switch (type.toLowerCase()) {
            case "slime v1" :
                enemy = new Slime(level,10, 5, 5, "Normal" );
                break;
            case "goblin v2" :
                enemy = new Goblin(level, 20, 10, 10, "Normal");
                break;
            case "goblin v3" :
                enemy = new Goblin(level, 30, 15, 15, "Advance");
                break;
            case "dragon v1" :
                enemy = new Dragon(level, 40, 20, 20, "Superior");
                break;
            case "dragon v2" :
                enemy = new Dragon(level, 50, 25, 25, "Superior");
                break;
            default:
                throw new IllegalArgumentException("Unknown character type");
        }
        return enemy;
    }
}
