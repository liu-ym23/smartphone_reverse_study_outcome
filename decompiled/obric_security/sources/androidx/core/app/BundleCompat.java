package androidx.core.app;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class BundleCompat {

    static class Api18Impl {
        private Api18Impl() {
        }

        static IBinder getBinder(Bundle r0, String r1) {
            return r0.getBinder(r1);
        }

        static void putBinder(Bundle r0, String r1, IBinder r2) {
            r0.putBinder(r1, r2);
        }
    }

    static class BeforeApi18Impl {
        private static final String TAG = "BundleCompatBaseImpl";
        private static Method sGetIBinderMethod;
        private static boolean sGetIBinderMethodFetched;
        private static Method sPutIBinderMethod;
        private static boolean sPutIBinderMethodFetched;

        private BeforeApi18Impl() {
        }

        public static IBinder getBinder(Bundle r7, String r8) {
            if (sGetIBinderMethodFetched == false) goto L16;
        L9:
            Method r0 = sGetIBinderMethod;
            if (r0 != null) goto L18;
        L15:
            return null;
        L18:
            return (IBinder) r0.invoke(r7, new Object[]{r8});
        L13:
            e = move-exception;
            Log.i(TAG, "Failed to invoke getIBinder via reflection", e);
            sGetIBinderMethod = null;
            goto L15
        L16:
            Method r1 = Bundle.class.getMethod("getIBinder", new Class[]{String.class});     // Catch: NoSuchMethodException -> L6
            sGetIBinderMethod = r1;     // Catch: NoSuchMethodException -> L6
            r1.setAccessible(true);     // Catch: NoSuchMethodException -> L6
        L8:
            sGetIBinderMethodFetched = true;
        L6:
            e = move-exception;
            Log.i(TAG, "Failed to retrieve getIBinder method", e);
            goto L8
        }

        public static void putBinder(Bundle r8, String r9, IBinder r10) {
            if (sPutIBinderMethodFetched == false) goto L18;
        L9:
            Method r0 = sPutIBinderMethod;
            if (r0 == null) goto L20;
            r0.invoke(r8, new Object[]{r9, r10});     // Catch: Throwable -> L13
            return;
        L13:
            e = move-exception;
            Log.i(TAG, "Failed to invoke putIBinder via reflection", e);
            sPutIBinderMethod = null;
            return;
        L20:
            return;
        L18:
            Method r1 = Bundle.class.getMethod("putIBinder", new Class[]{String.class, IBinder.class});     // Catch: NoSuchMethodException -> L6
            sPutIBinderMethod = r1;     // Catch: NoSuchMethodException -> L6
            r1.setAccessible(true);     // Catch: NoSuchMethodException -> L6
        L8:
            sPutIBinderMethodFetched = true;
        L6:
            e = move-exception;
            Log.i(TAG, "Failed to retrieve putIBinder method", e);
            goto L8
        }
    }

    private BundleCompat() {
    }

    public static IBinder getBinder(Bundle r0, String r1) {
        return Api18Impl.getBinder(r0, r1);
    }

    public static void putBinder(Bundle r0, String r1, IBinder r2) {
        Api18Impl.putBinder(r0, r1, r2);
    }
}
