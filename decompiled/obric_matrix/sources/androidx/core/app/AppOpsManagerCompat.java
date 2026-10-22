package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class AppOpsManagerCompat {
    public static final int MODE_ALLOWED = 0;
    public static final int MODE_DEFAULT = 3;
    public static final int MODE_ERRORED = 2;
    public static final int MODE_IGNORED = 1;

    @RequiresApi(19)
    static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        static int noteOp(AppOpsManager r0, String r1, int r2, String r3) {
            return r0.noteOp(r1, r2, r3);
        }

        @DoNotInline
        static int noteOpNoThrow(AppOpsManager r0, String r1, int r2, String r3) {
            return r0.noteOpNoThrow(r1, r2, r3);
        }
    }

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static <T> T getSystemService(Context r0, Class<T> r1) {
            return (T) r0.getSystemService(r1);
        }

        @DoNotInline
        static int noteProxyOp(AppOpsManager r0, String r1, String r2) {
            return r0.noteProxyOp(r1, r2);
        }

        @DoNotInline
        static int noteProxyOpNoThrow(AppOpsManager r0, String r1, String r2) {
            return r0.noteProxyOpNoThrow(r1, r2);
        }

        @DoNotInline
        static String permissionToOp(String r0) {
            return AppOpsManager.permissionToOp(r0);
        }
    }

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static int checkOpNoThrow(@Nullable AppOpsManager r0, @NonNull String r1, int r2, @NonNull String r3) {
            if (r0 != null) goto L6;
            return 1;
        L6:
            return r0.checkOpNoThrow(r1, r2, r3);
        }

        @NonNull
        @DoNotInline
        static String getOpPackageName(@NonNull Context r0) {
            return r0.getOpPackageName();
        }

        @Nullable
        @DoNotInline
        static AppOpsManager getSystemService(@NonNull Context r1) {
            return (AppOpsManager) r1.getSystemService(AppOpsManager.class);
        }
    }

    private AppOpsManagerCompat() {
    }

    public static int checkOrNoteProxyOp(@NonNull Context r2, int r3, @NonNull String r4, @NonNull String r5) {
        if (Build.VERSION.SDK_INT < 29) goto L10;
        AppOpsManager r0 = Api29Impl.getSystemService(r2);
        int r6 = Api29Impl.checkOpNoThrow(r0, r4, Binder.getCallingUid(), r5);
        if (r6 == 0) goto L8;
        return r6;
    L8:
        return Api29Impl.checkOpNoThrow(r0, r4, r3, Api29Impl.getOpPackageName(r2));
    L10:
        return noteProxyOpNoThrow(r2, r4, r5);
    }

    public static int noteOp(@NonNull Context r2, @NonNull String r3, int r4, @NonNull String r5) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return 1;
    L5:
        return Api19Impl.noteOp((AppOpsManager) r2.getSystemService("appops"), r3, r4, r5);
    }

    public static int noteOpNoThrow(@NonNull Context r2, @NonNull String r3, int r4, @NonNull String r5) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return 1;
    L5:
        return Api19Impl.noteOpNoThrow((AppOpsManager) r2.getSystemService("appops"), r3, r4, r5);
    }

    public static int noteProxyOp(@NonNull Context r2, @NonNull String r3, @NonNull String r4) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return 1;
    L5:
        return Api23Impl.noteProxyOp((AppOpsManager) Api23Impl.getSystemService(r2, AppOpsManager.class), r3, r4);
    }

    public static int noteProxyOpNoThrow(@NonNull Context r2, @NonNull String r3, @NonNull String r4) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return 1;
    L5:
        return Api23Impl.noteProxyOpNoThrow((AppOpsManager) Api23Impl.getSystemService(r2, AppOpsManager.class), r3, r4);
    }

    @Nullable
    public static String permissionToOp(@NonNull String r2) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return null;
    L5:
        return Api23Impl.permissionToOp(r2);
    }
}
