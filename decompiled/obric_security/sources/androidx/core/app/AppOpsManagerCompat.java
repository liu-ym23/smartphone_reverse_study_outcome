package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;

/* JADX INFO: loaded from: classes.dex */
public final class AppOpsManagerCompat {
    public static final int MODE_ALLOWED = 0;
    public static final int MODE_DEFAULT = 3;
    public static final int MODE_ERRORED = 2;
    public static final int MODE_IGNORED = 1;

    static class Api19Impl {
        private Api19Impl() {
        }

        static int noteOpNoThrow(AppOpsManager r0, String r1, int r2, String r3) {
            return r0.noteOpNoThrow(r1, r2, r3);
        }

        static int noteOp(AppOpsManager r0, String r1, int r2, String r3) {
            return r0.noteOp(r1, r2, r3);
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static String permissionToOp(String r0) {
            return AppOpsManager.permissionToOp(r0);
        }

        static <T> T getSystemService(Context r0, Class<T> r1) {
            return (T) r0.getSystemService(r1);
        }

        static int noteProxyOp(AppOpsManager r0, String r1, String r2) {
            return r0.noteProxyOp(r1, r2);
        }

        static int noteProxyOpNoThrow(AppOpsManager r0, String r1, String r2) {
            return r0.noteProxyOpNoThrow(r1, r2);
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static AppOpsManager getSystemService(Context r1) {
            return (AppOpsManager) r1.getSystemService(AppOpsManager.class);
        }

        static int checkOpNoThrow(AppOpsManager r0, String r1, int r2, String r3) {
            if (r0 != null) goto L6;
            return 1;
        L6:
            return r0.checkOpNoThrow(r1, r2, r3);
        }

        static String getOpPackageName(Context r0) {
            return r0.getOpPackageName();
        }
    }

    private AppOpsManagerCompat() {
    }

    public static String permissionToOp(String r0) {
        return Api23Impl.permissionToOp(r0);
    }

    public static int noteOp(Context r1, String r2, int r3, String r4) {
        return Api19Impl.noteOp((AppOpsManager) r1.getSystemService("appops"), r2, r3, r4);
    }

    public static int noteOpNoThrow(Context r1, String r2, int r3, String r4) {
        return Api19Impl.noteOpNoThrow((AppOpsManager) r1.getSystemService("appops"), r2, r3, r4);
    }

    public static int noteProxyOp(Context r1, String r2, String r3) {
        return Api23Impl.noteProxyOp((AppOpsManager) Api23Impl.getSystemService(r1, AppOpsManager.class), r2, r3);
    }

    public static int noteProxyOpNoThrow(Context r1, String r2, String r3) {
        return Api23Impl.noteProxyOpNoThrow((AppOpsManager) Api23Impl.getSystemService(r1, AppOpsManager.class), r2, r3);
    }

    public static int checkOrNoteProxyOp(Context r2, int r3, String r4, String r5) {
        AppOpsManager r0 = Api29Impl.getSystemService(r2);
        int r6 = Api29Impl.checkOpNoThrow(r0, r4, Binder.getCallingUid(), r5);
        if (r6 == 0) goto L6;
        return r6;
    L6:
        return Api29Impl.checkOpNoThrow(r0, r4, r3, Api29Impl.getOpPackageName(r2));
    }
}
