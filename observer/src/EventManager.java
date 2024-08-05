import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

public class EventManager {
    Map<String, List<EventListener>> listeners = new HashMap<>();

    public EventManager(String... operations){
        for(String operation : operations)
            this.listeners.put(operation, new ArrayList<>());
    }

    public void subscribe(String eventType, EventListener eventListener){
        List<EventListener> list = listeners.get(eventType);
        list.add(eventListener);
    }

    public void unsubscribe(String eventType, EventListener eventListener){
        List<EventListener> eventListeners = listeners.get(eventType);
        eventListeners.remove(eventListener);
    }
}
