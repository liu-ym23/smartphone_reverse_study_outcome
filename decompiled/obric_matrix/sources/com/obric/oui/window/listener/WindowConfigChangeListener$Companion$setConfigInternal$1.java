package com.obric.oui.window.listener;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/obric/oui/window/listener/WindowConfigChangeListener$Companion$setConfigInternal$1", "Landroidx/lifecycle/LifecycleObserver;", "Lkotlin/f0;", "onDestroy", "()V", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class WindowConfigChangeListener$Companion$setConfigInternal$1 implements LifecycleObserver {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ FragmentActivity f11623f;

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        int r2 = this.f11623f.hashCode();
        if (WindowConfigChangeListener.a().containsKey(Integer.valueOf(r2)) == false) goto L6;
        WindowConfigChangeListener.a().remove(Integer.valueOf(r2));
        return;
    }
}
