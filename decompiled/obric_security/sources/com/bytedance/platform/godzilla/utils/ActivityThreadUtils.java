package com.bytedance.platform.godzilla.utils;

import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityThreadUtils {
    private static Class activityThreadClass;
    private static Class activityThreadHClass;
    private static Object mAppThread;
    private static Field mAppThreadField;
    private static Field mHField;
    private static Object mInstrumentation;
    private static Field mInstrumentationField;
    private static Object mResourcesManager;
    private static Object sActivityThread;
    private static Object smHInActivityThread;

    private ActivityThreadUtils() {
    }

    public static synchronized Class getActivityThreadHClass() {
        monitor-enter(ActivityThreadUtils.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (activityThreadHClass == null) goto L18;
    L10:
        Class r1 = activityThreadHClass;     // Catch: Throwable -> L13
        monitor-exit(ActivityThreadUtils.class);
        return r1;
    L18:
        activityThreadHClass = Class.forName("android.app.ActivityThread$H");     // Catch: ClassNotFoundException -> L8 Throwable -> L13
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

    public static synchronized Object getResourcesManagerInActivityThread() {
        monitor-enter(ActivityThreadUtils.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (mResourcesManager == null) goto L18;
    L10:
        Object r1 = mResourcesManager;     // Catch: Throwable -> L13
        monitor-exit(ActivityThreadUtils.class);
        return r1;
    L18:
        mResourcesManager = FieldUtils.getField(getActivityThreadClass(), "mResourcesManager").get(getsActivityThread());     // Catch: IllegalAccessException -> L8 Throwable -> L13
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L13
        goto L10
    }
}
