import java.util.Random;

public abstract class Enemy {
    private String name;
    private int health;
    private int damage;
    private int mana;
    private int strength;
    private int agility;
    private String rank;

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Enemy() {

    }
    public Enemy(String name, int level, int mana, int strength, int agility, String rank) {
        // Initialize enemy HP based on level
        System.out.println(name);
        this.name = name; // Simple naming based on level
        this.health = level * 15; // Example health based on level
        this.damage = level * 5; // Example scaling logic
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void takeDamage(int damage) {
        health -= damage;
        System.out.println(name + " takes " + damage + " damage! Remaining Health: " + health);

        if (health <= 0) {
            System.out.println(name + " has been defeated!");
        }

    }

    public void attack(Character character) {
        System.out.println(name + " attacks " + character.getName() + " for " + damage + " damage!");
        Random random = new Random();
        int num = random.nextInt(21);
        character.takeDamage(num, damage);

        // Check if the enemy is defeated after attacking
        if (character.getHealth() <= 0) {
            System.out.println(character.getName() + " has been defeated by " + name);
        }
    }

    public void move() {
        System.out.println(name + " moves.");
    }
}
