package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Process;
import android.os.UserHandle;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class ProcessCompat {

    @RequiresApi(16)
    static class Api16Impl {
        private static Method sMethodUserIdIsAppMethod;
        private static boolean sResolved;
        private static final Object sResolvedLock = null;

        static {
            sResolvedLock = new Object();
        }

        private Api16Impl() {
        }

        @SuppressLint({"PrivateApi"})
        static boolean isApplicationUid(int r7) {
            Object r1 = sResolvedLock;     // Catch: Exception -> L20
            monitor-enter(r1);     // Catch: Exception -> L20
        L17:
            th = move-exception;
            throw th;     // Catch: Exception -> L20
        L6:
            if (sResolved == true) goto L8;
            sResolved = true;     // Catch: Throwable -> L17
            sMethodUserIdIsAppMethod = Class.forName("android.os.UserId").getDeclaredMethod("isApp", new Class[]{Integer.TYPE});     // Catch: Throwable -> L17
        L8:
            monitor-exit(r1);     // Catch: Throwable -> L17
            Method r2 = sMethodUserIdIsAppMethod;     // Catch: Exception -> L20
            if (r2 == null) goto L22;
            Boolean r8 = (Boolean) r2.invoke(null, new Object[]{Integer.valueOf(r7)});     // Catch: Exception -> L20
            if (r8 == null) goto L16;
            return r8.booleanValue();
        L16:
            throw new NullPointerException();     // Catch: Exception -> L20
        L22:
            return true;
        L20:
            e = move-exception;
            e.printStackTrace();
            goto L22
        }
    }

    @RequiresApi(17)
    static class Api17Impl {
        private static Method sMethodUserHandleIsAppMethod;
        private static boolean sResolved;
        private static final Object sResolvedLock = null;

        static {
            sResolvedLock = new Object();
        }

        private Api17Impl() {
        }

        @SuppressLint({"DiscouragedPrivateApi"})
        static boolean isApplicationUid(int r7) {
            Object r1 = sResolvedLock;     // Catch: Exception -> L20
            monitor-enter(r1);     // Catch: Exception -> L20
        L17:
            th = move-exception;
            throw th;     // Catch: Exception -> L20
        L6:
            if (sResolved == true) goto L8;
            sResolved = true;     // Catch: Throwable -> L17
            sMethodUserHandleIsAppMethod = UserHandle.class.getDeclaredMethod("isApp", new Class[]{Integer.TYPE});     // Catch: Throwable -> L17
        L8:
            monitor-exit(r1);     // Catch: Throwable -> L17
            Method r2 = sMethodUserHandleIsAppMethod;     // Catch: Exception -> L20
            if (r2 == null) goto L22;
            Boolean r8 = (Boolean) r2.invoke(null, new Object[]{Integer.valueOf(r7)});     // Catch: Exception -> L20
            if (r8 == null) goto L16;
            return r8.booleanValue();
        L16:
            throw new NullPointerException();     // Catch: Exception -> L20
        L22:
            return true;
        L20:
            e = move-exception;
            e.printStackTrace();
            goto L22
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        static boolean isApplicationUid(int r0) {
            return Process.isApplicationUid(r0);
        }
    }

    private ProcessCompat() {
    }

    public static boolean isApplicationUid(int r2) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 24) goto L7;
        return Api24Impl.isApplicationUid(r2);
    L7:
        if (r0 < 17) goto L11;
        return Api17Impl.isApplicationUid(r2);
    L11:
        if (r0 == 16) goto L13;
        return true;
    L13:
        return Api16Impl.isApplicationUid(r2);
    }
}
