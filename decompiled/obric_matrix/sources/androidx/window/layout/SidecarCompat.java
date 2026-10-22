package androidx.window.layout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.graphics.Rect;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import androidx.window.core.Version;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarProvider;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.i0.r;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u0000 !2\u00020\u0001:\u0005!\"#$%B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0007\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fH\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\fH\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\fH\u0016J\u0016\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\fJ\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\fH\u0002J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\fH\u0002J\b\u0010\u001f\u001a\u00020 H\u0017R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Landroidx/window/layout/SidecarCompat;", "Landroidx/window/layout/ExtensionInterfaceCompat;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "sidecar", "Landroidx/window/sidecar/SidecarInterface;", "sidecarAdapter", "Landroidx/window/layout/SidecarAdapter;", "(Landroidx/window/sidecar/SidecarInterface;Landroidx/window/layout/SidecarAdapter;)V", "componentCallbackMap", "", "Landroid/app/Activity;", "Landroid/content/ComponentCallbacks;", "extensionCallback", "Landroidx/window/layout/ExtensionInterfaceCompat$ExtensionCallbackInterface;", "getSidecar", "()Landroidx/window/sidecar/SidecarInterface;", "windowListenerRegisteredContexts", "Landroid/os/IBinder;", "getWindowLayoutInfo", "Landroidx/window/layout/WindowLayoutInfo;", "activity", "onWindowLayoutChangeListenerAdded", "", "onWindowLayoutChangeListenerRemoved", "register", "windowToken", "registerConfigurationChangeListener", "setExtensionCallback", "unregisterComponentCallback", "validateExtensionInterface", "", "Companion", "DistinctElementCallback", "DistinctSidecarElementCallback", "FirstAttachAdapter", "TranslatingCallback", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SidecarCompat implements ExtensionInterfaceCompat {
    public static final Companion Companion = null;
    private static final String TAG = "SidecarCompat";
    private final Map<Activity, ComponentCallbacks> componentCallbackMap;
    private ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallback;
    private final SidecarInterface sidecar;
    private final SidecarAdapter sidecarAdapter;
    private final Map<IBinder, Activity> windowListenerRegisteredContexts;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0002\b\rJ\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Landroidx/window/layout/SidecarCompat$Companion;", "", "()V", "TAG", "", "sidecarVersion", "Landroidx/window/core/Version;", "getSidecarVersion", "()Landroidx/window/core/Version;", "getActivityWindowToken", "Landroid/os/IBinder;", "activity", "Landroid/app/Activity;", "getActivityWindowToken$window_release", "getSidecarCompat", "Landroidx/window/sidecar/SidecarInterface;", "context", "Landroid/content/Context;", "getSidecarCompat$window_release", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g r1) {
            this();
        }

        public final IBinder getActivityWindowToken$window_release(Activity r1) {
            if (r1 == null) goto L13;
            Window r2 = r1.getWindow();
            if (r2 == null) goto L14;
            WindowManager.LayoutParams r3 = r2.getAttributes();
            if (r3 != null) goto L12;
            return null;
        L12:
            return r3.token;
        L14:
            return null;
        L13:
            return null;
        }

        public final SidecarInterface getSidecarCompat$window_release(Context r1) {
            o.f(r1, "context");
            return SidecarProvider.getSidecarImpl(r1.getApplicationContext());
        }

        public final Version getSidecarVersion() {
            String r0 = SidecarProvider.getApiVersion();     // Catch: Throwable -> L7
            if (TextUtils.isEmpty(r0) == true) goto L10;
            return Version.Companion.parse(r0);
        L10:
            return null;
        L11:
            return null;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0007H\u0016R\u001c\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/window/layout/SidecarCompat$DistinctElementCallback;", "Landroidx/window/layout/ExtensionInterfaceCompat$ExtensionCallbackInterface;", "callbackInterface", "(Landroidx/window/layout/ExtensionInterfaceCompat$ExtensionCallbackInterface;)V", "activityWindowLayoutInfo", "Ljava/util/WeakHashMap;", "Landroid/app/Activity;", "Landroidx/window/layout/WindowLayoutInfo;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "onWindowLayoutChanged", "", "activity", "newLayout", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class DistinctElementCallback implements ExtensionInterfaceCompat.ExtensionCallbackInterface {

        @GuardedBy("mLock")
        private final WeakHashMap<Activity, WindowLayoutInfo> activityWindowLayoutInfo;
        private final ExtensionInterfaceCompat.ExtensionCallbackInterface callbackInterface;
        private final ReentrantLock lock;

        public DistinctElementCallback(ExtensionInterfaceCompat.ExtensionCallbackInterface r2) {
            o.f(r2, "callbackInterface");
            this.callbackInterface = r2;
            this.lock = new ReentrantLock();
            this.activityWindowLayoutInfo = new WeakHashMap();
        }

        @Override // androidx.window.layout.ExtensionInterfaceCompat.ExtensionCallbackInterface
        public void onWindowLayoutChanged(Activity r3, WindowLayoutInfo r4) {
            o.f(r3, "activity");
            o.f(r4, "newLayout");
            ReentrantLock r0 = this.lock;
            r0.lock();
        L10:
            th = move-exception;
            r0.unlock();
            throw th;
        L4:
            if (o.a(r4, this.activityWindowLayoutInfo.get(r3)) == false) goto L7;
            r0.unlock();
            return;
        L7:
            WindowLayoutInfo r1 = this.activityWindowLayoutInfo.put(r3, r4);     // Catch: Throwable -> L10
            r0.unlock();
            this.callbackInterface.onWindowLayoutChanged(r3, r4);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/window/layout/SidecarCompat$DistinctSidecarElementCallback;", "Landroidx/window/sidecar/SidecarInterface$SidecarCallback;", "sidecarAdapter", "Landroidx/window/layout/SidecarAdapter;", "callbackInterface", "(Landroidx/window/layout/SidecarAdapter;Landroidx/window/sidecar/SidecarInterface$SidecarCallback;)V", "lastDeviceState", "Landroidx/window/sidecar/SidecarDeviceState;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "mActivityWindowLayoutInfo", "Ljava/util/WeakHashMap;", "Landroid/os/IBinder;", "Landroidx/window/sidecar/SidecarWindowLayoutInfo;", "onDeviceStateChanged", "", "newDeviceState", "onWindowLayoutChanged", "token", "newLayout", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class DistinctSidecarElementCallback implements SidecarInterface.SidecarCallback {
        private final SidecarInterface.SidecarCallback callbackInterface;

        @GuardedBy("lock")
        private SidecarDeviceState lastDeviceState;
        private final ReentrantLock lock;

        @GuardedBy("mLock")
        private final WeakHashMap<IBinder, SidecarWindowLayoutInfo> mActivityWindowLayoutInfo;
        private final SidecarAdapter sidecarAdapter;

        public DistinctSidecarElementCallback(SidecarAdapter r2, SidecarInterface.SidecarCallback r3) {
            o.f(r2, "sidecarAdapter");
            o.f(r3, "callbackInterface");
            this.sidecarAdapter = r2;
            this.callbackInterface = r3;
            this.lock = new ReentrantLock();
            this.mActivityWindowLayoutInfo = new WeakHashMap();
        }

        public void onDeviceStateChanged(SidecarDeviceState r4) {
            o.f(r4, "newDeviceState");
            ReentrantLock r0 = this.lock;
            r0.lock();
        L10:
            th = move-exception;
            r0.unlock();
            throw th;
        L4:
            if (this.sidecarAdapter.isEqualSidecarDeviceState(this.lastDeviceState, r4) == false) goto L7;
            r0.unlock();
            return;
        L7:
            this.lastDeviceState = r4;     // Catch: Throwable -> L10
            this.callbackInterface.onDeviceStateChanged(r4);     // Catch: Throwable -> L10
            f0 r3 = f0.f18324a;     // Catch: Throwable -> L10
            r0.unlock();
        }

        public void onWindowLayoutChanged(IBinder r4, SidecarWindowLayoutInfo r5) {
            o.f(r4, "token");
            o.f(r5, "newLayout");
            ReentrantLock r0 = this.lock;
            monitor-enter(r0);
            SidecarWindowLayoutInfo r1 = this.mActivityWindowLayoutInfo.get(r4);     // Catch: Throwable -> L12
            if (this.sidecarAdapter.isEqualSidecarWindowLayoutInfo(r1, r5) == false) goto L8;
            monitor-exit(r0);
            return;
        L8:
            SidecarWindowLayoutInfo r2 = this.mActivityWindowLayoutInfo.put(r4, r5);     // Catch: Throwable -> L12
            monitor-exit(r0);
            this.callbackInterface.onWindowLayoutChanged(r4, r5);
            return;
        L12:
            th = move-exception;
            throw th;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00050\u00050\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/window/layout/SidecarCompat$FirstAttachAdapter;", "Landroid/view/View$OnAttachStateChangeListener;", "sidecarCompat", "Landroidx/window/layout/SidecarCompat;", "activity", "Landroid/app/Activity;", "(Landroidx/window/layout/SidecarCompat;Landroid/app/Activity;)V", "activityWeakReference", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "onViewAttachedToWindow", "", "view", "Landroid/view/View;", "onViewDetachedFromWindow", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class FirstAttachAdapter implements View.OnAttachStateChangeListener {
        private final WeakReference<Activity> activityWeakReference;
        private final SidecarCompat sidecarCompat;

        public FirstAttachAdapter(SidecarCompat r2, Activity r3) {
            o.f(r2, "sidecarCompat");
            o.f(r3, "activity");
            this.sidecarCompat = r2;
            this.activityWeakReference = new WeakReference(r3);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r2) {
            o.f(r2, "view");
            r2.removeOnAttachStateChangeListener(this);
            Activity r3 = this.activityWeakReference.get();
            IBinder r0 = SidecarCompat.Companion.getActivityWindowToken$window_release(r3);
            if (r3 != null) goto L5;
            return;
        L5:
            if (r0 != null) goto L7;
            return;
        L7:
            this.sidecarCompat.register(r0, r3);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r1) {
            o.f(r1, "view");
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0017¨\u0006\f"}, d2 = {"Landroidx/window/layout/SidecarCompat$TranslatingCallback;", "Landroidx/window/sidecar/SidecarInterface$SidecarCallback;", "(Landroidx/window/layout/SidecarCompat;)V", "onDeviceStateChanged", "", "newDeviceState", "Landroidx/window/sidecar/SidecarDeviceState;", "onWindowLayoutChanged", "windowToken", "Landroid/os/IBinder;", "newLayout", "Landroidx/window/sidecar/SidecarWindowLayoutInfo;", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class TranslatingCallback implements SidecarInterface.SidecarCallback {
        final /* synthetic */ SidecarCompat this$0;

        public TranslatingCallback(SidecarCompat r2) {
            o.f(r2, "this$0");
            this.this$0 = r2;
        }

        @SuppressLint({"SyntheticAccessor"})
        public void onDeviceStateChanged(SidecarDeviceState r6) {
            o.f(r6, "newDeviceState");
            Collection r0 = SidecarCompat.access$getWindowListenerRegisteredContexts$p(this.this$0).values();
            SidecarCompat r5 = this.this$0;
            Iterator r1 = r0.iterator();
        L4:
            if (r1.hasNext() == false) goto L16;
            Activity r2 = (Activity) r1.next();
            IBinder r3 = SidecarCompat.Companion.getActivityWindowToken$window_release(r2);
            SidecarWindowLayoutInfo r4 = null;
            if (r3 == null) goto L12;
            SidecarInterface r7 = r5.getSidecar();
            if (r7 == null) goto L12;
            r4 = r7.getWindowLayoutInfo(r3);
        L12:
            ExtensionInterfaceCompat.ExtensionCallbackInterface r8 = SidecarCompat.access$getExtensionCallback$p(r5);
            if (r8 == null) goto L4;
            r8.onWindowLayoutChanged(r2, SidecarCompat.access$getSidecarAdapter$p(r5).translate(r4, r6));
            goto L4
        }

        @SuppressLint({"SyntheticAccessor"})
        public void onWindowLayoutChanged(IBinder r3, SidecarWindowLayoutInfo r4) {
            o.f(r3, "windowToken");
            o.f(r4, "newLayout");
            Activity r5 = (Activity) SidecarCompat.access$getWindowListenerRegisteredContexts$p(this.this$0).get(r3);
            if (r5 != null) goto L6;
            Log.w(SidecarCompat.TAG, "Unable to resolve activity from window token. Missing a call to #onWindowLayoutChangeListenerAdded()?");
            return;
        L6:
            SidecarAdapter r0 = SidecarCompat.access$getSidecarAdapter$p(this.this$0);
            SidecarInterface r1 = this.this$0.getSidecar();
            if (r1 != null) goto L9;
            SidecarDeviceState r2 = null;
        L10:
            if (r2 != null) goto L12;
            r2 = new SidecarDeviceState();
        L12:
            WindowLayoutInfo r6 = r0.translate(r4, r2);
            ExtensionInterfaceCompat.ExtensionCallbackInterface r7 = SidecarCompat.access$getExtensionCallback$p(this.this$0);
            if (r7 == null) goto L17;
            r7.onWindowLayoutChanged(r5, r6);
            return;
        L17:
            return;
        L9:
            r2 = r1.getDeviceState();
            goto L10
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SidecarCompat(Context r4) {
        o.f(r4, "context");
        this(Companion.getSidecarCompat$window_release(r4), new SidecarAdapter(null, 1, 0 == true ? 1 : 0));
    }

    @VisibleForTesting
    public SidecarCompat(@VisibleForTesting SidecarInterface r2, SidecarAdapter r3) {
        o.f(r3, "sidecarAdapter");
        this.sidecar = r2;
        this.sidecarAdapter = r3;
        this.windowListenerRegisteredContexts = new LinkedHashMap();
        this.componentCallbackMap = new LinkedHashMap();
    }

    public static final /* synthetic */ ExtensionInterfaceCompat.ExtensionCallbackInterface access$getExtensionCallback$p(SidecarCompat r0) {
        return r0.extensionCallback;
    }

    public static final /* synthetic */ SidecarAdapter access$getSidecarAdapter$p(SidecarCompat r0) {
        return r0.sidecarAdapter;
    }

    public static final /* synthetic */ Map access$getWindowListenerRegisteredContexts$p(SidecarCompat r0) {
        return r0.windowListenerRegisteredContexts;
    }

    private final void registerConfigurationChangeListener(final Activity r2) {
        if (this.componentCallbackMap.get(r2) != null) goto L6;
        ComponentCallbacks r0 = new SidecarCompat$registerConfigurationChangeListener$configChangeObserver$1(this, r2);
        this.componentCallbackMap.put(r2, r0);
        r2.registerComponentCallbacks(r0);
        return;
    }

    private final void unregisterComponentCallback(Activity r2) {
        r2.unregisterComponentCallbacks(this.componentCallbackMap.get(r2));
        this.componentCallbackMap.remove(r2);
    }

    public final SidecarInterface getSidecar() {
        return this.sidecar;
    }

    @VisibleForTesting
    public final WindowLayoutInfo getWindowLayoutInfo(Activity r3) {
        o.f(r3, "activity");
        IBinder r4 = Companion.getActivityWindowToken$window_release(r3);
        if (r4 == null) goto L5;
        SidecarInterface r0 = this.sidecar;
        SidecarDeviceState r1 = null;
        if (r0 != null) goto L9;
        SidecarWindowLayoutInfo r5 = null;
    L10:
        SidecarAdapter r2 = this.sidecarAdapter;
        SidecarInterface r6 = this.sidecar;
        if (r6 == null) goto L14;
        r1 = r6.getDeviceState();
    L14:
        if (r1 != null) goto L17;
        r1 = new SidecarDeviceState();
    L17:
        return r2.translate(r5, r1);
    L9:
        r5 = r0.getWindowLayoutInfo(r4);
        goto L10
    L5:
        return new WindowLayoutInfo(r.g());
    }

    @Override // androidx.window.layout.ExtensionInterfaceCompat
    public void onWindowLayoutChangeListenerAdded(Activity r2) {
        o.f(r2, "activity");
        IBinder r0 = Companion.getActivityWindowToken$window_release(r2);
        if (r0 == null) goto L5;
        register(r0, r2);
        return;
    L5:
        FirstAttachAdapter r1 = new FirstAttachAdapter(this, r2);
        r2.getWindow().getDecorView().addOnAttachStateChangeListener(r1);
    }

    @Override // androidx.window.layout.ExtensionInterfaceCompat
    public void onWindowLayoutChangeListenerRemoved(Activity r4) {
        o.f(r4, "activity");
        IBinder r0 = Companion.getActivityWindowToken$window_release(r4);
        if (r0 != null) goto L5;
        return;
    L5:
        SidecarInterface r1 = this.sidecar;
        if (r1 == null) goto L9;
        r1.onWindowLayoutChangeListenerRemoved(r0);
    L9:
        unregisterComponentCallback(r4);
        if (this.windowListenerRegisteredContexts.size() != 1) goto L12;
        boolean r5 = true;
    L13:
        this.windowListenerRegisteredContexts.remove(r0);
        if (r5 == false) goto L20;
        SidecarInterface r3 = this.sidecar;
        if (r3 == null) goto L21;
        r3.onDeviceStateListenersChanged(true);
        return;
    L21:
        return;
    L20:
        return;
    L12:
        r5 = false;
        goto L13
    }

    public final void register(IBinder r2, Activity r3) {
        o.f(r2, "windowToken");
        o.f(r3, "activity");
        this.windowListenerRegisteredContexts.put(r2, r3);
        SidecarInterface r0 = this.sidecar;
        if (r0 == null) goto L7;
        r0.onWindowLayoutChangeListenerAdded(r2);
    L7:
        if (this.windowListenerRegisteredContexts.size() != 1) goto L12;
        SidecarInterface r4 = this.sidecar;
        if (r4 == null) goto L12;
        r4.onDeviceStateListenersChanged(false);
    L12:
        ExtensionInterfaceCompat.ExtensionCallbackInterface r5 = this.extensionCallback;
        if (r5 == null) goto L16;
        r5.onWindowLayoutChanged(r3, getWindowLayoutInfo(r3));
    L16:
        registerConfigurationChangeListener(r3);
    }

    @Override // androidx.window.layout.ExtensionInterfaceCompat
    public void setExtensionCallback(ExtensionInterfaceCompat.ExtensionCallbackInterface r4) {
        o.f(r4, "extensionCallback");
        this.extensionCallback = new DistinctElementCallback(r4);
        SidecarInterface r5 = this.sidecar;
        if (r5 == null) goto L7;
        r5.setSidecarCallback(new DistinctSidecarElementCallback(this.sidecarAdapter, new TranslatingCallback(this)));
        return;
    }

    @Override // androidx.window.layout.ExtensionInterfaceCompat
    @SuppressLint({"BanUncheckedReflection"})
    public boolean validateExtensionInterface() {
        SidecarInterface r2 = this.sidecar;     // Catch: Throwable -> L91
        Class<?> r3 = null;
        if (r2 != null) goto L6;
    L5:
        Method r4 = null;
    L10:
        if (r4 != null) goto L12;
        Class<?> r5 = null;
    L14:
        if (o.a(r5, Void.TYPE) == false) goto L90;
        SidecarInterface r6 = this.sidecar;     // Catch: Throwable -> L91
        if (r6 == null) goto L19;
        r6.getDeviceState();     // Catch: Throwable -> L91
    L19:
        SidecarInterface r7 = this.sidecar;     // Catch: Throwable -> L91
        if (r7 == null) goto L23;
        r7.onDeviceStateListenersChanged(true);     // Catch: Throwable -> L91
    L23:
        SidecarInterface r8 = this.sidecar;     // Catch: Throwable -> L91
        if (r8 != null) goto L26;
    L25:
        Method r9 = null;
    L30:
        if (r9 != null) goto L32;
        Class<?> r10 = null;
    L34:
        if (o.a(r10, SidecarWindowLayoutInfo.class) == false) goto L88;
        SidecarInterface r11 = this.sidecar;     // Catch: Throwable -> L91
        if (r11 != null) goto L38;
    L37:
        Method r12 = null;
    L42:
        if (r12 != null) goto L44;
        Class<?> r13 = null;
    L46:
        if (o.a(r13, Void.TYPE) == false) goto L86;
        SidecarInterface r14 = this.sidecar;     // Catch: Throwable -> L91
        if (r14 != null) goto L50;
    L49:
        Method r15 = null;
    L54:
        if (r15 == null) goto L58;
        r3 = r15.getReturnType();     // Catch: Throwable -> L91
    L58:
        if (o.a(r3, Void.TYPE) == false) goto L84;
        SidecarDeviceState r16 = new SidecarDeviceState();     // Catch: Throwable -> L91
        r16.posture = 3;     // Catch: NoSuchFieldError -> L63 Throwable -> L91
    L67:
        SidecarDisplayFeature r17 = new SidecarDisplayFeature();     // Catch: Throwable -> L91
        Rect r18 = r17.getRect();     // Catch: Throwable -> L91
        o.e(r18, "displayFeature.rect");     // Catch: Throwable -> L91
        r17.setRect(r18);     // Catch: Throwable -> L91
        r17.getType();     // Catch: Throwable -> L91
        r17.setType(1);     // Catch: Throwable -> L91
        SidecarWindowLayoutInfo r19 = new SidecarWindowLayoutInfo();     // Catch: Throwable -> L91
        List r20 = r19.displayFeatures;     // Catch: NoSuchFieldError -> L70 Throwable -> L91
        goto L92
    L99:
        return true;
    L70:
        ArrayList r21 = new ArrayList();     // Catch: Throwable -> L91
        r21.add(r17);     // Catch: Throwable -> L91
        SidecarWindowLayoutInfo.class.getMethod("setDisplayFeatures", new Class[]{List.class}).invoke(r19, new Object[]{r21});     // Catch: Throwable -> L91
        Object r22 = SidecarWindowLayoutInfo.class.getMethod("getDisplayFeatures", new Class[0]).invoke(r19, new Object[0]);     // Catch: Throwable -> L91
        if (r22 == null) goto L78;
        if (o.a(r21, (List) r22) == false) goto L76;
        return true;
    L76:
        throw new Exception("Invalid display feature getter/setter");     // Catch: Throwable -> L91
    L78:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>");     // Catch: Throwable -> L91
    L63:
        SidecarDeviceState.class.getMethod("setPosture", new Class[]{Integer.TYPE}).invoke(r16, new Object[]{3});     // Catch: Throwable -> L91
        Object r23 = SidecarDeviceState.class.getMethod("getPosture", new Class[0]).invoke(r16, new Object[0]);     // Catch: Throwable -> L91
        if (r23 == null) goto L82;
        if (((Integer) r23).intValue() == 3) goto L67;
        throw new Exception("Invalid device posture getter/setter");     // Catch: Throwable -> L91
    L82:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");     // Catch: Throwable -> L91
    L84:
        throw new NoSuchMethodException(o.m("Illegal return type for 'onWindowLayoutChangeListenerRemoved': ", r3));     // Catch: Throwable -> L91
    L50:
        Class<?> r24 = r14.getClass();     // Catch: Throwable -> L91
        if (r24 == null) goto L49;
        r15 = r24.getMethod("onWindowLayoutChangeListenerRemoved", new Class[]{IBinder.class});     // Catch: Throwable -> L91
        goto L54
    L86:
        throw new NoSuchMethodException(o.m("Illegal return type for 'onWindowLayoutChangeListenerAdded': ", r13));     // Catch: Throwable -> L91
    L44:
        r13 = r12.getReturnType();     // Catch: Throwable -> L91
        goto L46
    L38:
        Class<?> r25 = r11.getClass();     // Catch: Throwable -> L91
        if (r25 == null) goto L37;
        r12 = r25.getMethod("onWindowLayoutChangeListenerAdded", new Class[]{IBinder.class});     // Catch: Throwable -> L91
        goto L42
    L88:
        throw new NoSuchMethodException(o.m("Illegal return type for 'getWindowLayoutInfo': ", r10));     // Catch: Throwable -> L91
    L32:
        r10 = r9.getReturnType();     // Catch: Throwable -> L91
        goto L34
    L26:
        Class<?> r26 = r8.getClass();     // Catch: Throwable -> L91
        if (r26 == null) goto L25;
        r9 = r26.getMethod("getWindowLayoutInfo", new Class[]{IBinder.class});     // Catch: Throwable -> L91
        goto L30
    L90:
        throw new NoSuchMethodException(o.m("Illegal return type for 'setSidecarCallback': ", r5));     // Catch: Throwable -> L91
    L12:
        r5 = r4.getReturnType();     // Catch: Throwable -> L91
        goto L14
    L6:
        Class<?> r27 = r2.getClass();     // Catch: Throwable -> L91
        if (r27 == null) goto L5;
        r4 = r27.getMethod("setSidecarCallback", new Class[]{SidecarInterface.SidecarCallback.class});     // Catch: Throwable -> L91
    L92:
        return false;
    }
}
