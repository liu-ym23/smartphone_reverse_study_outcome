package androidx.core.app;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class BundleCompat {

    public static class BundleCompatBaseImpl {
        private static final String TAG = "BundleCompatBaseImpl";
        private static Method sGetIBinderMethod;
        private static boolean sGetIBinderMethodFetched;
        private static Method sPutIBinderMethod;
        private static boolean sPutIBinderMethodFetched;

        private BundleCompatBaseImpl() {
        }

        public static IBinder getBinder(Bundle r5, String r6) {
            if (sGetIBinderMethodFetched == false) goto L17;
        L10:
            Method r0 = sGetIBinderMethod;
            if (r0 != null) goto L19;
        L16:
            return null;
        L19:
            return (IBinder) r0.invoke(r5, new Object[]{r6});
        L14:
            e = move-exception;
            Log.i(TAG, "Failed to invoke getIBinder via reflection", e);
            sGetIBinderMethod = null;
            goto L16
        L17:
            Method r2 = Bundle.class.getMethod("getIBinder", new Class[]{String.class});     // Catch: NoSuchMethodException -> L7
            sGetIBinderMethod = r2;     // Catch: NoSuchMethodException -> L7
            r2.setAccessible(true);     // Catch: NoSuchMethodException -> L7
        L9:
            sGetIBinderMethodFetched = true;
        L7:
            e = move-exception;
            Log.i(TAG, "Failed to retrieve getIBinder method", e);
            goto L9
        }

        public static void putBinder(Bundle r6, String r7, IBinder r8) {
            if (sPutIBinderMethodFetched == false) goto L17;
        L10:
            Method r0 = sPutIBinderMethod;
            if (r0 == null) goto L21;
            r0.invoke(r6, new Object[]{r7, r8});     // Catch: Throwable -> L14
            return;
        L14:
            e = move-exception;
            Log.i(TAG, "Failed to invoke putIBinder via reflection", e);
            sPutIBinderMethod = null;
            return;
        L21:
            return;
        L17:
            Method r2 = Bundle.class.getMethod("putIBinder", new Class[]{String.class, IBinder.class});     // Catch: NoSuchMethodException -> L7
            sPutIBinderMethod = r2;     // Catch: NoSuchMethodException -> L7
            r2.setAccessible(true);     // Catch: NoSuchMethodException -> L7
        L9:
            sPutIBinderMethodFetched = true;
        L7:
            e = move-exception;
            Log.i(TAG, "Failed to retrieve putIBinder method", e);
            goto L9
        }
    }

    private BundleCompat() {
    }

    @Nullable
    public static IBinder getBinder(@NonNull Bundle r0, @Nullable String r1) {
        return r0.getBinder(r1);
    }

    public static void putBinder(@NonNull Bundle r0, @Nullable String r1, @Nullable IBinder r2) {
        r0.putBinder(r1, r2);
    }
}
