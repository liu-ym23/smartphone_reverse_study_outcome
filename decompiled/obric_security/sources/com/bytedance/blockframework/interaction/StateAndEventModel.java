package com.bytedance.blockframework.interaction;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StateAndEventModel.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\fJ\b\u0010\u0016\u001a\u00020\u0014H&J\b\u0010\u0017\u001a\u00020\u0014H&J%\u0010\u0018\u001a\u0004\u0018\u0001H\u0019\"\b\b\u0000\u0010\u0019*\u00020\u00112\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00190\u001b¢\u0006\u0002\u0010\u001cJ \u0010\u001d\u001a\u00020\u0014\"\b\b\u0000\u0010\u0019*\u00020\u00112\u000e\u0010\u001e\u001a\n\u0012\u0006\b\u0000\u0012\u0002H\u00190\u0010J&\u0010\u001f\u001a\u00020\u00142\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\u0010!\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u001bH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001f\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u00100\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\""}, d2 = {"Lcom/bytedance/blockframework/interaction/StateAndEventModel;", "", "()V", "blockBlockMessageCenter", "Lcom/bytedance/blockframework/interaction/IBlockMessageCenter;", "getBlockBlockMessageCenter", "()Lcom/bytedance/blockframework/interaction/IBlockMessageCenter;", "setBlockBlockMessageCenter", "(Lcom/bytedance/blockframework/interaction/IBlockMessageCenter;)V", "observers", "", "Lcom/bytedance/blockframework/interaction/IObserver;", "Lcom/bytedance/blockframework/interaction/Event;", "getObservers", "()Ljava/util/List;", "providers", "Lcom/bytedance/blockframework/interaction/IStatusProvider;", "Lcom/bytedance/blockframework/interaction/State;", "getProviders", "notifyEvent", "", "event", "onPrepared", "onUnRegister", "queryStatus", ExifInterface.GPS_DIRECTION_TRUE, "stateClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/bytedance/blockframework/interaction/State;", "shareState", "provider", "subscribe", "observer", "eventClass", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class StateAndEventModel {
    public IBlockMessageCenter blockBlockMessageCenter;
    private final List<IObserver<Event>> observers;
    private final List<IStatusProvider<? extends State>> providers;

    public abstract void onPrepared();

    public abstract void onUnRegister();

    public StateAndEventModel() {
        this.providers = new ArrayList();
        this.observers = new ArrayList();
    }

    public IBlockMessageCenter getBlockBlockMessageCenter() {
        IBlockMessageCenter r0 = this.blockBlockMessageCenter;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("blockBlockMessageCenter");
        return null;
    }

    public void setBlockBlockMessageCenter(IBlockMessageCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.blockBlockMessageCenter = r2;
    }

    public final List<IStatusProvider<? extends State>> getProviders() {
        return this.providers;
    }

    public final <T extends State> void shareState(IStatusProvider<? super T> r3) {
        Intrinsics.checkNotNullParameter(r3, "provider");
        if (this.providers.contains(r3) == true) goto L7;
        this.providers.add(r3);
        getBlockBlockMessageCenter().registerStateProvider(r3);
        return;
    L7:
        throw new RuntimeException("provider " + r3 + " already exists");
    }

    public final <T extends State> T queryStatus(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "stateClass");
        return (T) getBlockBlockMessageCenter().queryState(r2);
    }

    public final List<IObserver<Event>> getObservers() {
        return this.observers;
    }

    public void subscribe(IObserver<Event> r2, Class<? extends Event> r3) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        Intrinsics.checkNotNullParameter(r3, "eventClass");
        if (this.observers.contains(r2) == true) goto L5;
        this.observers.add(r2);
    L5:
        getBlockBlockMessageCenter().subscribeEvent(r2, r3);
    }

    public final void notifyEvent(Event r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        getBlockBlockMessageCenter().notifyEvent(this, r2);
    }
}
