public class NPC implements IObserver{
    private String name;
    private String role;
    private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public void update(String questStatus) {
        System.out.println(name + " notified of quest status change: " + questStatus);
    }
}
