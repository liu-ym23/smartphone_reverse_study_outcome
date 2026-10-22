package androidx.core.telephony;

import android.telephony.TelephonyManager;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class TelephonyManagerCompat {
    private static Method sGetDeviceIdMethod;
    private static Method sGetSubIdMethod;

    private static class Api23Impl {
        private Api23Impl() {
        }

        static String getDeviceId(TelephonyManager r0, int r1) {
            return r0.getDeviceId(r1);
        }
    }

    private static class Api26Impl {
        private Api26Impl() {
        }

        static String getImei(TelephonyManager r0) {
            return r0.getImei();
        }
    }

    private static class Api30Impl {
        private Api30Impl() {
        }

        static int getSubscriptionId(TelephonyManager r0) {
            return r0.getSubscriptionId();
        }
    }

    public static String getImei(TelephonyManager r0) {
        return Api26Impl.getImei(r0);
    }

    public static int getSubscriptionId(TelephonyManager r0) {
        return Api30Impl.getSubscriptionId(r0);
    }

    private TelephonyManagerCompat() {
    }
}
