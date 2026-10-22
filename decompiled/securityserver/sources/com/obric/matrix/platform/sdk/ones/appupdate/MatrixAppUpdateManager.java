package com.obric.matrix.platform.sdk.ones.appupdate;

import android.app.Activity;
import com.obric.appstore.autoupdate.ObricAutoUpdateUtils;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class MatrixAppUpdateManager {

    @NotNull
    public static final MatrixAppUpdateManager INSTANCE = null;

    @NotNull
    private static final String TAG = "MatrixAppUpdateManager";

    static {
        INSTANCE = new MatrixAppUpdateManager();
    }

    private MatrixAppUpdateManager() {
    }

    public final void abortUpdate() {
        ObricAutoUpdateUtils r2 = ObricAutoUpdateUtils.b();     // Catch: Exception -> L6
        ObricAutoUpdateUtils.AutoUpdateTask r0 = r2.f94a;     // Catch: Exception -> L6
        if (r0 == null) goto L11;
        r0.cancel(true);     // Catch: Exception -> L6
        r2.f94a = null;     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        MLog.e(TAG, "abortUpdate error", e);
    }

    public final void checkUpdate(@NotNull Activity r2) {
        Intrinsics.f(r2, "activity");
        ObricAutoUpdateUtils.b().c(r2, r2.getPackageName());     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        MLog.e(TAG, "checkUpdate error", e);
    }
}
