package com.bytedance.blockframework.interaction;

import kotlin.Metadata;

/* JADX INFO: compiled from: EventManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J$\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH&J\u0016\u0010\u000f\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fH&¨\u0006\u0010"}, d2 = {"Lcom/bytedance/blockframework/interaction/IEventManager;", "", "notifyEvent", "", "event", "Lcom/bytedance/blockframework/interaction/Event;", "block", "Lcom/bytedance/blockframework/interaction/StateAndEventModel;", "notifyEventForResult", "registerObserver", "", "observer", "Lcom/bytedance/blockframework/interaction/IObserver;", "eventClass", "Ljava/lang/Class;", "unregisterObserver", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IEventManager {
    boolean notifyEvent(Event r1);

    boolean notifyEvent(StateAndEventModel r1, Event r2);

    boolean notifyEventForResult(Event r1);

    void registerObserver(IObserver<Event> r1, Class<Event> r2);

    void unregisterObserver(IObserver<Event> r1);
}
