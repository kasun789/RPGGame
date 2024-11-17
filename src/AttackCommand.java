public class AttackCommand implements ICommand {
    private Character attacker;
    private Enemy target;

    public AttackCommand(Character attacker, Enemy target) {
        this.attacker = attacker;
        this.target = target;
    }

    @Override
    public void execute() {
        attacker.attack(target);
    }
}