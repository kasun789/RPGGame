public class DefendCommand implements ICommand {
    private Character defender;

    public DefendCommand(Character defender) {
        this.defender = defender;
    }

    @Override
    public void execute() {
        defender.defend();
    }
}