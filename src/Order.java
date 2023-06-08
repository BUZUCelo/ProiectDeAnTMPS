import java.util.*;

// Clasa subiectului observabil
class Order {
    private static Order instance;
    private List<Observer> observers = new ArrayList<>();
    private Map<String, String> orderStatusMap = new HashMap<>();
    private String orderCode;

    private Order() {
        Random random = new Random();
        orderCode = String.format("%04d", random.nextInt(10000));
    }

    public static Order getInstance() {
        if (instance == null) {
            instance = new Order();
        }
        return instance;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public String getStatus(String orderCode) {
        return orderStatusMap.get(orderCode);
    }

    public void setStatus(String orderCode, String status) {
        orderStatusMap.put(orderCode, status);
        notifyObservers("Starea comenzii cu codul " + orderCode + " a fost actualizată: " + status);
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}