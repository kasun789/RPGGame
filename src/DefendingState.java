public class DefendingState implements ICharacterState{
    @Override
    public void handleState(Character character) {
        System.out.println(character.getName() + " is defending!");
    }
}
