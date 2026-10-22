package com.bumptech.glide.manager;

import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bumptech.glide.util.Util;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
final class LifecycleLifecycle implements Lifecycle, LifecycleObserver {
    private final androidx.lifecycle.Lifecycle lifecycle;
    private final Set<LifecycleListener> lifecycleListeners;

    LifecycleLifecycle(androidx.lifecycle.Lifecycle r2) {
        this.lifecycleListeners = new HashSet();
        this.lifecycle = r2;
        r2.addObserver(this);
    }

    @OnLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_START)
    public void onStart(LifecycleOwner r1) {
        Iterator r0 = Util.getSnapshot(this.lifecycleListeners).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((LifecycleListener) r0.next()).onStart();
        goto L4
    }

    @OnLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_STOP)
    public void onStop(LifecycleOwner r1) {
        Iterator r0 = Util.getSnapshot(this.lifecycleListeners).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((LifecycleListener) r0.next()).onStop();
        goto L4
    }

    @OnLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_DESTROY)
    public void onDestroy(LifecycleOwner r3) {
        Iterator r0 = Util.getSnapshot(this.lifecycleListeners).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((LifecycleListener) r0.next()).onDestroy();
        goto L4
    L6:
        r3.getLifecycle().removeObserver(this);
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    public void addListener(LifecycleListener r3) {
        this.lifecycleListeners.add(r3);
        if (this.lifecycle.getCurrentState() != androidx.lifecycle.Lifecycle.State.DESTROYED) goto L6;
        r3.onDestroy();
        return;
    L6:
        if (this.lifecycle.getCurrentState().isAtLeast(androidx.lifecycle.Lifecycle.State.STARTED) == false) goto L8;
        r3.onStart();
        return;
    L8:
        r3.onStop();
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    public void removeListener(LifecycleListener r1) {
        this.lifecycleListeners.remove(r1);
    }
}
