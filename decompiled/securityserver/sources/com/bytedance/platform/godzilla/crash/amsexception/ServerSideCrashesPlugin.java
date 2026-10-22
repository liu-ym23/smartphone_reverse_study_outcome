package com.bytedance.platform.godzilla.crash.amsexception;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.platform.godzilla.common.DoubleReflectHelper;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.plugin.BasePlugin;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ServerSideCrashesPlugin extends BasePlugin {
    private static boolean initialized = false;

    @SuppressLint({"CI_StaticFieldLeak"})
    private static Activity mActivity;
    private Application.ActivityLifecycleCallbacks mActivityLifecycleCallbacks;
    private Application mApplication;

    /* JADX INFO: renamed from: com.bytedance.platform.godzilla.crash.amsexception.ServerSideCrashesPlugin$1, reason: invalid class name */
    public static class AnonymousClass1 implements InvocationHandler {
        final /* synthetic */ Object val$rawIActivityManager;

        public AnonymousClass1(Object r1) {
            this.val$rawIActivityManager = r1;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r2, Method r3, Object[] r4) {
            if (r3.getName().contains("reportSizeConfigurations") == false) goto L12;
            return r3.invoke(this.val$rawIActivityManager, r4);
        L6:
            e = move-exception;
            if ((e.getTargetException() instanceof IllegalArgumentException) == false) goto L12;
            return null;
        L12:
            if (r3.getName().contains("isTopOfTask") == false) goto L21;
            return r3.invoke(this.val$rawIActivityManager, r4);
        L15:
            e = move-exception;
            if ((e.getTargetException() instanceof IllegalArgumentException) == false) goto L21;
            return Boolean.FALSE;
        L21:
            if (r3.getName().contains("willActivityBeVisible") == true) goto L39;
        L35:
            return r3.invoke(this.val$rawIActivityManager, r4);
        L29:
            th = move-exception;
            throw ServerSideCrashesPlugin.access$100(th);
        L39:
            ServerSideCrashesPlugin.access$000().isImmersive();     // Catch: IllegalArgumentException -> L24 Throwable -> L32
        L25:
            if (ServerSideCrashesPlugin.access$000() == null) goto L35;
            ServerSideCrashesPlugin.access$000().finish();
            goto L35
        }
    }

    public static class CrashCatchLifecycleCallback implements Application.ActivityLifecycleCallbacks {
        public CrashCatchLifecycleCallback() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r1, Bundle r2) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity r1) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity r1) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity r1) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity r1, Bundle r2) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity r1) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity r1) {
        }
    }

    public ServerSideCrashesPlugin() {
    }

    public static /* synthetic */ Activity access$000() {
        return mActivity;
    }

    public static /* synthetic */ Activity access$002(Activity r0) {
        mActivity = r0;
        return r0;
    }

    public static /* synthetic */ Throwable access$100(Throwable r0) {
        return getSafeThrowable(r0);
    }

    public static Field getDeclaredField(Object r2, String r3) {
        if (r2 != null) goto L5;
    L14:
        return null;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L14;
        Class<?> r4 = r2.getClass();
    L9:
        if (r4 == Object.class) goto L14;
        Field r1 = DoubleReflectHelper.getField(r4, r3);
        if (r1 != null) goto L12;
        r4 = r4.getSuperclass();
        goto L9
    L12:
        return r1;
    }

    private static Throwable getSafeThrowable(Throwable r7) {
        StackTraceElement[] r0 = r7.getStackTrace();     // Catch: Throwable -> L40
        if ((r7 instanceof InvocationTargetException) == false) goto L9;
        InvocationTargetException r1 = (InvocationTargetException) r7;     // Catch: Throwable -> L40
        if (r1.getTargetException() == null) goto L7;
        r7 = r1.getTargetException();     // Catch: Throwable -> L40
        r0 = r7.getStackTrace();     // Catch: Throwable -> L40
    L15:
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L40
        int r3 = 0;
        int r4 = 0;
    L17:
        if (r4 >= r0.length) goto L33;
        StackTraceElement r5 = r0[r4];     // Catch: Throwable -> L40
        if (r5 == null) goto L31;
        String r6 = r5.getClassName();     // Catch: Throwable -> L40
        if (TextUtils.isEmpty(r6) == false) goto L24;
    L30:
        r2.add(r5);     // Catch: Throwable -> L40
        goto L31
    L24:
        if (r6.contains("com.bytedance.platform.godzilla.crash.amsexception.ServerSideCrashesPlugin") == true) goto L31;
        if (r6.equals(Proxy.class.getName()) == true) goto L31;
        if (r6.equals(Method.class.getName()) == false) goto L30;
    L31:
        r4 = r4 + 1;     // Catch: Throwable -> L40
        goto L17
    L33:
        if (r2.isEmpty() == false) goto L35;
        return r7;
    L35:
        int r8 = r2.size();     // Catch: Throwable -> L40
        StackTraceElement[] r9 = new StackTraceElement[r8];     // Catch: Throwable -> L40
    L36:
        if (r3 >= r8) goto L38;
        r9[r3] = (StackTraceElement) r2.get(r3);     // Catch: Throwable -> L40
        r3 = r3 + 1;     // Catch: Throwable -> L40
        goto L36
    L38:
        r7.setStackTrace(r9);     // Catch: Throwable -> L40
        goto L39
    L7:
        RuntimeException r10 = new RuntimeException();     // Catch: Throwable -> L40
    L14:
        r7 = r10;
        goto L15
    L9:
        if ((r7 instanceof UndeclaredThrowableException) == false) goto L15;
        UndeclaredThrowableException r11 = (UndeclaredThrowableException) r7;     // Catch: Throwable -> L40
        if (r11.getUndeclaredThrowable() == null) goto L13;
        r7 = r11.getUndeclaredThrowable();     // Catch: Throwable -> L40
        r0 = r7.getStackTrace();     // Catch: Throwable -> L40
        goto L15
    L13:
        r10 = new RuntimeException();     // Catch: Throwable -> L40
    L39:
        return r7;
    }

    public static void hookAMS(boolean r0) {
        if (initialized == false) goto L5;
        return;
    L5:
        initialized = true;
    }

    public static void setStartedActivity(Activity r2) {
        Field r0 = getDeclaredField(r2, "mStartedActivity");
        if (r0 != null) goto L10;
        return;
    L10:
        r0.setAccessible(true);     // Catch: Exception -> L7
        r0.set(r2, Boolean.TRUE);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        Logger.d("ServerBugFixer", "setStartedActivity fail " + e);
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void destroy() {
        super.destroy();
        this.mApplication = null;
        this.mActivityLifecycleCallbacks = null;
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "ServerSideCrashesPlugin";
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void init(Application r1) {
        super.init(r1);
        this.mApplication = r1;
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void start() {
        super.start();
        CrashCatchLifecycleCallback r0 = new CrashCatchLifecycleCallback();
        this.mActivityLifecycleCallbacks = r0;
        Application r1 = this.mApplication;
        if (r1 == null) goto L6;
        r1.registerActivityLifecycleCallbacks(r0);
        return;
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void stop() {
        super.stop();
        Application.ActivityLifecycleCallbacks r0 = this.mActivityLifecycleCallbacks;
        if (r0 == null) goto L8;
        Application r1 = this.mApplication;
        if (r1 == null) goto L9;
        r1.unregisterActivityLifecycleCallbacks(r0);
        return;
    L9:
        return;
    }
}
