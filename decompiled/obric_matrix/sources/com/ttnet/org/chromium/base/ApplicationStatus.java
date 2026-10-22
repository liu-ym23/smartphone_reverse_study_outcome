package com.ttnet.org.chromium.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.view.Window;
import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base::android")
public class ApplicationStatus {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TOOLBAR_CALLBACK_WRAPPER_CLASS = "androidx.appcompat.app.ToolbarActionBar$ToolbarCallbackWrapper";

    @SuppressLint({"StaticFieldLeak"})
    private static Activity sActivity;
    private static final Map<Activity, ActivityInfo> sActivityInfo = null;
    private static ObserverList<ApplicationStateListener> sApplicationStateListeners;

    @SuppressLint({"SupportAnnotationUsage"})
    private static int sCurrentApplicationState;
    private static ObserverList<ActivityStateListener> sGeneralActivityStateListeners;
    private static ApplicationStateListener sNativeApplicationStateListener;
    private static ObserverList<WindowFocusChangedListener> sWindowFocusListeners;

    private static class ActivityInfo {
        private ObserverList<ActivityStateListener> mListeners;
        private int mStatus;

        private ActivityInfo() {
            this.mStatus = 6;
            this.mListeners = new ObserverList();
        }

        /* synthetic */ ActivityInfo(AnonymousClass1 r1) {
            this();
        }

        public ObserverList<ActivityStateListener> getListeners() {
            return this.mListeners;
        }

        public int getStatus() {
            return this.mStatus;
        }

        public void setStatus(int r1) {
            this.mStatus = r1;
        }
    }

    public interface ActivityStateListener {
        void onActivityStateChange(Activity r1, int r2);
    }

    public interface ApplicationStateListener {
        void onApplicationStateChange(int r1);
    }

    interface Natives {
        void onApplicationStateChange(int r1);
    }

    @VisibleForTesting
    static class WindowCallbackProxy implements InvocationHandler {
        private final Activity mActivity;
        private final Window.Callback mCallback;

        public WindowCallbackProxy(Activity r1, Window.Callback r2) {
            this.mCallback = r2;
            this.mActivity = r1;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r2, Method r3, Object[] r4) {
            if (r3.getName().equals("onWindowFocusChanged") == true) goto L5;
        L18:
            return r3.invoke(this.mCallback, r4);
        L12:
            e = move-exception;
            if ((e.getCause() instanceof AbstractMethodError) == true) goto L16;
            throw e;
        L16:
            throw e.getCause();
        L5:
            if (r4.length != 1) goto L18;
            if ((r4[0] instanceof Boolean) == false) goto L18;
            onWindowFocusChanged(((Boolean) r4[0]).booleanValue());
            return null;
        }

        public void onWindowFocusChanged(boolean r4) {
            this.mCallback.onWindowFocusChanged(r4);
            if (ApplicationStatus.access$000() == null) goto L8;
            Iterator r0 = ApplicationStatus.access$000().iterator();
        L6:
            if (r0.hasNext() == false) goto L10;
            ((WindowFocusChangedListener) r0.next()).onWindowFocusChanged(this.mActivity, r4);
            goto L6
        L10:
            return;
        }
    }

    public interface WindowFocusChangedListener {
        void onWindowFocusChanged(Activity r1, boolean r2);
    }

    static {
        sActivityInfo = Collections.synchronizedMap(new HashMap());
        sCurrentApplicationState = 0;
    }

    private ApplicationStatus() {
    }

    static /* synthetic */ ObserverList access$000() {
        return sWindowFocusListeners;
    }

    static /* synthetic */ Activity access$100() {
        return sActivity;
    }

    static /* synthetic */ Activity access$102(Activity r0) {
        sActivity = r0;
        return r0;
    }

    static /* synthetic */ void access$200(Activity r0, int r1) {
        onStateChange(r0, r1);
    }

    static /* synthetic */ ApplicationStateListener access$400() {
        return sNativeApplicationStateListener;
    }

    static /* synthetic */ ApplicationStateListener access$402(ApplicationStateListener r0) {
        sNativeApplicationStateListener = r0;
        return r0;
    }

    @VisibleForTesting
    static Window.Callback createWindowCallbackProxy(Activity r4, Window.Callback r5) {
        return (Window.Callback) Proxy.newProxyInstance(Window.Callback.class.getClassLoader(), new Class[]{Window.Callback.class}, new WindowCallbackProxy(r4, r5));
    }

    @MainThread
    public static void destroyForJUnitTests() {
        Map<Activity, ActivityInfo> r0 = sActivityInfo;
        monitor-enter(r0);
        ObserverList<ApplicationStateListener> r1 = sApplicationStateListeners;     // Catch: Throwable -> L16
        if (r1 == null) goto L7;
        r1.clear();     // Catch: Throwable -> L16
    L7:
        ObserverList<ActivityStateListener> r2 = sGeneralActivityStateListeners;     // Catch: Throwable -> L16
        if (r2 == null) goto L10;
        r2.clear();     // Catch: Throwable -> L16
    L10:
        r0.clear();     // Catch: Throwable -> L16
        ObserverList<WindowFocusChangedListener> r3 = sWindowFocusListeners;     // Catch: Throwable -> L16
        if (r3 == null) goto L13;
        r3.clear();     // Catch: Throwable -> L16
    L13:
        sCurrentApplicationState = 0;     // Catch: Throwable -> L16
        sActivity = null;     // Catch: Throwable -> L16
        sNativeApplicationStateListener = null;     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    private static int determineApplicationStateLocked() {
        Iterator<ActivityInfo> r0 = sActivityInfo.values().iterator();
        boolean r1 = false;
        boolean r2 = false;
    L4:
        if (r0.hasNext() == false) goto L15;
        int r3 = r0.next().getStatus();
        if (r3 == 4) goto L11;
        if (r3 == 5) goto L11;
        if (r3 == 6) goto L11;
        return 1;
    L11:
        if (r3 == 4) goto L12;
        if (r3 != 5) goto L4;
        r2 = true;
        goto L4
    L12:
        r1 = true;
        goto L4
    L15:
        if (r1 == false) goto L18;
        return 2;
    L18:
        if (r2 == false) goto L21;
        return 3;
    L21:
        return 4;
    }

    @MainThread
    public static Activity getLastTrackedFocusedActivity() {
        return sActivity;
    }

    @AnyThread
    public static List<Activity> getRunningActivities() {
        Map<Activity, ActivityInfo> r0 = sActivityInfo;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList(r0.keySet());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @AnyThread
    public static int getStateForActivity(@Nullable Activity r2) {
        if (r2 != null) goto L5;
        return 6;
    L5:
        ActivityInfo r3 = sActivityInfo.get(r2);
        if (r3 != null) goto L8;
        return 6;
    L8:
        return r3.getStatus();
    }

    @AnyThread
    @CalledByNative
    public static int getStateForApplication() {
        Map<Activity, ActivityInfo> r0 = sActivityInfo;
        monitor-enter(r0);
        int r1 = sCurrentApplicationState;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @AnyThread
    @CalledByNative
    public static boolean hasVisibleActivities() {
        int r0 = getStateForApplication();
        if (r0 != 1) goto L5;
        return true;
    L5:
        if (r0 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    @MainThread
    public static void initialize(Application r2) {
        Map<Activity, ActivityInfo> r0 = sActivityInfo;
        monitor-enter(r0);
        sCurrentApplicationState = 4;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        registerWindowFocusChangedListener(new AnonymousClass1());
        r2.registerActivityLifecycleCallbacks(new AnonymousClass2());
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @AnyThread
    public static boolean isEveryActivityDestroyed() {
        return sActivityInfo.isEmpty();
    }

    public static boolean isInitialized() {
        Map<Activity, ActivityInfo> r0 = sActivityInfo;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sCurrentApplicationState == 0) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    private static void onStateChange(Activity r5, int r6) {
        if (r5 == null) goto L47;
        if (sActivity != null) goto L6;
    L11:
        sActivity = r5;
    L12:
        int r0 = getStateForApplication();
        Map<Activity, ActivityInfo> r1 = sActivityInfo;
        monitor-enter(r1);
        AnonymousClass1 r3 = null;
        if (r1.containsKey(r5) == true) goto L17;
        r1.put(r5, new ActivityInfo(r3));     // Catch: Throwable -> L43
    L17:
        ActivityInfo r2 = r1.get(r5);     // Catch: Throwable -> L43
        r2.setStatus(r6);     // Catch: Throwable -> L43
        if (r6 != 6) goto L22;
        r1.remove(r5);     // Catch: Throwable -> L43
        if (r5 != sActivity) goto L22;
        sActivity = null;     // Catch: Throwable -> L43
    L22:
        sCurrentApplicationState = determineApplicationStateLocked();     // Catch: Throwable -> L43
        monitor-exit(r1);     // Catch: Throwable -> L43
        Iterator<ActivityStateListener> r4 = r2.getListeners().iterator();
    L26:
        if (r4.hasNext() == false) goto L28;
        r4.next().onActivityStateChange(r5, r6);
        goto L26
    L28:
        ObserverList<ActivityStateListener> r7 = sGeneralActivityStateListeners;
        if (r7 == null) goto L34;
        Iterator<ActivityStateListener> r8 = r7.iterator();
    L32:
        if (r8.hasNext() == false) goto L34;
        r8.next().onActivityStateChange(r5, r6);
    L34:
        int r9 = getStateForApplication();
        if (r9 == r0) goto L42;
        ObserverList<ApplicationStateListener> r10 = sApplicationStateListeners;
        if (r10 == null) goto L53;
        Iterator<ApplicationStateListener> r11 = r10.iterator();
    L40:
        if (r11.hasNext() == false) goto L54;
        r11.next().onApplicationStateChange(r9);
        goto L40
    L54:
        return;
    L53:
        return;
    L42:
        return;
    L43:
        th = move-exception;
        throw th;
    L6:
        if (r6 == 1) goto L11;
        if (r6 == 3) goto L11;
        if (r6 != 2) goto L12;
    L47:
        throw new IllegalArgumentException("null activity is not supported");
    }

    @MainThread
    @VisibleForTesting
    public static void onStateChangeForTesting(Activity r0, int r1) {
        onStateChange(r0, r1);
    }

    @VisibleForTesting
    static boolean reachesWindowCallback(@Nullable Window.Callback r9) {
        if (r9 != null) goto L6;
        return false;
    L6:
        if (r9.getClass().getName().equals(TOOLBAR_CALLBACK_WRAPPER_CLASS) == false) goto L9;
        return true;
    L9:
        if (Proxy.isProxyClass(r9.getClass()) == true) goto L11;
        Class<?> r1 = r9.getClass();
    L14:
        if (r1 == Object.class) goto L30;
        Field[] r3 = r1.getDeclaredFields();
        int r4 = r3.length;
        int r5 = 0;
    L16:
        if (r5 >= r4) goto L29;
        Field r6 = r3[r5];
        if (r6.getType().isAssignableFrom(Window.Callback.class) == false) goto L28;
        boolean r7 = r6.isAccessible();
        r6.setAccessible(true);
        Window.Callback r8 = (Window.Callback) r6.get(r9);     // Catch: Throwable -> L24 IllegalAccessException -> L27
        r6.setAccessible(r7);
        if (reachesWindowCallback(r8) == false) goto L28;
        return true;
    L27:
        r6.setAccessible(r7);
    L24:
        th = move-exception;
        r6.setAccessible(r7);
        throw th;
    L28:
        r5 = r5 + 1;
        goto L16
    L29:
        r1 = r1.getSuperclass();
        goto L14
    L30:
        return false;
    L11:
        return Proxy.getInvocationHandler(r9) instanceof WindowCallbackProxy;
    }

    @MainThread
    public static void registerApplicationStateListener(ApplicationStateListener r1) {
        if (sApplicationStateListeners != null) goto L5;
        sApplicationStateListeners = new ObserverList();
    L5:
        sApplicationStateListeners.addObserver(r1);
    }

    @SuppressLint({"NewApi"})
    @MainThread
    public static void registerStateListenerForActivity(ActivityStateListener r1, Activity r2) {
        sActivityInfo.get(r2).getListeners().addObserver(r1);
    }

    @MainThread
    public static void registerStateListenerForAllActivities(ActivityStateListener r1) {
        if (sGeneralActivityStateListeners != null) goto L5;
        sGeneralActivityStateListeners = new ObserverList();
    L5:
        sGeneralActivityStateListeners.addObserver(r1);
    }

    @CalledByNative
    private static void registerThreadSafeNativeApplicationStateListener() {
        ThreadUtils.runOnUiThread(new AnonymousClass3());
    }

    @MainThread
    public static void registerWindowFocusChangedListener(WindowFocusChangedListener r1) {
        if (sWindowFocusListeners != null) goto L5;
        sWindowFocusListeners = new ObserverList();
    L5:
        sWindowFocusListeners.addObserver(r1);
    }

    @MainThread
    public static void resetActivitiesForInstrumentationTests() {
        Map<Activity, ActivityInfo> r0 = sActivityInfo;
        monitor-enter(r0);
        Iterator r1 = new HashSet(r0.keySet()).iterator();     // Catch: Throwable -> L10
    L6:
        if (r1.hasNext() == false) goto L8;
        onStateChangeForTesting((Activity) r1.next(), 6);     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @MainThread
    public static void unregisterActivityStateListener(ActivityStateListener r3) {
        ObserverList<ActivityStateListener> r0 = sGeneralActivityStateListeners;
        if (r0 == null) goto L5;
        r0.removeObserver(r3);
    L5:
        Map<Activity, ActivityInfo> r1 = sActivityInfo;
        monitor-enter(r1);
        Iterator<ActivityInfo> r2 = r1.values().iterator();     // Catch: Throwable -> L13
    L9:
        if (r2.hasNext() == false) goto L11;
        r2.next().getListeners().removeObserver(r3);     // Catch: Throwable -> L13
        goto L9
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    @MainThread
    public static void unregisterApplicationStateListener(ApplicationStateListener r1) {
        ObserverList<ApplicationStateListener> r0 = sApplicationStateListeners;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.removeObserver(r1);
    }

    @MainThread
    public static void unregisterWindowFocusChangedListener(WindowFocusChangedListener r1) {
        ObserverList<WindowFocusChangedListener> r0 = sWindowFocusListeners;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.removeObserver(r1);
    }
}
