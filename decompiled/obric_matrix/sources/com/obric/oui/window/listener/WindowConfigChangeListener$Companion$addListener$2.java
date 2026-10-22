package com.obric.oui.window.listener;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/obric/oui/window/listener/WindowConfigChangeListener$Companion$addListener$2", "Landroidx/lifecycle/LifecycleObserver;", "Lkotlin/f0;", "onDestroy", "()V", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class WindowConfigChangeListener$Companion$addListener$2 implements LifecycleObserver {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ int f11621f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ LifecycleOwner f11622g;

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        ConcurrentLinkedQueue r0 = (ConcurrentLinkedQueue) WindowConfigChangeListener.b().get(Integer.valueOf(this.f11621f));
        if (r0 == null) goto L10;
        Iterator r1 = r0.iterator();
        o.e(r1, "it.iterator()");
    L6:
        if (r1.hasNext() == false) goto L16;
        if (o.a((Fragment) ((WeakReference) r1.next()).get(), this.f11622g) == false) goto L6;
        r1.remove();
        goto L6
    L16:
        return;
    }
}
