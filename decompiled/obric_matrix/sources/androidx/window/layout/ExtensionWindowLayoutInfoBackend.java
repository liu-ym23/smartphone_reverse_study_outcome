package androidx.window.layout;

import android.annotation.SuppressLint;
import android.app.Activity;
import androidx.annotation.GuardedBy;
import androidx.core.util.Consumer;
import androidx.window.extensions.layout.WindowLayoutComponent;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\u0016\u0010\u0014\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016R\u001c\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/window/layout/ExtensionWindowLayoutInfoBackend;", "Landroidx/window/layout/WindowBackend;", "component", "Landroidx/window/extensions/layout/WindowLayoutComponent;", "(Landroidx/window/extensions/layout/WindowLayoutComponent;)V", "activityToListeners", "", "Landroid/app/Activity;", "Landroidx/window/layout/ExtensionWindowLayoutInfoBackend$MulticastConsumer;", "extensionWindowBackendLock", "Ljava/util/concurrent/locks/ReentrantLock;", "listenerToActivity", "Landroidx/core/util/Consumer;", "Landroidx/window/layout/WindowLayoutInfo;", "registerLayoutChangeCallback", "", "activity", "executor", "Ljava/util/concurrent/Executor;", "callback", "unregisterLayoutChangeCallback", "MulticastConsumer", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ExtensionWindowLayoutInfoBackend implements WindowBackend {

    @GuardedBy("lock")
    private final Map<Activity, MulticastConsumer> activityToListeners;
    private final WindowLayoutComponent component;
    private final ReentrantLock extensionWindowBackendLock;

    @GuardedBy("lock")
    private final Map<Consumer<WindowLayoutInfo>, Activity> listenerToActivity;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0014\u0010\u0010\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\fJ\u0006\u0010\u0012\u001a\u00020\u0013J\u0014\u0010\u0014\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\f0\u000b8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/window/layout/ExtensionWindowLayoutInfoBackend$MulticastConsumer;", "Ljava/util/function/Consumer;", "Landroidx/window/extensions/layout/WindowLayoutInfo;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "lastKnownValue", "Landroidx/window/layout/WindowLayoutInfo;", "multicastConsumerLock", "Ljava/util/concurrent/locks/ReentrantLock;", "registeredListeners", "", "Landroidx/core/util/Consumer;", "accept", "", "value", "addListener", "listener", "isEmpty", "", "removeListener", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @SuppressLint({"NewApi"})
    private static final class MulticastConsumer implements java.util.function.Consumer<androidx.window.extensions.layout.WindowLayoutInfo> {
        private final Activity activity;

        @GuardedBy("lock")
        private WindowLayoutInfo lastKnownValue;
        private final ReentrantLock multicastConsumerLock;

        @GuardedBy("lock")
        private final Set<Consumer<WindowLayoutInfo>> registeredListeners;

        public MulticastConsumer(Activity r2) {
            o.f(r2, "activity");
            this.activity = r2;
            this.multicastConsumerLock = new ReentrantLock();
            this.registeredListeners = new LinkedHashSet();
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(androidx.window.extensions.layout.WindowLayoutInfo r4) {
            o.f(r4, "value");
            ReentrantLock r0 = this.multicastConsumerLock;
            r0.lock();
            this.lastKnownValue = ExtensionsWindowLayoutInfoAdapter.INSTANCE.translate$window_release(this.activity, r4);     // Catch: Throwable -> L10
            Iterator<T> r5 = this.registeredListeners.iterator();     // Catch: Throwable -> L10
        L5:
            if (r5.hasNext() == false) goto L7;
            ((Consumer) r5.next()).accept(this.lastKnownValue);     // Catch: Throwable -> L10
            goto L5
        L7:
            f0 r3 = f0.f18324a;     // Catch: Throwable -> L10
            r0.unlock();
            return;
        L10:
            th = move-exception;
            r0.unlock();
            throw th;
        }

        @Override // java.util.function.Consumer
        public /* bridge */ /* synthetic */ void accept(androidx.window.extensions.layout.WindowLayoutInfo r1) {
            accept2(r1);
        }

        public final void addListener(Consumer<WindowLayoutInfo> r3) {
            o.f(r3, "listener");
            ReentrantLock r0 = this.multicastConsumerLock;
            r0.lock();
            WindowLayoutInfo r1 = this.lastKnownValue;     // Catch: Throwable -> L10
            if (r1 == null) goto L7;
            r3.accept(r1);     // Catch: Throwable -> L10
        L7:
            this.registeredListeners.add(r3);     // Catch: Throwable -> L10
            r0.unlock();
            return;
        L10:
            th = move-exception;
            r0.unlock();
            throw th;
        }

        public final boolean isEmpty() {
            return this.registeredListeners.isEmpty();
        }

        public final void removeListener(Consumer<WindowLayoutInfo> r2) {
            o.f(r2, "listener");
            ReentrantLock r0 = this.multicastConsumerLock;
            r0.lock();
            this.registeredListeners.remove(r2);     // Catch: Throwable -> L6
            r0.unlock();
            return;
        L6:
            th = move-exception;
            r0.unlock();
            throw th;
        }
    }

    public ExtensionWindowLayoutInfoBackend(WindowLayoutComponent r2) {
        o.f(r2, "component");
        this.component = r2;
        this.extensionWindowBackendLock = new ReentrantLock();
        this.activityToListeners = new LinkedHashMap();
        this.listenerToActivity = new LinkedHashMap();
    }

    @Override // androidx.window.layout.WindowBackend
    public void registerLayoutChangeCallback(Activity r3, Executor r4, Consumer<WindowLayoutInfo> r5) {
        o.f(r3, "activity");
        o.f(r4, "executor");
        o.f(r5, "callback");
        ReentrantLock r6 = this.extensionWindowBackendLock;
        r6.lock();
        MulticastConsumer r0 = this.activityToListeners.get(r3);     // Catch: Throwable -> L12
        if (r0 != null) goto L6;
        f0 r1 = null;
    L7:
        if (r1 != null) goto L9;
        MulticastConsumer r2 = new MulticastConsumer(r3);     // Catch: Throwable -> L12
        this.activityToListeners.put(r3, r2);     // Catch: Throwable -> L12
        this.listenerToActivity.put(r5, r3);     // Catch: Throwable -> L12
        r2.addListener(r5);     // Catch: Throwable -> L12
        this.component.addWindowLayoutInfoListener(r3, r2);     // Catch: Throwable -> L12
    L9:
        f0 r7 = f0.f18324a;     // Catch: Throwable -> L12
        r6.unlock();
        return;
    L6:
        r0.addListener(r5);     // Catch: Throwable -> L12
        this.listenerToActivity.put(r5, r3);     // Catch: Throwable -> L12
        r1 = f0.f18324a;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        r6.unlock();
        throw th;
    }

    @Override // androidx.window.layout.WindowBackend
    public void unregisterLayoutChangeCallback(Consumer<WindowLayoutInfo> r4) {
        o.f(r4, "callback");
        ReentrantLock r0 = this.extensionWindowBackendLock;
        r0.lock();
        Activity r1 = this.listenerToActivity.get(r4);     // Catch: Throwable -> L17
        if (r1 != null) goto L7;
        r0.unlock();
        return;
    L7:
        MulticastConsumer r2 = this.activityToListeners.get(r1);     // Catch: Throwable -> L17
        if (r2 != null) goto L11;
        r0.unlock();
        return;
    L11:
        r2.removeListener(r4);     // Catch: Throwable -> L17
        if (r2.isEmpty() == false) goto L14;
        this.component.removeWindowLayoutInfoListener(r2);     // Catch: Throwable -> L17
    L14:
        f0 r3 = f0.f18324a;     // Catch: Throwable -> L17
        r0.unlock();
        return;
    L17:
        th = move-exception;
        r0.unlock();
        throw th;
    }
}
