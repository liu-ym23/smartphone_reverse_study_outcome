package com.bytedance.monitor.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ActivityThreadUtils {
    public static final int BIND_SERVICE = 121;
    public static final int CREATE_SERVICE = 114;
    public static final int DUMP_SERVICE = 123;
    public static final int EXECUTE_TRANSACTION = 159;
    public static final int LAUNCH_ACTIVITY = 100;
    public static final int PAUSE_ACTIVITY = 101;
    public static final int RECEIVER = 113;
    public static final int SERVICE_ARGS = 115;
    public static final int STOP_SERVICE = 116;
    public static final int UNBIND_SERVICE = 122;
    private static final long WAIT_TIME = 5000;
    private static Class activityThread$HClass;
    private static Class activityThreadClass;
    private static Object mAppThread;
    private static Field mAppThreadField;
    private static Field mHField;
    private static Object mInstrumentation;
    private static Field mInstrumentationField;
    private static Set<Integer> mMessageIds;
    private static Object sActivityThread;
    private static Class sClassForActivityThread;
    private static Object smHInActivityThread;

    public ActivityThreadUtils() {
    }

    static /* synthetic */ Object access$002(Object r0) {
        sActivityThread = r0;
        return r0;
    }

    static /* synthetic */ Class access$100() {
        return sClassForActivityThread;
    }

    static {
        HashSet r0 = new HashSet();
        mMessageIds = r0;
        r0.add(113);
        mMessageIds.add(114);
        mMessageIds.add(115);
        mMessageIds.add(116);
        mMessageIds.add(121);
        mMessageIds.add(122);
        mMessageIds.add(100);
        mMessageIds.add(Integer.valueOf(EXECUTE_TRANSACTION));
        mMessageIds.add(123);
    }

    public static boolean isMessageNeedInterrupt(Message r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (mMessageIds.contains(Integer.valueOf(r2.what)) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static synchronized Class getActivityThread$HClass() {
        monitor-enter(ActivityThreadUtils.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (activityThread$HClass == null) goto L18;
    L10:
        Class r1 = activityThread$HClass;     // Catch: Throwable -> L13
        monitor-exit(ActivityThreadUtils.class);
        return r1;
    L18:
        activityThread$HClass = Class.forName("android.app.ActivityThread$H");     // Catch: ClassNotFoundException -> L8 Throwable -> L13
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L13
        goto L10
    }

    public static synchronized Class getActivityThreadClass() {
        monitor-enter(ActivityThreadUtils.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (activityThreadClass == null) goto L18;
    L10:
        Class r1 = activityThreadClass;     // Catch: Throwable -> L13
        monitor-exit(ActivityThreadUtils.class);
        return r1;
    L18:
        activityThreadClass = Class.forName("android.app.ActivityThread");     // Catch: ClassNotFoundException -> L8 Throwable -> L13
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L13
        goto L10
    }

    public static synchronized Field getHField() {
        monitor-enter(ActivityThreadUtils.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (mHField != null) goto L7;
        mHField = FieldUtils.getField(getActivityThreadClass(), "mH");     // Catch: Throwable -> L10
    L7:
        Field r1 = mHField;     // Catch: Throwable -> L10
        monitor-exit(ActivityThreadUtils.class);
        return r1;
    }

    public static synchronized Field getInstrumentationField() {
        monitor-enter(ActivityThreadUtils.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (mInstrumentationField != null) goto L7;
        mInstrumentationField = FieldUtils.getField(getActivityThreadClass(), "mInstrumentation");     // Catch: Throwable -> L10
    L7:
        Field r1 = mInstrumentationField;     // Catch: Throwable -> L10
        monitor-exit(ActivityThreadUtils.class);
        return r1;
    }

    public static synchronized Field getAppThreadField() {
        monitor-enter(ActivityThreadUtils.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (mAppThreadField != null) goto L7;
        mAppThreadField = FieldUtils.getField(getActivityThreadClass(), "mAppThread");     // Catch: Throwable -> L10
    L7:
        Field r1 = mAppThreadField;     // Catch: Throwable -> L10
        monitor-exit(ActivityThreadUtils.class);
        return r1;
    }

    public static synchronized Object getsActivityThread() {
        monitor-enter(ActivityThreadUtils.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sActivityThread != null) goto L7;
        sActivityThread = MethodUtils.invokeStaticMethod(getActivityThreadClass(), "currentActivityThread", new Object[0]);     // Catch: Throwable -> L10 Throwable -> L13
    L7:
        Object r1 = sActivityThread;     // Catch: Throwable -> L10 Throwable -> L13
        monitor-exit(ActivityThreadUtils.class);
        return r1;
    L14:
        return null;
    }

    public static synchronized Object getHInActivityThread() {
        monitor-enter(ActivityThreadUtils.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (smHInActivityThread == null) goto L16;
    L10:
        Object r1 = smHInActivityThread;     // Catch: Throwable -> L13
        monitor-exit(ActivityThreadUtils.class);
        return r1;
    L16:
        smHInActivityThread = getHField().get(getsActivityThread());     // Catch: IllegalAccessException -> L8 Throwable -> L13
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L13
        goto L10
    }

    public static synchronized Object getInstrumentation() {
        monitor-enter(ActivityThreadUtils.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (mInstrumentation == null) goto L16;
    L10:
        Object r1 = mInstrumentation;     // Catch: Throwable -> L13
        monitor-exit(ActivityThreadUtils.class);
        return r1;
    L16:
        mInstrumentation = getInstrumentationField().get(getsActivityThread());     // Catch: IllegalAccessException -> L8 Throwable -> L13
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L13
        goto L10
    }

    public static synchronized Object getAppThread() {
        monitor-enter(ActivityThreadUtils.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (mAppThread == null) goto L16;
    L10:
        Object r1 = mAppThread;     // Catch: Throwable -> L13
        monitor-exit(ActivityThreadUtils.class);
        return r1;
    L16:
        mAppThread = getAppThreadField().get(getsActivityThread());     // Catch: IllegalAccessException -> L8 Throwable -> L13
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L13
        goto L10
    }

    public static Object currentActivityThread() {
        if (sActivityThread != null) goto L36;
        monitor-enter(ActivityThreadUtils.class);     // Catch: Exception -> L33
    L30:
        th = move-exception;
        throw th;     // Catch: Exception -> L33
    L7:
        if (sActivityThread != null) goto L13;
        if (sClassForActivityThread != null) goto L11;
        sClassForActivityThread = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L30
    L11:
        sActivityThread = MethodUtils.invokeStaticMethod(sClassForActivityThread, "currentActivityThread", new Object[0]);     // Catch: Throwable -> L30
    L13:
        if (sActivityThread == null) goto L15;
    L28:
        monitor-exit(ActivityThreadUtils.class);     // Catch: Throwable -> L30
        goto L36
    L15:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L28;
        final Object r1 = new Object();     // Catch: Throwable -> L30
        new Handler(Looper.getMainLooper()).post(new AnonymousClass1(r1));     // Catch: Throwable -> L30
        if (sActivityThread != null) goto L28;
        monitor-enter(r1);     // Catch: Throwable -> L30
        r1.wait(5000);     // Catch: Throwable -> L22 InterruptedException -> L37
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L24:
        monitor-exit(r1);     // Catch: Throwable -> L22
    L33:
        e = move-exception;
        e.printStackTrace();
    L36:
        return sActivityThread;
    }
}
