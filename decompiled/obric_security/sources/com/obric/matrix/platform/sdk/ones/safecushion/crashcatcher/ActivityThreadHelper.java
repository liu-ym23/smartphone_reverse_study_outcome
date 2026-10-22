package com.obric.matrix.platform.sdk.ones.safecushion.crashcatcher;

import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import com.obric.matrix.platform.sdk.ones.safecushion.SafeCushionConstant;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActivityThreadHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J1\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0010\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\u000fH\u0002¢\u0006\u0002\u0010\u0010J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0002J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/safecushion/crashcatcher/ActivityThreadHelper;", "", "()V", "ACTIVITY_THREAD_CLASS", "", "APP_CALLBACK_CLASS", "METHOD_ON_HANDLE_EXCEPTION", "TAG", "dispatchOnHandleException", "", "callback", "Lcom/obric/matrix/platform/sdk/ones/safecushion/crashcatcher/ActivityThreadHelper$AppCallback;", "method", "Ljava/lang/reflect/Method;", "args", "", "(Lcom/obric/matrix/platform/sdk/ones/safecushion/crashcatcher/ActivityThreadHelper$AppCallback;Ljava/lang/reflect/Method;[Ljava/lang/Object;)V", "formatCallbackArg", "arg", "getActivityThreadInstance", "handleAppException", "", "type", "removeAppCallback", "setAppCallback", "AppCallback", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ActivityThreadHelper {
    private static final String ACTIVITY_THREAD_CLASS = "android.app.ActivityThread";
    private static final String APP_CALLBACK_CLASS = "android.app.ActivityThread$AppCallback";
    public static final ActivityThreadHelper INSTANCE = null;
    private static final String METHOD_ON_HANDLE_EXCEPTION = "onHandleException";
    private static final String TAG = "ActivityThreadHelper";

    /* JADX INFO: compiled from: ActivityThreadHelper.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/safecushion/crashcatcher/ActivityThreadHelper$AppCallback;", "", ActivityThreadHelper.METHOD_ON_HANDLE_EXCEPTION, "", "type", "", SafeCushionConstant.CRASH_INFO_FILE_NAME_PREFIX, "throwable", "", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface AppCallback {
        void onHandleException(String r1);

        void onHandleException(String r1, String r2);

        void onHandleException(String r1, Throwable r2);
    }

    static {
        INSTANCE = new ActivityThreadHelper();
    }

    private ActivityThreadHelper() {
    }

    public static final /* synthetic */ void access$dispatchOnHandleException(ActivityThreadHelper r0, AppCallback r1, Method r2, Object[] r3) {
        r0.dispatchOnHandleException(r1, r2, r3);
    }

    public final boolean setAppCallback(final AppCallback r10) {
        Intrinsics.checkNotNullParameter(r10, "callback");
        MLog.i$default(TAG, "setAppCallback start, callback=" + r10.getClass().getName(), null, 4, null);
        Object r9 = getActivityThreadInstance();     // Catch: Exception -> L9
        if (r9 != null) goto L7;
        MLog.i$default(TAG, "setAppCallback failed, activityThread is null", null, 4, null);     // Catch: Exception -> L9
        return false;
    L7:
        Class<?> r4 = Class.forName(APP_CALLBACK_CLASS);     // Catch: Exception -> L9
        Class.forName(ACTIVITY_THREAD_CLASS).getMethod("setAPPCallback", new Class[]{r4}).invoke(r9, new Object[]{Proxy.newProxyInstance(r4.getClassLoader(), new Class[]{r4}, new ActivityThreadHelper$setAppCallback$proxy$1(r10))});     // Catch: Exception -> L9
        MLog.i$default(TAG, "setAppCallback success", null, 4, null);     // Catch: Exception -> L9
        return true;
    L9:
        e = move-exception;
        MLog.e(TAG, "setAppCallback error", e);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void dispatchOnHandleException(AppCallback r6, Method r7, Object[] r8) {
        Throwable r0 = null;
        String r1 = null;
        if (r7 == null) goto L5;
        String r2 = r7.getName();
    L7:
        if (Intrinsics.areEqual(r2, METHOD_ON_HANDLE_EXCEPTION) == true) goto L9;
        return;
    L9:
        if (r8 != null) goto L11;
    L17:
        Object[] r3 = true;
    L18:
        if (r3 == true) goto L49;
        Object r4 = r8[0];
        if ((r4 instanceof String) == false) goto L23;
        String r5 = (String) r4;
    L24:
        if (r5 != null) goto L26;
        return;
    L26:
        MLog.i$default(TAG, "dispatchOnHandleException type=" + r5 + ", paramCount=" + r7.getParameterTypes().length + ", extra=" + formatCallbackArg(ArraysKt.getOrNull(r8, 1)), null, 4, null);
        int r9 = r7.getParameterTypes().length;
        if (r9 != 1) goto L29;
        r6.onHandleException(r5);
        return;
    L29:
        if (r9 != 2) goto L50;
        Class<?> r10 = r7.getParameterTypes()[1];
        if (Intrinsics.areEqual(r10, String.class) == false) goto L38;
        Object r11 = ArraysKt.getOrNull(r8, 1);
        if ((r11 instanceof String) == false) goto L36;
        r1 = (String) r11;
    L36:
        r6.onHandleException(r5, r1);
        return;
    L38:
        if (Intrinsics.areEqual(r10, Throwable.class) == false) goto L47;
        Object r12 = ArraysKt.getOrNull(r8, 1);
        if ((r12 instanceof Throwable) == false) goto L42;
        r0 = (Throwable) r12;
    L42:
        r6.onHandleException(r5, r0);
        return;
    L47:
        return;
    L50:
        return;
    L23:
        r5 = null;
        goto L24
    L49:
        return;
    L11:
        if (r8.length != 0) goto L13;
        Object[] r13 = true;
    L14:
        if (r13 == true) goto L17;
        r3 = false;
        goto L18
    L13:
        r13 = false;
        goto L14
    L5:
        r2 = null;
        goto L7
    }

    private final String formatCallbackArg(Object r2) {
        if (r2 != null) goto L5;
        return "null";
    L5:
        if ((r2 instanceof Throwable) == false) goto L8;
        return r2.getClass().getName() + ':' + ((Throwable) r2).getMessage();
    L8:
        return r2.toString();
    }

    public final boolean removeAppCallback() {
        Object r6 = getActivityThreadInstance();     // Catch: Exception -> L8
        if (r6 != null) goto L6;
        return false;
    L6:
        Class<?> r1 = Class.forName(APP_CALLBACK_CLASS);     // Catch: Exception -> L8
        Class.forName(ACTIVITY_THREAD_CLASS).getMethod("removeAPPCallback", new Class[]{r1}).invoke(r6, new Object[]{null});     // Catch: Exception -> L8
        return true;
    L8:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public final boolean handleAppException(String r7) {
        Intrinsics.checkNotNullParameter(r7, "type");
        Object r6 = getActivityThreadInstance();     // Catch: Exception -> L8
        if (r6 != null) goto L6;
        return false;
    L6:
        Class.forName(ACTIVITY_THREAD_CLASS).getMethod("handleAppException", new Class[]{String.class}).invoke(r6, new Object[]{r7});     // Catch: Exception -> L8
        return true;
    L8:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    private final Object getActivityThreadInstance() {
        return Class.forName(ACTIVITY_THREAD_CLASS).getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
