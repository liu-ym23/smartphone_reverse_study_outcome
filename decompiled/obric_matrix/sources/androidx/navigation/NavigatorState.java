package androidx.navigation;

import android.os.Bundle;
import androidx.annotation.CallSuper;
import androidx.annotation.RestrictTo;
import h.a.e3.g;
import h.a.e3.n;
import h.a.e3.v;
import h.a.e3.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.i0.r;
import kotlin.i0.t0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH&J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0006H\u0016J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u0006H\u0017J\u0018\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0010H\u0016J\u0018\u0010#\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0010H\u0016J\u0010\u0010$\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u0006H\u0016J\u0010\u0010%\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u0006H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\f¨\u0006&"}, d2 = {"Landroidx/navigation/NavigatorState;", "", "()V", "_backStack", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Landroidx/navigation/NavBackStackEntry;", "_transitionsInProgress", "", "backStack", "Lkotlinx/coroutines/flow/StateFlow;", "getBackStack", "()Lkotlinx/coroutines/flow/StateFlow;", "backStackLock", "Ljava/util/concurrent/locks/ReentrantLock;", "isNavigating", "", "()Z", "setNavigating", "(Z)V", "transitionsInProgress", "getTransitionsInProgress", "createBackStackEntry", "destination", "Landroidx/navigation/NavDestination;", "arguments", "Landroid/os/Bundle;", "markTransitionComplete", "", "entry", "onLaunchSingleTop", "backStackEntry", "pop", "popUpTo", "saveState", "popWithTransition", "push", "pushWithTransition", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class NavigatorState {
    private final n<List<NavBackStackEntry>> _backStack;
    private final n<Set<NavBackStackEntry>> _transitionsInProgress;
    private final v<List<NavBackStackEntry>> backStack;
    private final ReentrantLock backStackLock;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    private boolean isNavigating;
    private final v<Set<NavBackStackEntry>> transitionsInProgress;

    public NavigatorState() {
        this.backStackLock = new ReentrantLock(true);
        n<List<NavBackStackEntry>> r0 = x.a(r.g());
        this._backStack = r0;
        n<Set<NavBackStackEntry>> r1 = x.a(t0.b());
        this._transitionsInProgress = r1;
        this.backStack = g.b(r0);
        this.transitionsInProgress = g.b(r1);
    }

    public abstract NavBackStackEntry createBackStackEntry(NavDestination r1, Bundle r2);

    public final v<List<NavBackStackEntry>> getBackStack() {
        return this.backStack;
    }

    public final v<Set<NavBackStackEntry>> getTransitionsInProgress() {
        return this.transitionsInProgress;
    }

    public final boolean isNavigating() {
        return this.isNavigating;
    }

    public void markTransitionComplete(NavBackStackEntry r2) {
        o.f(r2, "entry");
        n<Set<NavBackStackEntry>> r1 = this._transitionsInProgress;
        r1.setValue(t0.g(r1.getValue(), r2));
    }

    @CallSuper
    public void onLaunchSingleTop(NavBackStackEntry r3) {
        o.f(r3, "backStackEntry");
        n<List<NavBackStackEntry>> r0 = this._backStack;
        r0.setValue(r.l0(r.h0(r0.getValue(), r.b0(this._backStack.getValue())), r3));
    }

    public void pop(NavBackStackEntry r5, boolean r6) {
        o.f(r5, "popUpTo");
        ReentrantLock r7 = this.backStackLock;
        r7.lock();
        n<List<NavBackStackEntry>> r4 = this._backStack;     // Catch: Throwable -> L13
        List<NavBackStackEntry> r0 = r4.getValue();     // Catch: Throwable -> L13
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L13
        Iterator<T> r2 = r0.iterator();     // Catch: Throwable -> L13
    L5:
        if (r2.hasNext() == false) goto L10;
        Object r3 = r2.next();     // Catch: Throwable -> L13
        if ((!o.a((NavBackStackEntry) r3, r5)) == false) goto L10;
        r1.add(r3);     // Catch: Throwable -> L13
    L10:
        r4.setValue(r1);     // Catch: Throwable -> L13
        f0 r8 = f0.f18324a;     // Catch: Throwable -> L13
        r7.unlock();
        return;
    L13:
        th = move-exception;
        r7.unlock();
        throw th;
    }

    public void popWithTransition(NavBackStackEntry r5, boolean r6) {
        o.f(r5, "popUpTo");
        n<Set<NavBackStackEntry>> r0 = this._transitionsInProgress;
        r0.setValue(t0.i(r0.getValue(), r5));
        List<NavBackStackEntry> r1 = this.backStack.getValue();
        ListIterator<NavBackStackEntry> r2 = r1.listIterator(r1.size());
    L4:
        if (r2.hasPrevious() == false) goto L13;
        NavBackStackEntry r3 = r2.previous();
        NavBackStackEntry r4 = r3;
        if (o.a(r4, r5) == false) goto L8;
    L10:
        boolean r7 = false;
    L11:
        if (r7 == false) goto L4;
    L14:
        NavBackStackEntry r8 = r3;
        if (r8 == null) goto L17;
        n<Set<NavBackStackEntry>> r9 = this._transitionsInProgress;
        r9.setValue(t0.i(r9.getValue(), r8));
    L17:
        pop(r5, r6);
        return;
    L8:
        if (this.backStack.getValue().lastIndexOf(r4) >= this.backStack.getValue().lastIndexOf(r5)) goto L10;
        r7 = true;
        goto L11
    L13:
        r3 = null;
        goto L14
    }

    public void push(NavBackStackEntry r3) {
        o.f(r3, "backStackEntry");
        ReentrantLock r0 = this.backStackLock;
        r0.lock();
        n<List<NavBackStackEntry>> r2 = this._backStack;     // Catch: Throwable -> L6
        r2.setValue(r.l0(r2.getValue(), r3));     // Catch: Throwable -> L6
        f0 r4 = f0.f18324a;     // Catch: Throwable -> L6
        r0.unlock();
        return;
    L6:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    public void pushWithTransition(NavBackStackEntry r4) {
        o.f(r4, "backStackEntry");
        NavBackStackEntry r0 = (NavBackStackEntry) r.d0(this.backStack.getValue());
        if (r0 == null) goto L5;
        n<Set<NavBackStackEntry>> r1 = this._transitionsInProgress;
        r1.setValue(t0.i(r1.getValue(), r0));
    L5:
        n<Set<NavBackStackEntry>> r2 = this._transitionsInProgress;
        r2.setValue(t0.i(r2.getValue(), r4));
        push(r4);
    }

    public final void setNavigating(boolean r1) {
        this.isNavigating = r1;
    }
}
