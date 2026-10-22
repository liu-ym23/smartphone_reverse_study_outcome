package androidx.core.content;

import android.content.Context;
import android.os.Binder;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.app.AppOpsManagerCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class PermissionChecker {
    public static final int PERMISSION_DENIED = -1;
    public static final int PERMISSION_DENIED_APP_OP = -2;
    public static final int PERMISSION_GRANTED = 0;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface PermissionResult {
    }

    private PermissionChecker() {
    }

    public static int checkCallingOrSelfPermission(@NonNull Context r3, @NonNull String r4) {
        if (Binder.getCallingPid() != Process.myPid()) goto L5;
        String r0 = r3.getPackageName();
    L7:
        return checkPermission(r3, r4, Binder.getCallingPid(), Binder.getCallingUid(), r0);
    L5:
        r0 = null;
        goto L7
    }

    public static int checkCallingPermission(@NonNull Context r2, @NonNull String r3, @Nullable String r4) {
        if (Binder.getCallingPid() != Process.myPid()) goto L7;
        return -1;
    L7:
        return checkPermission(r2, r3, Binder.getCallingPid(), Binder.getCallingUid(), r4);
    }

    public static int checkPermission(@NonNull Context r1, @NonNull String r2, int r3, int r4, @Nullable String r5) {
        if (r1.checkPermission(r2, r3, r4) != (-1)) goto L5;
        return -1;
    L5:
        String r6 = AppOpsManagerCompat.permissionToOp(r2);
        if (r6 != null) goto L8;
        return 0;
    L8:
        if (r5 != null) goto L17;
        String[] r7 = r1.getPackageManager().getPackagesForUid(r4);
        if (r7 != null) goto L12;
    L15:
        return -1;
    L12:
        if (r7.length <= 0) goto L15;
        r5 = r7[0];
    L17:
        if (AppOpsManagerCompat.noteProxyOpNoThrow(r1, r6, r5) == 0) goto L20;
        return -2;
    L20:
        return 0;
    }

    public static int checkSelfPermission(@NonNull Context r3, @NonNull String r4) {
        return checkPermission(r3, r4, Process.myPid(), Process.myUid(), r3.getPackageName());
    }
}
