import java.util.HashMap;
import java.util.Map;

public class Controller {
    private Map<String, ICommand> commandMap = new HashMap<>();

    public void mapKeyToCommand(String key, ICommand command) {
        commandMap.put(key, command);
    }

    public void handleInput(String key) {
        ICommand command = commandMap.get(key);
        if (command != null) {
            command.execute();
        }
    }
}