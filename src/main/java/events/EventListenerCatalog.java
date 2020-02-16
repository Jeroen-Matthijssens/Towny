package events;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;


public class EventListenerCatalog {

	protected final Map<EventType<?>, Set<EventListener<? extends Event>>> listeners = new ConcurrentHashMap<> ();

	public <T extends Event> Subscription register (EventType<T> type, EventListener<T> listener) {
		Set<EventListener<?>> ls = listeners.computeIfAbsent (type, t -> new ConcurrentSkipListSet<> ());
		ls.add (listener);
		return () -> ls.remove (listener);
	}

	public <T extends Event> void fire (EventType<T> type, T event) {
		Set<EventListener<Event>> ls = (Set) listeners.computeIfAbsent (type, t -> new ConcurrentSkipListSet<> ());
		ls.forEach (l -> {
			try { l.handle (event); }
			catch ( RuntimeException e) { throw e; }
			catch ( Exception e ) { throw new RuntimeException (e); }
		});
	}

}
