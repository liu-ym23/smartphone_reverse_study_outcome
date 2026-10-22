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

    public static synchronized Class getActivityThreadHClass() {
        monitor-enter(ActivityThreadUtils.class);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (activityThreadHClass == null) goto L19;
    L12:
        Class r1 = activityThreadHClass;     // Catch: Throwable -> L8
        monitor-exit(ActivityThreadUtils.class);
        return r1;
    L19:
        activityThreadHClass = Class.forName("android.app.ActivityThread$H");     // Catch: Throwable -> L8 ClassNotFoundException -> L10
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

    public static synchronized Object getResourcesManagerInActivityThread() {
        monitor-enter(ActivityThreadUtils.class);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (mResourcesManager == null) goto L17;
    L12:
        Object r1 = mResourcesManager;     // Catch: Throwable -> L8
        monitor-exit(ActivityThreadUtils.class);
        return r1;
    L17:
        mResourcesManager = FieldUtils.getField(getActivityThreadClass(), "mResourcesManager").get(getsActivityThread());     // Catch: Throwable -> L8 IllegalAccessException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
        goto L12
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
}
