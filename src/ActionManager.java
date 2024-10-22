public class ActionManager {
    private ActionStrategy actionStrategy;

    public ActionManager() {
        actionStrategy = new DefaultAction();
    }

    public void setActionStrategy(ActionStrategy actionStrategy) {
        actionStrategy = actionStrategy;
    }

    public void performAction() {
        actionStrategy.execute();
    }
}
