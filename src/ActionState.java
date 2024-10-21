public class ActionState implements ICharacterState{
    @Override
    public void handleState(Character character) {
        System.out.println(character.getName() + " is ready to attack!");
    }
}
