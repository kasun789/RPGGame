public interface ISubject {
    void subscribe(IObserver observer);
    void unsubscribe(IObserver observer);
    void notifyObservers(IObserver observer);
}
