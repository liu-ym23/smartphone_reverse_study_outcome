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

    public ActivityThreadUtils() {
    }

    public static /* synthetic */ Object access$002(Object r0) {
        sActivityThread = r0;
        return r0;
    }

    public static /* synthetic */ Class access$100() {
        return sClassForActivityThread;
    }

    public static Object currentActivityThread() {
        if (sActivityThread != null) goto L37;
        monitor-enter(ActivityThreadUtils.class);     // Catch: Exception -> L34
    L11:
        th = move-exception;
        throw th;     // Catch: Exception -> L34
    L7:
        if (sActivityThread != null) goto L15;
        if (sClassForActivityThread != null) goto L13;
        sClassForActivityThread = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L11
    L13:
        sActivityThread = MethodUtils.invokeStaticMethod(sClassForActivityThread, "currentActivityThread", new Object[0]);     // Catch: Throwable -> L11
    L15:
        if (sActivityThread == null) goto L17;
    L30:
        monitor-exit(ActivityThreadUtils.class);     // Catch: Throwable -> L11
        goto L37
    L17:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L30;
        final Object r1 = new Object();     // Catch: Throwable -> L11
        new Handler(Looper.getMainLooper()).post(new AnonymousClass1(r1));     // Catch: Throwable -> L11
        if (sActivityThread != null) goto L30;
        monitor-enter(r1);     // Catch: Throwable -> L11
        r1.wait(5000);     // Catch: Throwable -> L24 InterruptedException -> L38
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L26:
        monitor-exit(r1);     // Catch: Throwable -> L24
    L34:
        e = move-exception;
        e.printStackTrace();
    L37:
        return sActivityThread;
    }

    public static synchronized Class getActivityThread$HClass() {
        monitor-enter(ActivityThreadUtils.class);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (activityThread$HClass == null) goto L19;
    L12:
        Class r1 = activityThread$HClass;     // Catch: Throwable -> L8
        monitor-exit(ActivityThreadUtils.class);
        return r1;
    L19:
        activityThread$HClass = Class.forName("android.app.ActivityThread$H");     // Catch: Throwable -> L8 ClassNotFoundException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
        goto L12
    }

    public static synchronized Class getActivityThreadClass() {
        monitor-enter(ActivityThreadUtils.class);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (activityThreadClass == null) goto L19;
    L12:
        Class r1 = activityThreadClass;     // Catch: Throwable -> L8
        monitor-exit(ActivityThreadUtils.class);
        return r1;
    L19:
        activityThreadClass = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L8 ClassNotFoundException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
        goto L12
    }

    public static synchronized Object getAppThread() {
        monitor-enter(ActivityThreadUtils.class);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (mAppThread == null) goto L19;
    L12:
        Object r1 = mAppThread;     // Catch: Throwable -> L8
        monitor-exit(ActivityThreadUtils.class);
        return r1;
    L19:
        mAppThread = getAppThreadField().get(getsActivityThread());     // Catch: Throwable -> L8 IllegalAccessException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
        goto L12
    }

    public static synchronized Field getAppThreadField() {
        monitor-enter(ActivityThreadUtils.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (mAppThreadField != null) goto L9;
        mAppThreadField = FieldUtils.getField(getActivityThreadClass(), "mAppThread");     // Catch: Throwable -> L7
    L9:
        Field r1 = mAppThreadField;     // Catch: Throwable -> L7
        monitor-exit(ActivityThreadUtils.class);
        return r1;
    }

    public static synchronized Field getHField() {
        monitor-enter(ActivityThreadUtils.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (mHField != null) goto L9;
        mHField = FieldUtils.getField(getActivityThreadClass(), "mH");     // Catch: Throwable -> L7
    L9:
        Field r1 = mHField;     // Catch: Throwable -> L7
        monitor-exit(ActivityThreadUtils.class);
        return r1;
    }

    public static synchronized Object getHInActivityThread() {
        monitor-enter(ActivityThreadUtils.class);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (smHInActivityThread == null) goto L19;
    L12:
        Object r1 = smHInActivityThread;     // Catch: Throwable -> L8
        monitor-exit(ActivityThreadUtils.class);
        return r1;
    L19:
        smHInActivityThread = getHField().get(getsActivityThread());     // Catch: Throwable -> L8 IllegalAccessException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
        goto L12
    }

    public static synchronized Object getInstrumentation() {
        monitor-enter(ActivityThreadUtils.class);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (mInstrumentation == null) goto L19;
    L12:
        Object r1 = mInstrumentation;     // Catch: Throwable -> L8
        monitor-exit(ActivityThreadUtils.class);
        return r1;
    L19:
        mInstrumentation = getInstrumentationField().get(getsActivityThread());     // Catch: Throwable -> L8 IllegalAccessException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
        goto L12
    }

    public static synchronized Field getInstrumentationField() {
        monitor-enter(ActivityThreadUtils.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (mInstrumentationField != null) goto L9;
        mInstrumentationField = FieldUtils.getField(getActivityThreadClass(), "mInstrumentation");     // Catch: Throwable -> L7
    L9:
        Field r1 = mInstrumentationField;     // Catch: Throwable -> L7
        monitor-exit(ActivityThreadUtils.class);
        return r1;
    }

    public static synchronized Object getsActivityThread() {
        monitor-enter(ActivityThreadUtils.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (sActivityThread != null) goto L9;
        sActivityThread = MethodUtils.invokeStaticMethod(getActivityThreadClass(), "currentActivityThread", new Object[0]);     // Catch: Throwable -> L7 Throwable -> L14
    L9:
        Object r1 = sActivityThread;     // Catch: Throwable -> L7 Throwable -> L14
        monitor-exit(ActivityThreadUtils.class);
        return r1;
    L15:
        return null;
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
}
