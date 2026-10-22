package androidx.window.layout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Consumer;
import androidx.window.core.Version;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.i0.r;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001c2\u00020\u0001:\u0003\u001c\u001d\u001eB\u0011\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0003J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J&\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016J\u0016\u0010\u001b\u001a\u00020\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001f"}, d2 = {"Landroidx/window/layout/SidecarWindowBackend;", "Landroidx/window/layout/WindowBackend;", "windowExtension", "Landroidx/window/layout/ExtensionInterfaceCompat;", "(Landroidx/window/layout/ExtensionInterfaceCompat;)V", "getWindowExtension", "()Landroidx/window/layout/ExtensionInterfaceCompat;", "setWindowExtension", "windowLayoutChangeCallbacks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/window/layout/SidecarWindowBackend$WindowLayoutChangeCallbackWrapper;", "getWindowLayoutChangeCallbacks$annotations", "()V", "getWindowLayoutChangeCallbacks", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "callbackRemovedForActivity", "", "activity", "Landroid/app/Activity;", "isActivityRegistered", "", "registerLayoutChangeCallback", "executor", "Ljava/util/concurrent/Executor;", "callback", "Landroidx/core/util/Consumer;", "Landroidx/window/layout/WindowLayoutInfo;", "unregisterLayoutChangeCallback", "Companion", "ExtensionListenerImpl", "WindowLayoutChangeCallbackWrapper", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SidecarWindowBackend implements WindowBackend {
    public static final Companion Companion = null;
    public static final boolean DEBUG = false;
    private static final String TAG = "WindowServer";
    private static volatile SidecarWindowBackend globalInstance;
    private static final ReentrantLock globalLock = null;

    @GuardedBy("globalLock")
    @VisibleForTesting
    private ExtensionInterfaceCompat windowExtension;
    private final CopyOnWriteArrayList<WindowLayoutChangeCallbackWrapper> windowLayoutChangeCallbacks;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\rJ\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/window/layout/SidecarWindowBackend$Companion;", "", "()V", "DEBUG", "", "TAG", "", "globalInstance", "Landroidx/window/layout/SidecarWindowBackend;", "globalLock", "Ljava/util/concurrent/locks/ReentrantLock;", "getInstance", "context", "Landroid/content/Context;", "initAndVerifyExtension", "Landroidx/window/layout/ExtensionInterfaceCompat;", "isSidecarVersionSupported", "sidecarVersion", "Landroidx/window/core/Version;", "resetInstance", "", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g r1) {
            this();
        }

        public final SidecarWindowBackend getInstance(Context r2) {
            o.f(r2, "context");
            if (SidecarWindowBackend.access$getGlobalInstance$cp() != null) goto L13;
            ReentrantLock r1 = SidecarWindowBackend.access$getGlobalLock$cp();
            r1.lock();
        L10:
            th = move-exception;
            r1.unlock();
            throw th;
        L6:
            if (SidecarWindowBackend.access$getGlobalInstance$cp() != null) goto L8;
            SidecarWindowBackend.access$setGlobalInstance$cp(new SidecarWindowBackend(SidecarWindowBackend.Companion.initAndVerifyExtension(r2)));     // Catch: Throwable -> L10
        L8:
            f0 r3 = f0.f18324a;     // Catch: Throwable -> L10
            r1.unlock();
        L13:
            SidecarWindowBackend r4 = SidecarWindowBackend.access$getGlobalInstance$cp();
            o.c(r4);
            return r4;
        }

        public final ExtensionInterfaceCompat initAndVerifyExtension(Context r3) {
            o.f(r3, "context");
            if (isSidecarVersionSupported(SidecarCompat.Companion.getSidecarVersion()) == false) goto L13;
            SidecarCompat r2 = new SidecarCompat(r3);     // Catch: Throwable -> L10
            if (r2.validateExtensionInterface() == true) goto L9;
            return null;
        L9:
            return r2;
        L13:
            return null;
        L15:
            return null;
        }

        @VisibleForTesting
        public final boolean isSidecarVersionSupported(Version r2) {
            if (r2 != null) goto L6;
            return false;
        L6:
            if (r2.compareTo2(Version.Companion.getVERSION_0_1()) < 0) goto L9;
            return true;
        L9:
            return false;
        }

        @VisibleForTesting
        public final void resetInstance() {
            SidecarWindowBackend.access$setGlobalInstance$cp(null);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0081\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0017¨\u0006\t"}, d2 = {"Landroidx/window/layout/SidecarWindowBackend$ExtensionListenerImpl;", "Landroidx/window/layout/ExtensionInterfaceCompat$ExtensionCallbackInterface;", "(Landroidx/window/layout/SidecarWindowBackend;)V", "onWindowLayoutChanged", "", "activity", "Landroid/app/Activity;", "newLayout", "Landroidx/window/layout/WindowLayoutInfo;", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @VisibleForTesting
    public final class ExtensionListenerImpl implements ExtensionInterfaceCompat.ExtensionCallbackInterface {
        final /* synthetic */ SidecarWindowBackend this$0;

        public ExtensionListenerImpl(SidecarWindowBackend r2) {
            o.f(r2, "this$0");
            this.this$0 = r2;
        }

        @Override // androidx.window.layout.ExtensionInterfaceCompat.ExtensionCallbackInterface
        @SuppressLint({"SyntheticAccessor"})
        public void onWindowLayoutChanged(Activity r3, WindowLayoutInfo r4) {
            o.f(r3, "activity");
            o.f(r4, "newLayout");
            Iterator<WindowLayoutChangeCallbackWrapper> r2 = this.this$0.getWindowLayoutChangeCallbacks().iterator();
        L4:
            if (r2.hasNext() == false) goto L9;
            WindowLayoutChangeCallbackWrapper r0 = r2.next();
            if (o.a(r0.getActivity(), r3) == false) goto L4;
            r0.accept(r4);
            goto L4
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Landroidx/window/layout/SidecarWindowBackend$WindowLayoutChangeCallbackWrapper;", "", "activity", "Landroid/app/Activity;", "executor", "Ljava/util/concurrent/Executor;", "callback", "Landroidx/core/util/Consumer;", "Landroidx/window/layout/WindowLayoutInfo;", "(Landroid/app/Activity;Ljava/util/concurrent/Executor;Landroidx/core/util/Consumer;)V", "getActivity", "()Landroid/app/Activity;", "getCallback", "()Landroidx/core/util/Consumer;", "lastInfo", "getLastInfo", "()Landroidx/window/layout/WindowLayoutInfo;", "setLastInfo", "(Landroidx/window/layout/WindowLayoutInfo;)V", "accept", "", "newLayoutInfo", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class WindowLayoutChangeCallbackWrapper {
        private final Activity activity;
        private final Consumer<WindowLayoutInfo> callback;
        private final Executor executor;
        private WindowLayoutInfo lastInfo;

        public WindowLayoutChangeCallbackWrapper(Activity r2, Executor r3, Consumer<WindowLayoutInfo> r4) {
            o.f(r2, "activity");
            o.f(r3, "executor");
            o.f(r4, "callback");
            this.activity = r2;
            this.executor = r3;
            this.callback = r4;
        }

        public static /* synthetic */ void a(WindowLayoutChangeCallbackWrapper r0, WindowLayoutInfo r1) {
            m50accept$lambda0(r0, r1);
        }

        /* JADX INFO: renamed from: accept$lambda-0, reason: not valid java name */
        private static final void m50accept$lambda0(WindowLayoutChangeCallbackWrapper r1, WindowLayoutInfo r2) {
            o.f(r1, "this$0");
            o.f(r2, "$newLayoutInfo");
            r1.callback.accept(r2);
        }

        public final void accept(final WindowLayoutInfo r3) {
            o.f(r3, "newLayoutInfo");
            this.lastInfo = r3;
            this.executor.execute(new b(this, r3));
        }

        public final Activity getActivity() {
            return this.activity;
        }

        public final Consumer<WindowLayoutInfo> getCallback() {
            return this.callback;
        }

        public final WindowLayoutInfo getLastInfo() {
            return this.lastInfo;
        }

        public final void setLastInfo(WindowLayoutInfo r1) {
            this.lastInfo = r1;
        }
    }

    static {
        Companion = new Companion(null);
        globalLock = new ReentrantLock();
    }

    @VisibleForTesting
    public SidecarWindowBackend(ExtensionInterfaceCompat r2) {
        this.windowExtension = r2;
        this.windowLayoutChangeCallbacks = new CopyOnWriteArrayList();
        ExtensionInterfaceCompat r3 = this.windowExtension;
        if (r3 == null) goto L7;
        r3.setExtensionCallback(new ExtensionListenerImpl(this));
        return;
    }

    public static final /* synthetic */ SidecarWindowBackend access$getGlobalInstance$cp() {
        return globalInstance;
    }

    public static final /* synthetic */ ReentrantLock access$getGlobalLock$cp() {
        return globalLock;
    }

    public static final /* synthetic */ void access$setGlobalInstance$cp(SidecarWindowBackend r0) {
        globalInstance = r0;
    }

    @GuardedBy("sLock")
    private final void callbackRemovedForActivity(Activity r4) {
        CopyOnWriteArrayList<WindowLayoutChangeCallbackWrapper> r0 = this.windowLayoutChangeCallbacks;
        boolean r2 = false;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L13;
        if (o.a(((WindowLayoutChangeCallbackWrapper) r1.next()).getActivity(), r4) == false) goto L9;
        r2 = true;
    L13:
        if (r2 == false) goto L15;
        return;
    L15:
        ExtensionInterfaceCompat r3 = this.windowExtension;
        if (r3 == null) goto L23;
        r3.onWindowLayoutChangeListenerRemoved(r4);
        return;
    L23:
        return;
    L5:
        if (r0.isEmpty() == false) goto L7;
        goto L7
    }

    @VisibleForTesting
    public static /* synthetic */ void getWindowLayoutChangeCallbacks$annotations() {
    }

    private final boolean isActivityRegistered(Activity r3) {
        CopyOnWriteArrayList<WindowLayoutChangeCallbackWrapper> r2 = this.windowLayoutChangeCallbacks;
        if ((r2 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r4 = r2.iterator();
    L9:
        if (r4.hasNext() == false) goto L18;
        if (o.a(((WindowLayoutChangeCallbackWrapper) r4.next()).getActivity(), r3) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r2.isEmpty() == false) goto L7;
        return false;
    }

    public final ExtensionInterfaceCompat getWindowExtension() {
        return this.windowExtension;
    }

    public final CopyOnWriteArrayList<WindowLayoutChangeCallbackWrapper> getWindowLayoutChangeCallbacks() {
        return this.windowLayoutChangeCallbacks;
    }

    @Override // androidx.window.layout.WindowBackend
    public void registerLayoutChangeCallback(Activity r5, Executor r6, Consumer<WindowLayoutInfo> r7) {
        o.f(r5, "activity");
        o.f(r6, "executor");
        o.f(r7, "callback");
        ReentrantLock r0 = globalLock;
        r0.lock();
        ExtensionInterfaceCompat r1 = getWindowExtension();     // Catch: Throwable -> L27
        if (r1 != null) goto L8;
        r7.accept(new WindowLayoutInfo(r.g()));     // Catch: Throwable -> L27
        r0.unlock();
        return;
    L8:
        boolean r2 = isActivityRegistered(r5);     // Catch: Throwable -> L27
        WindowLayoutChangeCallbackWrapper r3 = new WindowLayoutChangeCallbackWrapper(r5, r6, r7);     // Catch: Throwable -> L27
        getWindowLayoutChangeCallbacks().add(r3);     // Catch: Throwable -> L27
        if (r2 == true) goto L11;
        r1.onWindowLayoutChangeListenerAdded(r5);     // Catch: Throwable -> L27
    L24:
        f0 r4 = f0.f18324a;     // Catch: Throwable -> L27
        r0.unlock();
        return;
    L11:
        Iterator<T> r8 = getWindowLayoutChangeCallbacks().iterator();     // Catch: Throwable -> L27
    L12:
        WindowLayoutInfo r9 = null;
        if (r8.hasNext() == false) goto L17;
        Object r10 = r8.next();     // Catch: Throwable -> L27
        if (o.a(r5, ((WindowLayoutChangeCallbackWrapper) r10).getActivity()) == false) goto L12;
    L18:
        WindowLayoutChangeCallbackWrapper r11 = (WindowLayoutChangeCallbackWrapper) r10;     // Catch: Throwable -> L27
        if (r11 == null) goto L22;
        r9 = r11.getLastInfo();     // Catch: Throwable -> L27
    L22:
        if (r9 == null) goto L24;
        r3.accept(r9);     // Catch: Throwable -> L27
        goto L24
    L17:
        r10 = null;
    L27:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    public final void setWindowExtension(ExtensionInterfaceCompat r1) {
        this.windowExtension = r1;
    }

    @Override // androidx.window.layout.WindowBackend
    public void unregisterLayoutChangeCallback(Consumer<WindowLayoutInfo> r6) {
        o.f(r6, "callback");
        ReentrantLock r0 = globalLock;
        monitor-enter(r0);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (getWindowExtension() != null) goto L8;
        monitor-exit(r0);
        return;
    L8:
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L21
        Iterator<WindowLayoutChangeCallbackWrapper> r2 = getWindowLayoutChangeCallbacks().iterator();     // Catch: Throwable -> L21
    L10:
        if (r2.hasNext() == false) goto L14;
        WindowLayoutChangeCallbackWrapper r3 = r2.next();     // Catch: Throwable -> L21
        if (r3.getCallback() != r6) goto L10;
        o.e(r3, "callbackWrapper");     // Catch: Throwable -> L21
        r1.add(r3);     // Catch: Throwable -> L21
        goto L10
    L14:
        getWindowLayoutChangeCallbacks().removeAll(r1);     // Catch: Throwable -> L21
        Iterator r7 = r1.iterator();     // Catch: Throwable -> L21
    L16:
        if (r7.hasNext() == false) goto L18;
        callbackRemovedForActivity(((WindowLayoutChangeCallbackWrapper) r7.next()).getActivity());     // Catch: Throwable -> L21
        goto L16
    L18:
        f0 r5 = f0.f18324a;     // Catch: Throwable -> L21
        monitor-exit(r0);
    }
}
