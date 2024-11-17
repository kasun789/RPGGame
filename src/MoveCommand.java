public class MoveCommand implements ICommand {
    private Character character;
    private int x;
    private int y;

    public MoveCommand(Character character, int x, int y) {
        this.character = character;
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
        character.moveTo(x, y);
    }
}