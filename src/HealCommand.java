public class HealCommand implements ICommand {
    private Character healer;

    public HealCommand(Character healer) {
        this.healer = healer;
    }

    @Override
    public void execute() {
        healer.heal();
    }
}
