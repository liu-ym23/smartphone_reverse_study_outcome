package com.bytedance.blockframework.interaction;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: EventManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/blockframework/interaction/Event;", "", "canIntercept", "", "(Z)V", "getCanIntercept", "()Z", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class Event {
    private final boolean canIntercept;

    public Event() {
        boolean r2 = false;
        this(r2, 1, null);
    }

    public Event(boolean r1) {
        this.canIntercept = r1;
    }

    public /* synthetic */ Event(boolean r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        this(r1);
    }

    public final boolean getCanIntercept() {
        return this.canIntercept;
    }
}
