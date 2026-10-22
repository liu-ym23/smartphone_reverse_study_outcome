package androidx.core.telephony;

import android.annotation.SuppressLint;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class TelephonyManagerCompat {
    private static Method sGetDeviceIdMethod;
    private static Method sGetSubIdMethod;

    @RequiresApi(23)
    private static class Api23Impl {
        private Api23Impl() {
        }

        @SuppressLint({"MissingPermission"})
        @Nullable
        @RequiresPermission("android.permission.READ_PHONE_STATE")
        @DoNotInline
        static String getDeviceId(TelephonyManager r0, int r1) {
            return r0.getDeviceId(r1);
        }
    }

    @RequiresApi(26)
    private static class Api26Impl {
        private Api26Impl() {
        }

        @SuppressLint({"MissingPermission"})
        @Nullable
        @RequiresPermission("android.permission.READ_PHONE_STATE")
        @DoNotInline
        static String getImei(TelephonyManager r0) {
            return r0.getImei();
        }
    }

    @RequiresApi(30)
    private static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        static int getSubscriptionId(TelephonyManager r0) {
            return r0.getSubscriptionId();
        }
    }

    private TelephonyManagerCompat() {
    }

    @Nullable
    @RequiresPermission("android.permission.READ_PHONE_STATE")
    @SuppressLint({"MissingPermission"})
    public static String getImei(@NonNull TelephonyManager r7) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 26) goto L7;
        return Api26Impl.getImei(r7);
    L7:
        if (r0 < 22) goto L24;
        int r1 = getSubscriptionId(r7);
        if (r1 == Integer.MAX_VALUE) goto L24;
        if (r1 == (-1)) goto L24;
        int r2 = SubscriptionManagerCompat.getSlotIndex(r1);
        if (r0 >= 23) goto L15;
    L21:
        return null;
    L17:
        if (sGetDeviceIdMethod != null) goto L19;
        Method r3 = TelephonyManager.class.getDeclaredMethod("getDeviceId", new Class[]{Integer.TYPE});     // Catch: Throwable -> L21
        sGetDeviceIdMethod = r3;     // Catch: Throwable -> L21
        r3.setAccessible(true);     // Catch: Throwable -> L21
    L19:
        return (String) sGetDeviceIdMethod.invoke(r7, new Object[]{Integer.valueOf(r2)});
    L15:
        return Api23Impl.getDeviceId(r7, r2);
    L24:
        return r7.getDeviceId();
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    public static int getSubscriptionId(@NonNull TelephonyManager r4) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 30) goto L7;
        return Api30Impl.getSubscriptionId(r4);
    L7:
        if (r0 >= 22) goto L20;
        return Integer.MAX_VALUE;
    L20:
        if (sGetSubIdMethod != null) goto L11;
        Method r1 = TelephonyManager.class.getDeclaredMethod("getSubId", new Class[0]);     // Catch: Throwable -> L19
        sGetSubIdMethod = r1;     // Catch: Throwable -> L19
        r1.setAccessible(true);     // Catch: Throwable -> L19
    L11:
        Integer r5 = (Integer) sGetSubIdMethod.invoke(r4, new Object[0]);     // Catch: Throwable -> L19
        if (r5 != null) goto L14;
        return Integer.MAX_VALUE;
    L14:
        if (r5.intValue() == (-1)) goto L23;
        return r5.intValue();
    L23:
        return Integer.MAX_VALUE;
    L24:
        return Integer.MAX_VALUE;
    }
}
