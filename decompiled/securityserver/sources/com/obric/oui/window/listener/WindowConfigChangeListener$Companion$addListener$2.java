package com.obric.oui.window.listener;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class WindowConfigChangeListener$Companion$addListener$2 implements LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        ConcurrentLinkedQueue r2 = (ConcurrentLinkedQueue) WindowConfigChangeListener.b.get(0);
        if (r2 == null) goto L10;
        Iterator r3 = r2.iterator();
        Intrinsics.e(r3, "it.iterator()");
    L6:
        if (r3.hasNext() == false) goto L16;
        if (Intrinsics.a((Fragment) ((WeakReference) r3.next()).get(), null) == false) goto L6;
        r3.remove();
        goto L6
    L16:
        return;
    }
}
