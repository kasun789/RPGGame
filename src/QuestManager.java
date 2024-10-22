
import java.util.ArrayList;
import java.util.List;

public class QuestManager implements ISubject{
    private List<IObserver> observers = new ArrayList<>();
    private String questStatus = "Not Started";

    @Override
    public void subscribe(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(IObserver observer) {
        if (observers.contains(observer)) {
            observer.update(questStatus);
        }
    }

    public void changeQuestStatus(String newStatus, IObserver specificObserve) {
        questStatus = newStatus;
        notifyObservers(specificObserve);
    }
}
