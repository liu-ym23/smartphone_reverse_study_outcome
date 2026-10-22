package com.bytedance.blockframework.interaction;

import com.bytedance.blockframework.contract.AbstractBlock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EventManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\bH\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH\u0016J$\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\n2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u0016\u0010\u0019\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R2\u0010\u0005\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\n0\t0\u0006X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR2\u0010\r\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\n\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\t0\u0006X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/blockframework/interaction/EventManager;", "Lcom/bytedance/blockframework/interaction/IEventManager;", "()V", "TAG", "", "eventToObserverMap", "", "Ljava/lang/Class;", "Lcom/bytedance/blockframework/interaction/Event;", "", "Lcom/bytedance/blockframework/interaction/IObserver;", "getEventToObserverMap", "()Ljava/util/Map;", "observerToEventMap", "getObserverToEventMap", "notifyEvent", "", "event", "block", "Lcom/bytedance/blockframework/interaction/StateAndEventModel;", "notifyEventForResult", "registerObserver", "", "observer", "eventClass", "unregisterObserver", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class EventManager implements IEventManager {
    private final String TAG;
    private final Map<Class<Event>, List<IObserver<Event>>> eventToObserverMap;
    private final Map<IObserver<Event>, List<Class<Event>>> observerToEventMap;

    public EventManager() {
        this.TAG = "EventManager";
        this.eventToObserverMap = new LinkedHashMap();
        this.observerToEventMap = new LinkedHashMap();
    }

    protected final Map<Class<Event>, List<IObserver<Event>>> getEventToObserverMap() {
        return this.eventToObserverMap;
    }

    protected final Map<IObserver<Event>, List<Class<Event>>> getObserverToEventMap() {
        return this.observerToEventMap;
    }

    @Override // com.bytedance.blockframework.interaction.IEventManager
    public void registerObserver(IObserver<Event> r3, Class<Event> r4) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        Intrinsics.checkNotNullParameter(r4, "eventClass");
        ArrayList r0 = this.eventToObserverMap.get(r4);
        if (r0 != null) goto L6;
        r0 = new ArrayList();
        this.eventToObserverMap.put(r4, r0);
    L6:
        if (r0.contains(r3) == true) goto L8;
        r0.add(r3);
    L8:
        ArrayList r1 = this.observerToEventMap.get(r3);
        if (r1 != null) goto L12;
        r1 = new ArrayList();
        this.observerToEventMap.put(r3, r1);
    L12:
        if (r1.contains(r4) == true) goto L15;
        r1.add(r4);
        return;
    }

    @Override // com.bytedance.blockframework.interaction.IEventManager
    public void unregisterObserver(IObserver<Event> r4) {
        Intrinsics.checkNotNullParameter(r4, "observer");
        if (this.observerToEventMap.containsKey(r4) == true) goto L5;
        return;
    L5:
        List<Class<Event>> r0 = this.observerToEventMap.get(r4);
        if (r0 == null) goto L13;
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L13;
        Class r2 = (Class) r1.next();
        List<IObserver<Event>> r3 = this.eventToObserverMap.get(r2);
        if (r3 == null) goto L9;
        r3.remove(r4);
    L13:
        this.observerToEventMap.remove(r4);
    }

    @Override // com.bytedance.blockframework.interaction.IEventManager
    public boolean notifyEvent(Event r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        List<IObserver<Event>> r2 = this.eventToObserverMap.get(r3.getClass());
        if (r2 != null) goto L6;
        return false;
    L6:
        Iterator<IObserver<Event>> r4 = r2.iterator();
    L8:
        if (r4.hasNext() == false) goto L18;
        IObserver<Event> r0 = r4.next();
        if ((r0 instanceof AbstractBlock) == false) goto L15;
        if (((AbstractBlock) r0).isActive() == false) goto L8;
    L15:
        if (r0.onEvent(r3) == false) goto L8;
        if (r3.getCanIntercept() == false) goto L8;
        return true;
    L18:
        return true;
    }

    @Override // com.bytedance.blockframework.interaction.IEventManager
    public boolean notifyEvent(StateAndEventModel r2, Event r3) {
        Intrinsics.checkNotNullParameter(r2, "block");
        Intrinsics.checkNotNullParameter(r3, "event");
        return notifyEvent(r3);
    }

    @Override // com.bytedance.blockframework.interaction.IEventManager
    public boolean notifyEventForResult(Event r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        List<IObserver<Event>> r3 = this.eventToObserverMap.get(r4.getClass());
        if (r3 != null) goto L5;
        return false;
    L5:
        Iterator<IObserver<Event>> r5 = r3.iterator();
    L7:
        if (r5.hasNext() == false) goto L19;
        IObserver<Event> r1 = r5.next();
        if ((r1 instanceof AbstractBlock) == false) goto L14;
        if (((AbstractBlock) r1).isActive() == false) goto L7;
    L14:
        if (r1.onEvent(r4) == false) goto L7;
        if (r4.getCanIntercept() == false) goto L7;
        return true;
    L19:
        return false;
    }
}
