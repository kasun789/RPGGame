import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    static Scanner scan = new Scanner(System.in);


    private static Character buildCharacter(String playerName, int level) {
        System.out.println("\n Choose your Character: ");
        System.out.println("'w' for warrior");
        System.out.println("'a' for archer");
        System.out.println("'m' for mage");

        String charClass = scan.nextLine();
        Character playerCharacter;

        if (charClass.charAt(0) == 'w') {
            playerCharacter = CharacterFactory.createCharacter("warrior", playerName, level);
        } else if (charClass.charAt(0) == 'a') {
            playerCharacter = CharacterFactory.createCharacter("archer", playerName, level);
        } else if (charClass.charAt(0) == 'm') {
            playerCharacter = CharacterFactory.createCharacter("mage", playerName, level);
        } else {
            throw new IllegalArgumentException("Invalid character class selected.");
        }

        playerCharacter.displayStats();
        return playerCharacter;
    }

    public static void main(String[] args) {
        GameWorld gameWorld = GameWorld.getInstance();
        QuestManager questManager = new QuestManager();
        ActionManager actionManager = new ActionManager();
        Character playerCharacter = null;
        ArrayList<String> enemies = new ArrayList<>();

        enemies.add("Slime v1");
        enemies.add("Goblin v2");
        enemies.add("Goblin v3");
        enemies.add("Dragon v1");
        enemies.add("Dragon v2");

        System.out.println("Enter your Name: ");
        String playerName = scan.nextLine();

        // Game loop for levels
        for (int currentLevel = 1; currentLevel <= 5; currentLevel++) {
            playerCharacter = buildCharacter(playerName, currentLevel);
            WeaponItem sword = new WeaponItem("Sword", 10);
            DefensiveItem shield = new DefensiveItem("Shield", 5);
            UtilityItem potion = new UtilityItem("Health Potion", "Restores 20 HP");

            // Add items to the character's inventory
            playerCharacter.getInventory().addInventoryItem(sword);
            playerCharacter.getInventory().addInventoryItem(shield);
            playerCharacter.getInventory().addInventoryItem(potion);

            // List items in the inventory
            playerCharacter.getInventory().listInventoryItems();

            // Equip items
            playerCharacter.equipItem(sword);
            playerCharacter.equipItem(shield);
            playerCharacter.equipItem(potion);

            // Display currently equipped items
            playerCharacter.displayEquipment();

            // Unequip an item and display again
            playerCharacter.unequipItem("weapon");
            playerCharacter.displayEquipment();

            // List items in the inventory after unequipping
            playerCharacter.getInventory().listInventoryItems();

            System.out.println("\n--- Level " + currentLevel + " ---");

            System.out.println("#############################################################################");
            System.out.println("Location : " + gameWorld.getLocations());
            System.out.println("Day : " + gameWorld.getTimeOfDay());
            System.out.println("Weather : " + gameWorld.getWeatherConditions());
            System.out.println("#############################################################################");

            Enemy enemy = null;
            enemy = EnemyFactory.createEnemy(enemies.get(currentLevel-1), currentLevel);
            //subscribe characters to quest
            questManager.subscribe(playerCharacter);
            questManager.changeQuestStatus("Quest Started", playerCharacter);

            CommandInvoker invoker = new CommandInvoker();
            Controller controller = new Controller();

            // Map keys to commands
            controller.mapKeyToCommand("A", new AttackCommand(playerCharacter, enemy));
            controller.mapKeyToCommand("H", new HealCommand(playerCharacter));
            controller.mapKeyToCommand("D", new DefendCommand(playerCharacter));
            controller.mapKeyToCommand("M", new MoveCommand(playerCharacter, 1, 1)); //

            while (playerCharacter.getHealth() > 0 && enemy.getHealth() > 0) {
                System.out.println("Choose Attack (A)");
                System.out.println("Choose Heal (H)");
                System.out.println("Choose Defend (D)");
                System.out.println("Choose Move (M)");
                String choise = scan.nextLine();
                controller.handleInput(choise);

                playerCharacter.attack(enemy);

                //change the status
                playerCharacter.setState(new ActionState());

                //change action strategy
                actionManager.setActionStrategy(new AttackAction());

                if (enemy.getHealth() > 0) {
                    enemy.attack(playerCharacter);
                }
            }

            if (enemy.getHealth() <= 0) {
                playerCharacter.gainExperience(50); // Gain XP for defeating the enemy
                System.out.println(playerCharacter.getName() + " has defeated " + enemy.getName() + "!");
            } else {
                playerCharacter.setState(new DefendingState());
                questManager.changeQuestStatus("Quest Ended", playerCharacter);
                System.out.println(playerCharacter.getName() + " has been defeated by " + enemy.getName() + ". Game Over!");
                return; // Exit the game if the player is defeated
            }
            playerCharacter.setState(new IdleState());
        }
        questManager.changeQuestStatus("Quest Completed", playerCharacter);
        System.out.println(playerCharacter.getName() + " has completed all levels!");
        playerCharacter.setState(new IdleState());
        scan.close();
    }
}