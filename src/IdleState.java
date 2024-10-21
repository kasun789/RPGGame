public class IdleState implements ICharacterState{
    @Override
    public void handleState(Character character) {
        System.out.println(character.getName() + " is idle.");
    }
}
