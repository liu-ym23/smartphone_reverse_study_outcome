package com.obric.oui.window.listener;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/obric/oui/window/listener/WindowConfigChangeListener$Companion$addListener$1", "Landroidx/lifecycle/LifecycleObserver;", "Lkotlin/f0;", "onDestroy", "()V", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class WindowConfigChangeListener$Companion$addListener$1 implements LifecycleObserver {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ int f11620f;

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        if (WindowConfigChangeListener.b().containsKey(Integer.valueOf(this.f11620f)) == false) goto L6;
        WindowConfigChangeListener.b().remove(Integer.valueOf(this.f11620f));
        return;
    }
}
