package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
final class ActivityRecreator {
    private static final String LOG_TAG = "ActivityRecreator";
    protected static final Class<?> activityThreadClass = null;
    private static final Handler mainHandler = null;
    protected static final Field mainThreadField = null;
    protected static final Method performStopActivity2ParamsMethod = null;
    protected static final Method performStopActivity3ParamsMethod = null;
    protected static final Method requestRelaunchActivityMethod = null;
    protected static final Field tokenField = null;

    private static final class LifecycleCheckCallbacks implements Application.ActivityLifecycleCallbacks {
        Object currentlyRecreatingToken;
        private Activity mActivity;
        private boolean mDestroyed;
        private final int mRecreatingHashCode;
        private boolean mStarted;
        private boolean mStopQueued;

        LifecycleCheckCallbacks(@NonNull Activity r2) {
            this.mStarted = false;
            this.mDestroyed = false;
            this.mStopQueued = false;
            this.mActivity = r2;
            this.mRecreatingHashCode = r2.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r1, Bundle r2) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity r2) {
            if (this.mActivity != r2) goto L6;
            this.mActivity = null;
            this.mDestroyed = true;
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity r3) {
            if (this.mDestroyed == true) goto L5;
            return;
        L5:
            if (this.mStopQueued == false) goto L7;
            return;
        L7:
            if (this.mStarted == false) goto L9;
            return;
        L9:
            if (ActivityRecreator.queueOnStopIfNecessary(this.currentlyRecreatingToken, this.mRecreatingHashCode, r3) == false) goto L15;
            this.mStopQueued = true;
            this.currentlyRecreatingToken = null;
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity r1) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity r1, Bundle r2) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity r2) {
            if (this.mActivity != r2) goto L6;
            this.mStarted = true;
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity r1) {
        }
    }

    static {
        mainHandler = new Handler(Looper.getMainLooper());
        Class<?> r0 = getActivityThreadClass();
        activityThreadClass = r0;
        mainThreadField = getMainThreadField();
        tokenField = getTokenField();
        performStopActivity3ParamsMethod = getPerformStopActivity3Params(r0);
        performStopActivity2ParamsMethod = getPerformStopActivity2Params(r0);
        requestRelaunchActivityMethod = getRequestRelaunchActivityMethod(r0);
    }

    private ActivityRecreator() {
    }

    private static Class<?> getActivityThreadClass() {
        return Class.forName("android.app.ActivityThread");
    L4:
        return null;
    }

    private static Field getMainThreadField() {
        Field r0 = Activity.class.getDeclaredField("mMainThread");     // Catch: Throwable -> L4
        r0.setAccessible(true);     // Catch: Throwable -> L4
        return r0;
    L4:
        return null;
    }

    private static Method getPerformStopActivity2Params(Class<?> r5) {
        if (r5 != null) goto L8;
        return null;
    L8:
        Method r6 = r5.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE});     // Catch: Throwable -> L7
        r6.setAccessible(true);     // Catch: Throwable -> L7
        return r6;
    L7:
        return null;
    }

    private static Method getPerformStopActivity3Params(Class<?> r6) {
        if (r6 != null) goto L8;
        return null;
    L8:
        Method r7 = r6.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE, String.class});     // Catch: Throwable -> L7
        r7.setAccessible(true);     // Catch: Throwable -> L7
        return r7;
    L7:
        return null;
    }

    private static Method getRequestRelaunchActivityMethod(Class<?> r7) {
        if (needsRelaunchCall() == false) goto L8;
        if (r7 == null) goto L8;
        Class<?> r5 = Boolean.TYPE;     // Catch: Throwable -> L9
        Method r8 = r7.getDeclaredMethod("requestRelaunchActivity", new Class[]{IBinder.class, List.class, List.class, Integer.TYPE, r5, Configuration.class, Configuration.class, r5, r5});     // Catch: Throwable -> L9
        r8.setAccessible(true);     // Catch: Throwable -> L9
        return r8;
    L8:
        return null;
    }

    private static Field getTokenField() {
        Field r0 = Activity.class.getDeclaredField("mToken");     // Catch: Throwable -> L4
        r0.setAccessible(true);     // Catch: Throwable -> L4
        return r0;
    L4:
        return null;
    }

    private static boolean needsRelaunchCall() {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 != 26) goto L5;
    L8:
        return true;
    L5:
        if (r0 == 27) goto L8;
        return false;
    }

    protected static boolean queueOnStopIfNecessary(Object r2, int r3, Activity r4) {
        final Object r1 = tokenField.get(r4);     // Catch: Throwable -> L12
        if (r1 == r2) goto L6;
    L11:
        return false;
    L6:
        if (r4.hashCode() != r3) goto L11;
        final Object r5 = mainThreadField.get(r4);     // Catch: Throwable -> L12
        mainHandler.postAtFrontOfQueue(new AnonymousClass3(r5, r1));     // Catch: Throwable -> L12
        return true;
    L12:
        th = move-exception;
        Log.e(LOG_TAG, "Exception while fetching field values", th);
        return false;
    }

    static boolean recreate(@NonNull Activity r10) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        r10.recreate();
        return true;
    L7:
        if (needsRelaunchCall() == false) goto L12;
        if (requestRelaunchActivityMethod != null) goto L12;
        return false;
    L12:
        if (performStopActivity2ParamsMethod == null) goto L14;
    L33:
        final Object r0 = tokenField.get(r10);     // Catch: Throwable -> L32
        if (r0 != null) goto L19;
        return false;
    L19:
        Object r3 = mainThreadField.get(r10);     // Catch: Throwable -> L32
        if (r3 != null) goto L22;
        return false;
    L22:
        final Application r4 = r10.getApplication();     // Catch: Throwable -> L32
        final LifecycleCheckCallbacks r5 = new LifecycleCheckCallbacks(r10);     // Catch: Throwable -> L32
        r4.registerActivityLifecycleCallbacks(r5);     // Catch: Throwable -> L32
        Handler r6 = mainHandler;     // Catch: Throwable -> L32
        r6.post(new AnonymousClass1(r5, r0));     // Catch: Throwable -> L32
    L29:
        th = move-exception;
        mainHandler.post(new AnonymousClass2(r4, r5));     // Catch: Throwable -> L32
        throw th;     // Catch: Throwable -> L32
    L24:
        if (needsRelaunchCall() == false) goto L26;
        Method r11 = requestRelaunchActivityMethod;     // Catch: Throwable -> L29
        Boolean r9 = Boolean.FALSE;     // Catch: Throwable -> L29
        r11.invoke(r3, new Object[]{r0, null, null, 0, r9, null, null, r9, r9});     // Catch: Throwable -> L29
    L27:
        r6.post(new AnonymousClass2(r4, r5));     // Catch: Throwable -> L32
        return true;
    L26:
        r10.recreate();     // Catch: Throwable -> L29
    L32:
        return false;
    L14:
        if (performStopActivity3ParamsMethod != null) goto L33;
        return false;
    }
}
