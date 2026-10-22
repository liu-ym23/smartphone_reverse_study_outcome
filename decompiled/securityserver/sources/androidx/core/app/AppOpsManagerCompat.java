package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class AppOpsManagerCompat {
    public static final int MODE_ALLOWED = 0;
    public static final int MODE_DEFAULT = 3;
    public static final int MODE_ERRORED = 2;
    public static final int MODE_IGNORED = 1;

    private AppOpsManagerCompat() {
    }

    public static int noteOp(@NonNull Context r1, @NonNull String r2, int r3, @NonNull String r4) {
        return ((AppOpsManager) r1.getSystemService("appops")).noteOp(r2, r3, r4);
    }

    public static int noteOpNoThrow(@NonNull Context r1, @NonNull String r2, int r3, @NonNull String r4) {
        return ((AppOpsManager) r1.getSystemService("appops")).noteOpNoThrow(r2, r3, r4);
    }

    public static int noteProxyOp(@NonNull Context r1, @NonNull String r2, @NonNull String r3) {
        return ((AppOpsManager) r1.getSystemService(AppOpsManager.class)).noteProxyOp(r2, r3);
    }

    public static int noteProxyOpNoThrow(@NonNull Context r1, @NonNull String r2, @NonNull String r3) {
        return ((AppOpsManager) r1.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(r2, r3);
    }

    @Nullable
    public static String permissionToOp(@NonNull String r0) {
        return AppOpsManager.permissionToOp(r0);
    }
}
